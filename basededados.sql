--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: avisos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.avisos (
    id integer NOT NULL,
    title character varying(255) NOT NULL,
    "imageUrl" character varying(1000),
    content bytea NOT NULL,
    "userId" integer NOT NULL,
    "categoryId" integer NOT NULL
);


--
-- Name: avisos_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.avisos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: avisos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.avisos_id_seq OWNED BY public.avisos.id;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    "parentId" integer
);


--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: condominos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.condominos (
    id integer NOT NULL,
    apartamento character varying(255) NOT NULL,
    responsavel character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    parentesco character varying(255),
    obs character varying(255),
    "userId" integer NOT NULL,
    "categoryId" integer NOT NULL
);


--
-- Name: condominos_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.condominos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: condominos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.condominos_id_seq OWNED BY public.condominos.id;


--
-- Name: estacionamentos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.estacionamentos (
    id integer NOT NULL,
    vaga character varying(255) NOT NULL,
    apartamento character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    obs character varying(255),
    "userId" integer NOT NULL,
    "categoryId" integer NOT NULL
);


--
-- Name: estacionamentos_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.estacionamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: estacionamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.estacionamentos_id_seq OWNED BY public.estacionamentos.id;


--
-- Name: knex_migrations; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.knex_migrations (
    id integer NOT NULL,
    name character varying(255),
    batch integer,
    migration_time timestamp with time zone
);


--
-- Name: knex_migrations_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.knex_migrations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: knex_migrations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.knex_migrations_id_seq OWNED BY public.knex_migrations.id;


--
-- Name: knex_migrations_lock; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.knex_migrations_lock (
    index integer NOT NULL,
    is_locked integer
);


--
-- Name: knex_migrations_lock_index_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.knex_migrations_lock_index_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: knex_migrations_lock_index_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.knex_migrations_lock_index_seq OWNED BY public.knex_migrations_lock.index;


--
-- Name: noticias; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.noticias (
    id integer NOT NULL,
    title character varying(255) NOT NULL,
    "imageUrl" character varying(1000),
    content bytea NOT NULL,
    "userId" integer NOT NULL,
    "categoryId" integer NOT NULL
);


--
-- Name: noticias_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.noticias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: noticias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.noticias_id_seq OWNED BY public.noticias.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    cpf character varying(255) NOT NULL,
    apartamento character varying(255) NOT NULL,
    contato character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    admin boolean DEFAULT false NOT NULL,
    "deletedAt" timestamp with time zone
);


--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: avisos id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.avisos ALTER COLUMN id SET DEFAULT nextval('public.avisos_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: condominos id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.condominos ALTER COLUMN id SET DEFAULT nextval('public.condominos_id_seq'::regclass);


--
-- Name: estacionamentos id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estacionamentos ALTER COLUMN id SET DEFAULT nextval('public.estacionamentos_id_seq'::regclass);


--
-- Name: knex_migrations id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.knex_migrations ALTER COLUMN id SET DEFAULT nextval('public.knex_migrations_id_seq'::regclass);


--
-- Name: knex_migrations_lock index; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.knex_migrations_lock ALTER COLUMN index SET DEFAULT nextval('public.knex_migrations_lock_index_seq'::regclass);


--
-- Name: noticias id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.noticias ALTER COLUMN id SET DEFAULT nextval('public.noticias_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: avisos; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.avisos (id, title, "imageUrl", content, "userId", "categoryId") FROM stdin;
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.categories (id, name, "parentId") FROM stdin;
3	Avisos	\N
13	Notícias	\N
11	Assinar a Newsletter	\N
4	Chamados	\N
5	Condôminos	\N
12	Consumo Água/Energia	\N
6	Documentos	\N
7	Estacionamento	\N
8	Funcionários	\N
10	Legislação	\N
2	Página Inicial	\N
9	Relatórios	\N
\.


--
-- Data for Name: condominos; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.condominos (id, apartamento, responsavel, nome, parentesco, obs, "userId", "categoryId") FROM stdin;
\.


--
-- Data for Name: estacionamentos; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.estacionamentos (id, vaga, apartamento, nome, obs, "userId", "categoryId") FROM stdin;
\.


--
-- Data for Name: knex_migrations; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.knex_migrations (id, name, batch, migration_time) FROM stdin;
22	20200908160142_create_table_users.js	1	2020-09-08 21:02:47.623-03
23	20200908160156_create_table_categories.js	1	2020-09-08 21:02:47.637-03
24	20200908160206_create_table_avisos.js	1	2020-09-08 21:02:47.648-03
25	20200908160211_create_table_noticias.js	1	2020-09-08 21:02:47.66-03
26	20200908160228_create_table_deleted_at_table_users.js	1	2020-09-08 21:02:47.661-03
27	20200916163651_create_table_condominos.js	2	2020-09-16 19:01:11.951-03
29	20200918104541_create_table_estacionamentos.js	3	2021-09-22 17:25:28.829-03
\.


--
-- Data for Name: knex_migrations_lock; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.knex_migrations_lock (index, is_locked) FROM stdin;
1	0
\.


--
-- Data for Name: noticias; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.noticias (id, title, "imageUrl", content, "userId", "categoryId") FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.users (id, name, email, cpf, apartamento, contato, password, admin, "deletedAt") FROM stdin;
1	Administrador	admin@mail.com	12345678910	101	111111111111	$2a$10$HkQPJUrgnLij6UcDKVp.auLQImsT2BlQfcx060vOSiNVWVrNYN6vu	t	\N
\.


--
-- Name: avisos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.avisos_id_seq', 8, true);


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.categories_id_seq', 2, true);


--
-- Name: condominos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.condominos_id_seq', 37, true);


--
-- Name: estacionamentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.estacionamentos_id_seq', 1, false);


--
-- Name: knex_migrations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.knex_migrations_id_seq', 29, true);


--
-- Name: knex_migrations_lock_index_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.knex_migrations_lock_index_seq', 1, true);


--
-- Name: noticias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.noticias_id_seq', 8, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 25, true);


--
-- Name: avisos avisos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.avisos
    ADD CONSTRAINT avisos_pkey PRIMARY KEY (id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: condominos condominos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.condominos
    ADD CONSTRAINT condominos_pkey PRIMARY KEY (id);


--
-- Name: estacionamentos estacionamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estacionamentos
    ADD CONSTRAINT estacionamentos_pkey PRIMARY KEY (id);


--
-- Name: knex_migrations_lock knex_migrations_lock_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.knex_migrations_lock
    ADD CONSTRAINT knex_migrations_lock_pkey PRIMARY KEY (index);


--
-- Name: knex_migrations knex_migrations_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.knex_migrations
    ADD CONSTRAINT knex_migrations_pkey PRIMARY KEY (id);


--
-- Name: noticias noticias_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.noticias
    ADD CONSTRAINT noticias_pkey PRIMARY KEY (id);


--
-- Name: users users_cpf_unique; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_cpf_unique UNIQUE (cpf);


--
-- Name: users users_email_unique; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_unique UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: avisos avisos_categoryid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.avisos
    ADD CONSTRAINT avisos_categoryid_foreign FOREIGN KEY ("categoryId") REFERENCES public.categories(id);


--
-- Name: avisos avisos_userid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.avisos
    ADD CONSTRAINT avisos_userid_foreign FOREIGN KEY ("userId") REFERENCES public.users(id);


--
-- Name: categories categories_parentid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_parentid_foreign FOREIGN KEY ("parentId") REFERENCES public.categories(id);


--
-- Name: condominos condominos_categoryid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.condominos
    ADD CONSTRAINT condominos_categoryid_foreign FOREIGN KEY ("categoryId") REFERENCES public.categories(id);


--
-- Name: condominos condominos_userid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.condominos
    ADD CONSTRAINT condominos_userid_foreign FOREIGN KEY ("userId") REFERENCES public.users(id);


--
-- Name: estacionamentos estacionamentos_categoryid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estacionamentos
    ADD CONSTRAINT estacionamentos_categoryid_foreign FOREIGN KEY ("categoryId") REFERENCES public.categories(id);


--
-- Name: estacionamentos estacionamentos_userid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estacionamentos
    ADD CONSTRAINT estacionamentos_userid_foreign FOREIGN KEY ("userId") REFERENCES public.users(id);


--
-- Name: noticias noticias_categoryid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.noticias
    ADD CONSTRAINT noticias_categoryid_foreign FOREIGN KEY ("categoryId") REFERENCES public.categories(id);


--
-- Name: noticias noticias_userid_foreign; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.noticias
    ADD CONSTRAINT noticias_userid_foreign FOREIGN KEY ("userId") REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

