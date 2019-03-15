--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.11
-- Dumped by pg_dump version 9.6.11

-- Started on 2019-03-15 16:56:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 189 (class 1259 OID 17303)
-- Name: dictionary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dictionary (
);


ALTER TABLE public.dictionary OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 17297)
-- Name: english_words; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.english_words (
    id bigint NOT NULL,
    word character varying NOT NULL
);


ALTER TABLE public.english_words OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 17300)
-- Name: russian_words; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.russian_words (
    id bigint NOT NULL,
    word character varying NOT NULL
);


ALTER TABLE public.russian_words OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17269)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    login character varying(30) NOT NULL,
    password character varying(50) NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 17295)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 186
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 2018 (class 2606 OID 17313)
-- Name: english_words english_word_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.english_words
    ADD CONSTRAINT english_word_id PRIMARY KEY (id);


--
-- TOC entry 2020 (class 2606 OID 17315)
-- Name: russian_words russian_word_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.russian_words
    ADD CONSTRAINT russian_word_id PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2606 OID 17276)
-- Name: user user_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_id PRIMARY KEY (id);


-- Completed on 2019-03-15 16:56:24

--
-- PostgreSQL database dump complete
--

