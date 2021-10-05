package br.com.zup.edu

import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Conta(
    @field:NotBlank
    val numeroConta: String,
    @field:NotNull @field:Positive
    val idCliente: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Version
    var version: Long? = 0L

    var saldo: BigDecimal = BigDecimal.ZERO

    fun credita(valor: BigDecimal): Boolean{
        if(valor > BigDecimal.ZERO){
            saldo += valor
            return true
        }
        return false
    }

    fun debita(valor: BigDecimal): Boolean{
        if(valor <= saldo){
            saldo -= valor
            return true
        }
        return false
    }
}