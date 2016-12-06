CREATE TABLE customer (
	customer_id SERIAL NOT NULL,
	customer_nickname CHARACTER VARYING(20) NOT NULL,
	customer_password CHARACTER VARYING(20) NOT NULL,
	customer_emailaddress CHARACTER VARYING(40) NOT NULL,
	CONSTRAINT PK_customer_ID PRIMARY KEY (customer_id)
);
ALTER TABLE customer OWNER TO postgres;

-- TODO customer_id + name should be unique?
CREATE TABLE tracklist (
	tracklist_id SERIAL NOT NULL,
	tracklist_customer_id INTEGER NOT NULL,
	tracklist_name CHARACTER VARYING(20) NOT NULL,
	CONSTRAINT PK_TRACKLIST_ID PRIMARY KEY (tracklist_id),
	CONSTRAINT FK_tracklist_customer_id FOREIGN KEY (tracklist_customer_id)
	  REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE tracklist OWNER TO postgres;

CREATE TABLE artist (
	artist_id SERIAL NOT NULL,
	artist_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_ARTIST_ID PRIMARY KEY (artist_id)
);
ALTER TABLE artist OWNER TO postgres;

CREATE TABLE song (
	song_id SERIAL NOT NULL,
	song_title CHARACTER VARYING(100) NOT NULL,
	song_category CHARACTER VARYING(40) NULL,
	song_artist_id INTEGER NOT NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id),
	CONSTRAINT FK_song_artist_id FOREIGN KEY (song_artist_id)
	  REFERENCES artist (artist_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE song OWNER TO postgres;


CREATE TABLE streamingurl (
	streamingurl_id SERIAL NOT NULL,
	streamingurl_song_id INTEGER NOT NULL,
	streamingurl_type CHARACTER VARYING(40) NOT NULL,
	streamingurl_url CHARACTER VARYING(200) NOT NULL,
	CONSTRAINT PK_STREAMINGURL_ID PRIMARY KEY (streamingurl_id),
	CONSTRAINT FK_streamingurl_song_id FOREIGN KEY (streamingurl_song_id)
	  REFERENCES song (song_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE INDEX IDX_streamingurl_song_id ON streamingurl USING btree (streamingurl_song_id);
ALTER TABLE streamingurl OWNER TO postgres;


CREATE TABLE trackliststreamingurl (
	tracklist_id INTEGER NOT NULL,
	streamingurl_id INTEGER NOT NULL,
	CONSTRAINT PK_TRACKLISTSTREAMINGURL_ID PRIMARY KEY (streamingurl_id, tracklist_id)
);
CREATE UNIQUE INDEX UI_trackliststreamingurl_pk ON trackliststreamingurl USING btree (tracklist_id, streamingurl_id);
ALTER TABLE trackliststreamingurl OWNER TO postgres;


CREATE TABLE album (
	album_id SERIAL NOT NULL,
	album_title CHARACTER VARYING(100) NOT NULL,
	album_releasedate DATE NULL,
	album_genre CHARACTER VARYING(40) NULL,
	album_label CHARACTER VARYING(40) NULL,
	CONSTRAINT PK_ALBUM_ID PRIMARY KEY (album_id)
);
ALTER TABLE album OWNER TO postgres;


-- requirements were wrong, a song CAN belong to multiple albums 
-- (think about reissued/remastered versions, etc...)
CREATE TABLE albumsong (
	album_id INTEGER NOT NULL,
	song_id INTEGER NOT NULL,
	CONSTRAINT PK_ALBUMSONG_ID PRIMARY KEY (song_id, album_id)
);
CREATE UNIQUE INDEX UI_albumsong_pk ON albumsong USING btree (album_id, song_id);
ALTER TABLE albumsong OWNER TO postgres;


