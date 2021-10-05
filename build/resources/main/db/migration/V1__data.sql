CREATE TABLE IF NOT EXISTS public.conta(
    id bigserial primary key,
    numero_conta varchar(255) not null,
    id_cliente bigint not null,
    saldo numeric(19,2),
    version bigint
);

INSERT INTO public.conta (numero_conta, id_cliente, saldo, version) VALUES('123', 1, 0.0, 0);
INSERT INTO public.conta (numero_conta, id_cliente, saldo, version) VALUES('456', 2, 0.0, 0);