GRANT SELECT, INSERT, UPDATE, DELETE ON 
customer, tracklist, song, streamingurl,
trackliststreamingurl, album, albumsong,
artist
TO musicorganizer_role;


GRANT USAGE, SELECT, UPDATE ON customer_customer_id_seq TO musicorganizer_role;
GRANT USAGE, SELECT, UPDATE ON tracklist_tracklist_id_seq TO musicorganizer_role;
GRANT USAGE, SELECT, UPDATE ON song_song_id_seq TO musicorganizer_role;
GRANT USAGE, SELECT, UPDATE ON streamingurl_streamingurl_id_seq TO musicorganizer_role;
GRANT USAGE, SELECT, UPDATE ON album_album_id_seq TO musicorganizer_role;
GRANT USAGE, SELECT, UPDATE ON artist_artist_id_seq TO musicorganizer_role;
