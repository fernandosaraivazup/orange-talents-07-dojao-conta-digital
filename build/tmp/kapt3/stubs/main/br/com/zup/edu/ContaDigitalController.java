package br.com.zup.edu;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lbr/com/zup/edu/ContaDigitalController;", "", "contaRepository", "Lbr/com/zup/edu/ContaRepository;", "(Lbr/com/zup/edu/ContaRepository;)V", "getContaRepository", "()Lbr/com/zup/edu/ContaRepository;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "creditar", "Lio/micronaut/http/HttpResponse;", "operacaoRequest", "Lbr/com/zup/edu/OperacaoRequest;", "debitar", "otbank-conta-digital"})
@io.micronaut.http.annotation.Controller(value = "/api/conta-digital")
@io.micronaut.validation.Validated()
public class ContaDigitalController {
    @org.jetbrains.annotations.NotNull()
    private final br.com.zup.edu.ContaRepository contaRepository = null;
    private final org.slf4j.Logger logger = null;
    
    public ContaDigitalController(@org.jetbrains.annotations.NotNull()
    br.com.zup.edu.ContaRepository contaRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public br.com.zup.edu.ContaRepository getContaRepository() {
        return null;
    }
    
    public org.slf4j.Logger getLogger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.micronaut.http.annotation.Post(value = "/credita")
    public io.micronaut.http.HttpResponse<java.lang.Object> creditar(@org.jetbrains.annotations.NotNull()
    @javax.validation.Valid()
    br.com.zup.edu.OperacaoRequest operacaoRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.micronaut.http.annotation.Post(value = "/debita")
    public io.micronaut.http.HttpResponse<java.lang.Object> debitar(@org.jetbrains.annotations.NotNull()
    @javax.validation.Valid()
    br.com.zup.edu.OperacaoRequest operacaoRequest) {
        return null;
    }
}