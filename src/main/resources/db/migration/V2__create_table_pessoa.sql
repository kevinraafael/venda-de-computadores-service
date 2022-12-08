CREATE TABLE public.pessoa
(
    id       uuid        NOT NULL DEFAULT uuid_generate_v4(),
    cpf      varchar(11) NOT NULL,
    nome     varchar(200) NULL,
    endereco varchar(200) NULL,
    telefone varchar(14) NULL,
    CONSTRAINT pessoa_cpf_key UNIQUE (cpf),
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);