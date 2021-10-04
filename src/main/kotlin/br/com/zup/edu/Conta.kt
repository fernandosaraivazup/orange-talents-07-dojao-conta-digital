package br.com.zup.edu

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
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

    var saldo: BigDecimal = BigDecimal.ZERO

    fun deposita(valor: BigDecimal){
        if(valor > BigDecimal.ZERO){
            saldo += valor
        }
    }
}