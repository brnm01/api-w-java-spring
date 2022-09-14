--
-- Table ALUNO
--
CREATE TABLE IF NOT EXISTS public.aluno
(
    id_matricula integer NOT NULL,
    nome character(50) COLLATE pg_catalog."default" NOT NULL,
    sexo character(12) COLLATE pg_catalog."default" NOT NULL,
    data_cadastro date,
    data_nasc_aluno character(12),
    CONSTRAINT aluno_pkey PRIMARY KEY (id_matricula)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.aluno
    OWNER to postgres;
--
--
-- Table CURSO
--
CREATE TABLE IF NOT EXISTS public.curso
(
    id_curso integer NOT NULL,
    titulo_curso character(50) COLLATE pg_catalog."default" NOT NULL,
    data_cadastro date NOT NULL,
    CONSTRAINT curso_pkey PRIMARY KEY (id_curso)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.curso
    OWNER to postgres;
--
--
-- Table CURSO RELACIONAMENTO
--
CREATE TABLE IF NOT EXISTS public.curso_relacionamento
(
    id_curso integer NOT NULL,
    id_matricula integer NOT NULL,
    ano_formacao integer NOT NULL,
    status character(50) COLLATE pg_catalog."default",
    id_curso_rel_aluno integer NOT NULL,
    CONSTRAINT curso_relacionamento_pkey PRIMARY KEY (id_curso_rel_aluno)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.curso_relacionamento
    OWNER to postgres;
