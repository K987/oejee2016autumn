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


CREATE TABLE song (
	song_id SERIAL NOT NULL,
	song_title CHARACTER VARYING(100) NOT NULL,
	song_category CHARACTER VARYING(40) NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id)
);
ALTER TABLE song OWNER TO postgres;


CREATE TABLE streamingurl (
	streamingurl_id SERIAL NOT NULL,
	streamingurl_song_id INTEGER NOT NULL,
	streamingurl_type CHARACTER VARYING(40) NOT NULL,
	streamingurl_url CHARACTER VARYING(200) NOT NULL,
	CONSTRAINT PK_STREAMINGURL_ID PRIMARY KEY (streamingurl_id),
	CONSTRAINT FK_streamingurl_song_id FOREIGN KEY (tracklist_song_id)
	  REFERENCES song (song_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
CREATE INDEX IDX_streamingurl_song_id ON streamingurl USING btree (song_id);
ALTER TABLE streamingurl OWNER TO postgres;


CREATE TABLE trackliststreamingurl (
	song_id INTEGER NOT NULL,
	streamingurl_id INTEGER NOT NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id, streamingurl_id)
);
CREATE UNIQUE INDEX UI_tracklistsong_pk ON trackliststreamingurl USING btree (streamingurl_id, song_id);
ALTER TABLE trackliststreamingurl OWNER TO postgres;


CREATE TABLE album (
	album_id SERIAL NOT NULL,
	album_title CHARACTER VARYING(100) NOT NULL,
	album_releasedate DATE NULL,
	album_genre CHARACTER VARYING(40) NULL,
	album_label CHARACTER VARYING(40) NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id)
);
ALTER TABLE album OWNER TO postgres;


-- requirements were wrong, a song CAN belong to multiple albums 
-- (think about reissued/remastered versions, etc...)
CREATE TABLE albumsong (
	album_id INTEGER NOT NULL,
	song_id INTEGER NOT NULL,
	CONSTRAINT PK_ALBUMSONG_ID PRIMARY KEY (song_id, album_id)
);
CREATE UNIQUE INDEX UI_tracklistsong_pk ON albumsong USING btree (album_id, song_id);
ALTER TABLE albumsong OWNER TO postgres;


CREATE TABLE artist (
	artist_id SERIAL NOT NULL,
	artist_name CHARACTER VARYING(100) NOT NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id)
);
ALTER TABLE artist OWNER TO postgres;


-- requirements were wrong, a song can have an artist without the song being on an album
CREATE TABLE artistsong (
	song_id INTEGER NOT NULL,
	artist_id INTEGER NOT NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id, artist_id)
);
CREATE UNIQUE INDEX UI_tracklistsong_pk ON albumsong USING btree (artist_id, song_id);
ALTER TABLE albumsong OWNER TO postgres;