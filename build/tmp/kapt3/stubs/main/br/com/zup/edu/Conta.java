package br.com.zup.edu;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lbr/com/zup/edu/Conta;", "", "numeroConta", "", "idCliente", "", "(Ljava/lang/String;J)V", "id", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getIdCliente", "()J", "getNumeroConta", "()Ljava/lang/String;", "saldo", "Ljava/math/BigDecimal;", "getSaldo", "()Ljava/math/BigDecimal;", "setSaldo", "(Ljava/math/BigDecimal;)V", "version", "getVersion", "setVersion", "credita", "", "valor", "debita", "otbank-conta-digital"})
@javax.persistence.Entity()
public final class Conta {
    @org.jetbrains.annotations.NotNull()
    @javax.validation.constraints.NotBlank()
    private final java.lang.String numeroConta = null;
    @javax.validation.constraints.Positive()
    @javax.validation.constraints.NotNull()
    private final long idCliente = 0L;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private java.lang.Long id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Version()
    private java.lang.Long version = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal saldo;
    
    public Conta(@org.jetbrains.annotations.NotNull()
    java.lang.String numeroConta, long idCliente) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNumeroConta() {
        return null;
    }
    
    public final long getIdCliente() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getVersion() {
        return null;
    }
    
    public final void setVersion(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getSaldo() {
        return null;
    }
    
    public final void setSaldo(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final boolean credita(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor) {
        return false;
    }
    
    public final boolean debita(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor) {
        return false;
    }
}