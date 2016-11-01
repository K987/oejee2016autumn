-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database
-- ;
-- -- ddl-end --
-- 

-- object: esemeny | type: TABLE --
-- DROP TABLE IF EXISTS esemeny CASCADE;
CREATE TABLE esemeny(
	esemeny_id integer NOT NULL,
	esemeny_megnevezes varchar(200) NOT NULL,
	esemeny_legkorabbibekovetkezes integer,
	esemeny_legkesobbibekovetkezes integer,
	esemeny_halo_id integer,
	CONSTRAINT esemeny_id_pri PRIMARY KEY (esemeny_id),
	CONSTRAINT esemeny_megnevezes_esemeny_halo_id_uniq UNIQUE (esemeny_megnevezes,esemeny_halo_id)

);
-- ddl-end --
ALTER TABLE esemeny OWNER TO projectscheduler;
-- ddl-end --

-- object: halo | type: TABLE --
-- DROP TABLE IF EXISTS halo CASCADE;
CREATE TABLE halo(
	halo_id integer NOT NULL,
	halo_megnevezes varchar(200) NOT NULL,
	halo_kezdete date,
	halo_teljesidotartam integer,
	CONSTRAINT halo_id_pri PRIMARY KEY (halo_id),
	CONSTRAINT halo_megnevezes_uniq UNIQUE (halo_megnevezes)

);
-- ddl-end --
ALTER TABLE halo OWNER TO projectscheduler;
-- ddl-end --

-- object: esemeny_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS esemeny_id_pri_index CASCADE;
CREATE INDEX esemeny_id_pri_index ON esemeny
	USING btree
	(
	  esemeny_id ASC NULLS LAST
	);
-- ddl-end --

-- object: halo_id | type: INDEX --
-- DROP INDEX IF EXISTS halo_id CASCADE;
CREATE INDEX halo_id ON esemeny
	USING btree
	(
	  esemeny_halo_id ASC NULLS LAST
	);
-- ddl-end --

-- object: legkorabbi | type: INDEX --
-- DROP INDEX IF EXISTS legkorabbi CASCADE;
CREATE INDEX legkorabbi ON esemeny
	USING btree
	(
	  esemeny_halo_id ASC NULLS LAST,
	  esemeny_legkorabbibekovetkezes ASC NULLS FIRST
	);
-- ddl-end --

-- object: legkesobbi | type: INDEX --
-- DROP INDEX IF EXISTS legkesobbi CASCADE;
CREATE INDEX legkesobbi ON esemeny
	USING btree
	(
	  esemeny_halo_id ASC NULLS LAST,
	  esemeny_legkesobbibekovetkezes ASC NULLS FIRST
	);
-- ddl-end --

-- object: reszleg | type: TABLE --
-- DROP TABLE IF EXISTS reszleg CASCADE;
CREATE TABLE reszleg(
	reszleg_id integer NOT NULL,
	reszleg_megnevezes varchar(200) NOT NULL,
	reszleg_irodacime varchar(200),
	CONSTRAINT reszleg_id_pri PRIMARY KEY (reszleg_id),
	CONSTRAINT reszleg_megnevezes_uniq UNIQUE (reszleg_megnevezes)

);
-- ddl-end --
ALTER TABLE reszleg OWNER TO projectscheduler;
-- ddl-end --

-- object: reszleg_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS reszleg_id_pri_index CASCADE;
CREATE INDEX reszleg_id_pri_index ON reszleg
	USING btree
	(
	  reszleg_id ASC NULLS LAST
	);
-- ddl-end --

-- object: szemely | type: TABLE --
-- DROP TABLE IF EXISTS szemely CASCADE;
CREATE TABLE szemely(
	szemely_id integer NOT NULL,
	szemely_reszleg_id integer NOT NULL,
	szemely_nev varchar(200),
	szemely_beosztas varchar(200),
	CONSTRAINT szemely_id_pri PRIMARY KEY (szemely_id)

);
-- ddl-end --
ALTER TABLE szemely OWNER TO projectscheduler;
-- ddl-end --

-- object: szemely_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS szemely_id_pri_index CASCADE;
CREATE INDEX szemely_id_pri_index ON szemely
	USING btree
	(
	  szemely_id ASC NULLS LAST
	);
-- ddl-end --

-- object: reszleg_id | type: INDEX --
-- DROP INDEX IF EXISTS reszleg_id CASCADE;
CREATE INDEX reszleg_id ON szemely
	USING btree
	(
	  szemely_reszleg_id ASC NULLS LAST
	);
-- ddl-end --

-- object: tevekenyseg | type: TABLE --
-- DROP TABLE IF EXISTS tevekenyseg CASCADE;
CREATE TABLE tevekenyseg(
	tevekenyseg_id integer NOT NULL,
	tevekenyseg_szemely_id integer NOT NULL,
	tevekenyseg_megnevezes varchar(200) NOT NULL,
	tevekenyseg_halo_id integer NOT NULL,
	tevekenyseg_kezdeti_esemeny_id integer NOT NULL,
	tevekenyseg_vegso_esemeny_id integer NOT NULL,
	tevekenyseg_atfutasi_ido integer NOT NULL,
	CONSTRAINT tevekenyseg_id_pri PRIMARY KEY (tevekenyseg_id),
	CONSTRAINT tevekenyseg_megnevezes_tevekenyseg_halo_id_uniq UNIQUE (tevekenyseg_megnevezes,tevekenyseg_halo_id)

);
-- ddl-end --
ALTER TABLE tevekenyseg OWNER TO projectscheduler;
-- ddl-end --

-- object: tevekenyseg_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS tevekenyseg_id_pri_index CASCADE;
CREATE INDEX tevekenyseg_id_pri_index ON tevekenyseg
	USING btree
	(
	  tevekenyseg_id ASC NULLS LAST
	);
-- ddl-end --

-- object: tevekenyseg_szemely_id_index | type: INDEX --
-- DROP INDEX IF EXISTS tevekenyseg_szemely_id_index CASCADE;
CREATE INDEX tevekenyseg_szemely_id_index ON tevekenyseg
	USING btree
	(
	  tevekenyseg_szemely_id ASC NULLS LAST
	);
-- ddl-end --

-- object: tevekenyseg_halo_id_index | type: INDEX --
-- DROP INDEX IF EXISTS tevekenyseg_halo_id_index CASCADE;
CREATE INDEX tevekenyseg_halo_id_index ON tevekenyseg
	USING btree
	(
	  tevekenyseg_halo_id ASC NULLS LAST
	);
-- ddl-end --

-- object: kezdetiesemeny | type: INDEX --
-- DROP INDEX IF EXISTS kezdetiesemeny CASCADE;
CREATE INDEX kezdetiesemeny ON tevekenyseg
	USING btree
	(
	  tevekenyseg_kezdeti_esemeny_id ASC NULLS LAST
	);
-- ddl-end --

-- object: vegsoesemeny | type: INDEX --
-- DROP INDEX IF EXISTS vegsoesemeny CASCADE;
CREATE INDEX vegsoesemeny ON tevekenyseg
	USING btree
	(
	  tevekenyseg_vegso_esemeny_id ASC NULLS LAST
	);
-- ddl-end --

-- object: eroforras | type: TABLE --
-- DROP TABLE IF EXISTS eroforras CASCADE;
CREATE TABLE eroforras(
	eroforras_id integer NOT NULL,
	eroforras_megnevezes varchar(200) NOT NULL,
	eroforras_maxkapacitas integer NOT NULL,
	CONSTRAINT eroforras_id_pri PRIMARY KEY (eroforras_id),
	CONSTRAINT eroforras_megnevezes_uniq UNIQUE (eroforras_megnevezes)

);
-- ddl-end --
ALTER TABLE eroforras OWNER TO projectscheduler;
-- ddl-end --

-- object: felhasznalas | type: TABLE --
-- DROP TABLE IF EXISTS felhasznalas CASCADE;
CREATE TABLE felhasznalas(
	felhasznalas_id integer NOT NULL,
	felhasznalas_tevekenyseg_id integer NOT NULL,
	felhasznalas_eroforras_id integer NOT NULL,
	felhasznalas_mennyiseg double precision NOT NULL,
	CONSTRAINT felhasznalas_id_pri PRIMARY KEY (felhasznalas_id),
	CONSTRAINT uniq UNIQUE (felhasznalas_tevekenyseg_id,felhasznalas_eroforras_id)

);
-- ddl-end --
ALTER TABLE felhasznalas OWNER TO projectscheduler;
-- ddl-end --

-- object: felhasznalas_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS felhasznalas_id_pri_index CASCADE;
CREATE INDEX felhasznalas_id_pri_index ON felhasznalas
	USING btree
	(
	  felhasznalas_id ASC NULLS LAST
	);
-- ddl-end --

-- object: felhasznalas_tevekenyseg_id_index | type: INDEX --
-- DROP INDEX IF EXISTS felhasznalas_tevekenyseg_id_index CASCADE;
CREATE INDEX felhasznalas_tevekenyseg_id_index ON felhasznalas
	USING btree
	(
	  felhasznalas_tevekenyseg_id ASC NULLS LAST
	);
-- ddl-end --

-- object: eroforras_id_index | type: INDEX --
-- DROP INDEX IF EXISTS eroforras_id_index CASCADE;
CREATE INDEX eroforras_id_index ON felhasznalas
	USING btree
	(
	  felhasznalas_eroforras_id ASC NULLS LAST
	);
-- ddl-end --

-- object: eroforras_id_pri_index | type: INDEX --
-- DROP INDEX IF EXISTS eroforras_id_pri_index CASCADE;
CREATE INDEX eroforras_id_pri_index ON eroforras
	USING btree
	(
	  eroforras_id ASC NULLS LAST
	);
-- ddl-end --

-- object: fk_halo_id | type: CONSTRAINT --
-- ALTER TABLE esemeny DROP CONSTRAINT IF EXISTS fk_halo_id CASCADE;
ALTER TABLE esemeny ADD CONSTRAINT fk_halo_id FOREIGN KEY (esemeny_halo_id)
REFERENCES halo (halo_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FK_reszleg_id" | type: CONSTRAINT --
-- ALTER TABLE szemely DROP CONSTRAINT IF EXISTS "FK_reszleg_id" CASCADE;
ALTER TABLE szemely ADD CONSTRAINT "FK_reszleg_id" FOREIGN KEY (szemely_reszleg_id)
REFERENCES reszleg (reszleg_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKszemely" | type: CONSTRAINT --
-- ALTER TABLE tevekenyseg DROP CONSTRAINT IF EXISTS "FKszemely" CASCADE;
ALTER TABLE tevekenyseg ADD CONSTRAINT "FKszemely" FOREIGN KEY (tevekenyseg_szemely_id)
REFERENCES szemely (szemely_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKhalo" | type: CONSTRAINT --
-- ALTER TABLE tevekenyseg DROP CONSTRAINT IF EXISTS "FKhalo" CASCADE;
ALTER TABLE tevekenyseg ADD CONSTRAINT "FKhalo" FOREIGN KEY (tevekenyseg_halo_id)
REFERENCES halo (halo_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKkezdeti" | type: CONSTRAINT --
-- ALTER TABLE tevekenyseg DROP CONSTRAINT IF EXISTS "FKkezdeti" CASCADE;
ALTER TABLE tevekenyseg ADD CONSTRAINT "FKkezdeti" FOREIGN KEY (tevekenyseg_kezdeti_esemeny_id)
REFERENCES esemeny (esemeny_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKvegso" | type: CONSTRAINT --
-- ALTER TABLE tevekenyseg DROP CONSTRAINT IF EXISTS "FKvegso" CASCADE;
ALTER TABLE tevekenyseg ADD CONSTRAINT "FKvegso" FOREIGN KEY (tevekenyseg_vegso_esemeny_id)
REFERENCES esemeny (esemeny_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKtevekenyseg" | type: CONSTRAINT --
-- ALTER TABLE felhasznalas DROP CONSTRAINT IF EXISTS "FKtevekenyseg" CASCADE;
ALTER TABLE felhasznalas ADD CONSTRAINT "FKtevekenyseg" FOREIGN KEY (felhasznalas_tevekenyseg_id)
REFERENCES tevekenyseg (tevekenyseg_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "FKeroforras" | type: CONSTRAINT --
-- ALTER TABLE felhasznalas DROP CONSTRAINT IF EXISTS "FKeroforras" CASCADE;
ALTER TABLE felhasznalas ADD CONSTRAINT "FKeroforras" FOREIGN KEY (felhasznalas_eroforras_id)
REFERENCES eroforras (eroforras_id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


