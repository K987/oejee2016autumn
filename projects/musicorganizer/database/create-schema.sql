CREATE TABLE user (
	user_id INTEGER NOT NULL,
	user_name CHARACTER VARYING(20) NOT NULL,
	user_password CHARACTER VARYING(20) NOT NULL,
	user_emailaddr CHARACTER VARYING(40) NULL,
	CONSTRAINT PK_USER_ID PRIMARY KEY (user_id)
);
ALTER TABLE user OWNER TO postgres;



CREATE TABLE tracklist (
	tracklist_id INTEGER NOT NULL,
	tracklist_user_id INTEGER NOT NULL,
	tracklist_name CHARACTER VARYING(20) NOT NULL,
	CONSTRAINT PK_TRACKLIST_ID PRIMARY KEY (tracklist_id),
	CONSTRAINT FK_tracklist_user_id FOREIGN KEY (tracklist_user_id)
	  REFERENCES user (user_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE tracklist OWNER TO postgres;


-- consider a different table for streaming urls
CREATE TABLE song (
	song_id INTEGER NOT NULL,
	song_title CHARACTER VARYING(100) NOT NULL,
	song_category CHARACTER VARYING(40) NULL,
	youtube_streaming_url CHARACTER VARYING(40) NULL,
	soundcloud_streaming_url CHARACTER VARYING(40) NULL,
	spotify_streaming_url CHARACTER VARYING(40) NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id)
);
ALTER TABLE song OWNER TO postgres;



CREATE TABLE tracklistsong (
	song_id INTEGER NOT NULL,
	tracklist_id INTEGER NOT NULL,
	CONSTRAINT PK_SONG_ID PRIMARY KEY (song_id, tracklist_id)
);
CREATE UNIQUE INDEX UI_tracklistsong_pk ON tracklistsong USING btree (tracklist_id, song_id);
ALTER TABLE tracklistsong OWNER TO postgres;



CREATE TABLE album (
	album_id INTEGER NOT NULL,
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
	reissued_id INTEGER NOT NULL,
	reissued_id INTEGER NOT NULL,
	CONSTRAINT PK_ALBUMSONG_ID PRIMARY KEY (song_id, album_id)
);
CREATE UNIQUE INDEX UI_tracklistsong_pk ON albumsong USING btree (album_id, song_id);
ALTER TABLE albumsong OWNER TO postgres;


CREATE TABLE artist (
	artist_id INTEGER NOT NULL,
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