--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: healthapp; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE healthapp WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE healthapp OWNER TO postgres;

\connect healthapp

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: sec; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec
  START WITH 100
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;


ALTER TABLE public.sec OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: doctor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doctor (
  id integer DEFAULT nextval('public.sec'::regclass) NOT NULL,
  speciality_code character varying(255),
  create_time timestamp without time zone DEFAULT now(),
  last_updated timestamp without time zone,
  user_id integer
);


ALTER TABLE public.doctor OWNER TO postgres;

--
-- Name: rx; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rx (
  id integer DEFAULT nextval('public.sec'::regclass) NOT NULL,
  user_id integer,
  doctor_id integer,
  symptoms character varying(255),
  medicine character varying(255),
  create_time timestamp without time zone DEFAULT now(),
  last_updated timestamp without time zone
);


ALTER TABLE public.rx OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
  id integer DEFAULT nextval('public.sec'::regclass) NOT NULL,
  email character varying(255),
  password character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  age integer,
  gender integer
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Data for Name: doctor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.doctor (id, speciality_code, create_time, last_updated, user_id) VALUES (6, 'therapist', '2018-11-24 13:16:03.340018', NULL, 5);


--
-- Data for Name: rx; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rx (id, user_id, doctor_id, symptoms, medicine, create_time, last_updated) VALUES (9, 4, 6, 'Low fever', 'Tea with lemon', '2018-11-24 13:23:26.293228', NULL);
INSERT INTO public.rx (id, user_id, doctor_id, symptoms, medicine, create_time, last_updated) VALUES (8, 4, 6, 'High fever', 'Paracetamol
', '2018-11-22 11:11:00', NULL);


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (id, email, password, first_name, last_name, age, gender) VALUES (4, 'user@mail.ru', 'user', 'Don', 'Canelli', 43, 1);
INSERT INTO public."user" (id, email, password, first_name, last_name, age, gender) VALUES (5, 'doc@mail.ru', 'doc', 'Aaron', 'Kaufman', 32, 1);
INSERT INTO public."user" (id, email, password, first_name, last_name, age, gender) VALUES (20, 'ozzy@mail.ru', 'nightmare123', 'Ozzy', 'Osbourne', 70, 1);


--
-- Name: sec; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec', 22, true);


--
-- Name: doctor doctor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
ADD CONSTRAINT doctor_pkey PRIMARY KEY (id);


--
-- Name: rx rx_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rx
ADD CONSTRAINT rx_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: fki_rx_doctor_id_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_rx_doctor_id_pk ON public.rx USING btree (doctor_id);


--
-- Name: fki_rx_user_id_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_rx_user_id_pk ON public.rx USING btree (user_id);


--
-- Name: fki_user_id_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_id_fk ON public.doctor USING btree (user_id);


--
-- PostgreSQL database dump complete
--

