--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.11
-- Dumped by pg_dump version 9.6.11

-- Started on 2019-03-18 16:56:38

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
-- TOC entry 187 (class 1259 OID 17391)
-- Name: dictionary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dictionary (
    english_word character varying NOT NULL,
    russian_word character varying NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.dictionary OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 17416)
-- Name: dictionary_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dictionary_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dictionary_id_seq OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 189
-- Name: dictionary_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dictionary_id_seq OWNED BY public.dictionary.id;


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
-- TOC entry 188 (class 1259 OID 17399)
-- Name: user_dictionary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_dictionary (
    user_id integer NOT NULL,
    pair_id bigint NOT NULL
);


ALTER TABLE public.user_dictionary OWNER TO postgres;

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
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 186
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 2017 (class 2606 OID 17398)
-- Name: dictionary dictionary_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dictionary
    ADD CONSTRAINT dictionary_id PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 17419)
-- Name: user login; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT login UNIQUE (login);


--
-- TOC entry 2021 (class 2606 OID 17415)
-- Name: user_dictionary user_dictionary_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_dictionary
    ADD CONSTRAINT user_dictionary_pk PRIMARY KEY (user_id, pair_id);


--
-- TOC entry 2015 (class 2606 OID 17276)
-- Name: user user_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_id PRIMARY KEY (id);


--
-- TOC entry 2018 (class 1259 OID 17413)
-- Name: fki_pair_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_pair_id ON public.user_dictionary USING btree (pair_id);


--
-- TOC entry 2019 (class 1259 OID 17407)
-- Name: fki_user_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_id ON public.user_dictionary USING btree (user_id);


--
-- TOC entry 2023 (class 2606 OID 17408)
-- Name: user_dictionary pair_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_dictionary
    ADD CONSTRAINT pair_id FOREIGN KEY (pair_id) REFERENCES public.dictionary(id);


--
-- TOC entry 2022 (class 2606 OID 17402)
-- Name: user_dictionary user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_dictionary
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public."user"(id);


-- Completed on 2019-03-18 16:56:39

--
-- PostgreSQL database dump complete
--

