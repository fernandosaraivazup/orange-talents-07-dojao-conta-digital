package br.com.zup.edu

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.math.BigDecimal
import java.util.*
import javax.persistence.OptimisticLockException

@MicronautTest(transactional = false)
internal class ContaDigitalControllerTest(
    val contaDigitalController: ContaDigitalController
) {

    @Inject
    lateinit var contaRepositoryMock: ContaRepository

    @Test
    internal fun `deve creditar numa conta`() {

        val conta = Conta("123", 1L)
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(50))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenReturn(conta)

        val response = contaDigitalController.creditar(operacaoRequest)

        with(response) {
            assertEquals(200, response.code())
        }

    }

    @Test
    internal fun `nao deve encontrar uma conta para creditar`() {

        val conta = Conta("124", 1L)
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(50))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.empty())

        val response = contaDigitalController.creditar(operacaoRequest)

        with(response) {
            assertEquals(404, response.code())
            assertEquals("Não foi possível encontrar a conta", response.body())
        }

    }

    @Test
    internal fun `nao deve creditar recurso concorrido (javax)`() {

        val conta = Conta("123", 1L)
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(25))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenThrow(OptimisticLockException())

        val response = contaDigitalController.creditar(operacaoRequest)

        with(response) {
            assertEquals(423, response.code())
            assertEquals("Este recurso já foi alterado.", response.body())
        }

    }

    @Test
    internal fun `nao deve creditar recurso concorrido (micronaut)`() {

        val conta = Conta("123", 1L)
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(25))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenThrow(io.micronaut.data.exceptions.OptimisticLockException::class.java)

        val response = contaDigitalController.creditar(operacaoRequest)

        with(response) {
            assertEquals(423, response.code())
            assertEquals("Este recurso já foi alterado.", response.body())
        }

    }

    @Test
    internal fun `deve debitar numa conta`() {

        val conta = Conta("123", 1L)
        conta.credita(BigDecimal.valueOf(100))
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(50))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenReturn(conta)

        val response = contaDigitalController.debitar(operacaoRequest)

        with(response) {
            assertEquals(200, response.code())
        }

    }

    @Test
    internal fun `nao deve encontrar uma conta para debitar`() {

        val conta = Conta("124", 1L)
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(50))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.empty())

        val response = contaDigitalController.debitar(operacaoRequest)

        with(response) {
            assertEquals(404, response.code())
            assertEquals("Não foi possível encontrar a conta", response.body())
        }

    }

    @Test
    internal fun `nao deve debitar de recurso concorrido (javax)`() {

        val conta = Conta("123", 1L)
        conta.credita(BigDecimal.valueOf(50))
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(25))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenThrow(OptimisticLockException())

        val response = contaDigitalController.debitar(operacaoRequest)

        with(response) {
            assertEquals(423, response.code())
            assertEquals("Este recurso já foi alterado.", response.body())
        }

    }

    @Test
    internal fun `nao deve debitar recurso concorrido (micronaut)`() {

        val conta = Conta("123", 1L)
        conta.credita(BigDecimal.valueOf(50))
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(25))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))
        Mockito.`when`(contaRepositoryMock.update(conta)).thenThrow(io.micronaut.data.exceptions.OptimisticLockException::class.java)

        val response = contaDigitalController.debitar(operacaoRequest)

        with(response) {
            assertEquals(423, response.code())
            assertEquals("Este recurso já foi alterado.", response.body())
        }

    }

    @Test
    internal fun `nao deve debitar se saldo for insuficiente`() {

        val conta = Conta("123", 1L)
        conta.credita(BigDecimal.valueOf(10))
        val operacaoRequest = OperacaoRequest("123", BigDecimal.valueOf(25))

        Mockito.`when`(contaRepositoryMock.findByNumeroConta(operacaoRequest.numeroConta)).thenReturn(Optional.of(conta))

        val response = contaDigitalController.debitar(operacaoRequest)

        with(response) {
            assertEquals(422, response.code())
            assertEquals("Saldo insuficiente.", response.body())
        }

    }



    @MockBean(ContaRepository::class) // bean a ser mockado
    fun contaRepositoryMock() : ContaRepository {
        return Mockito.mock(ContaRepository::class.java)
    }
}