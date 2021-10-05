package br.com.zup.edu

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import io.micronaut.http.HttpStatus
import javax.persistence.OptimisticLockException
import javax.validation.Valid

@Validated
@Controller("/api/conta-digital")
class ContaDigitalController(val contaRepository: ContaRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @Post("/credita")
    fun creditar(@Valid operacaoRequest: OperacaoRequest): HttpResponse<Any>{

        val possivelConta = contaRepository.findByNumeroConta(operacaoRequest.numeroConta)

        logger.info("Procurando conta: ${operacaoRequest.numeroConta}")

        if(!possivelConta.isPresent){
            return HttpResponse.notFound("Não foi possível encontrar a conta")
        }
        val conta = possivelConta.get();
        logger.info("Conta encontrada: ${conta.numeroConta}")

        val creditou = conta.credita(operacaoRequest.valor)

        try {
            contaRepository.update(conta)
        } catch (e: OptimisticLockException){
            return HttpResponse.status<Any?>(HttpStatus.LOCKED).body("Este recurso já foi alterado.")
        } catch (e: io.micronaut.data.exceptions.OptimisticLockException){
            return HttpResponse.status<Any?>(HttpStatus.LOCKED).body("Este recurso já foi alterado.")
        }
        return HttpResponse.ok()
    }

    @Post("/debita")
    fun debitar(@Valid operacaoRequest: OperacaoRequest): HttpResponse<Any>{
        val possivelConta = contaRepository.findByNumeroConta(operacaoRequest.numeroConta)

        logger.info("Procurando conta: ${operacaoRequest.numeroConta}")

        if(!possivelConta.isPresent){
            return HttpResponse.notFound("Não foi possível encontrar a conta")
        }
        val conta = possivelConta.get();
        logger.info("Conta encontrada: ${conta.numeroConta}")

        val debitou = conta.debita(operacaoRequest.valor)

        if(!debitou){
            return HttpResponse.status<Any?>(HttpStatus.UNPROCESSABLE_ENTITY).body("Saldo insuficiente.")
        }

        try {
            contaRepository.update(conta)
        } catch (e: OptimisticLockException){
            return HttpResponse.status<Any?>(HttpStatus.LOCKED).body("Este recurso já foi alterado.")
        } catch (e: io.micronaut.data.exceptions.OptimisticLockException){
            return HttpResponse.status<Any?>(HttpStatus.LOCKED).body("Este recurso já foi alterado.")
        }
        return HttpResponse.ok()
    }
}