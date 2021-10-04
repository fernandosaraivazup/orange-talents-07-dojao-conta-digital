package br.com.zup.edu

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface ContaRepository : JpaRepository<Conta, Long> {
    fun findByNumeroConta(numeroConta: String): Optional<Conta>
}