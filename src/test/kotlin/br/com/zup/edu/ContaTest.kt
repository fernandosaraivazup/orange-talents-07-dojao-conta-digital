package br.com.zup.edu

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

@MicronautTest
internal class ContaTest {

    @Test
    internal fun `nao deve creditar valor negativo`() {
        val conta = Conta("123", 123)
        val error = conta.credita(BigDecimal.valueOf(0))

        assertEquals(false, error)
    }

    @Test
    internal fun `deve ter id nulo`() {
        val conta = Conta("123", 123)

        assertNull(conta.id)
    }

    @Test
    internal fun `deve ter idCliente igual ao do construtor`() {
        val conta = Conta("123", 123)

        assertNotNull(conta.idCliente)
        assertEquals(123L, conta.idCliente)
    }
}