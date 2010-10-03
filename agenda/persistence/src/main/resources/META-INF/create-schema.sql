-- DROP TABLE evenements;
-- DROP TABLE calendriers;

CREATE TABLE calendriers (
  id serial NOT NULL,
  nom character varying(255) NOT NULL,
  description text,
  CONSTRAINT calendriers_pkey PRIMARY KEY (id)
);
ALTER TABLE calendriers OWNER TO postgres;

CREATE TABLE evenements (
  id serial NOT NULL,
  calendrier_id bigint,
  du timestamp without time zone NOT NULL,
  au timestamp without time zone NOT NULL,
  nom character varying(255),
  CONSTRAINT evenements_pkey PRIMARY KEY (id),
  CONSTRAINT evenements_calendrier_id_fkey FOREIGN KEY (calendrier_id) REFERENCES calendriers (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE evenements OWNER TO postgres;