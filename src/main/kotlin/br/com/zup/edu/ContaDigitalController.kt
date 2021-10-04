package br.com.zup.edu

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/conta-digital")
class ContaDigitalController(val contaRepository: ContaRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @Post("/deposita")
    fun deposita(@Valid depositoRequest: DepositoRequest): HttpResponse<Any>{

        val possivelConta = contaRepository.findByNumeroConta(depositoRequest.numeroConta)

        logger.info("Procurando conta: ${depositoRequest.numeroConta}")

        if(!possivelConta.isPresent){
            return HttpResponse.badRequest("Não foi possível encontrar a conta")
        }
        val conta = possivelConta.get();
        logger.info("Conta encontrada: ${conta.numeroConta}")

        conta.deposita(depositoRequest.valor)

        contaRepository.update(conta)

        return HttpResponse.ok()
    }
}