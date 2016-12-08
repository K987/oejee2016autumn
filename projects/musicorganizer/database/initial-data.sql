TRUNCATE TABLE albumsong CASCADE;
TRUNCATE TABLE trackliststreamingurl CASCADE;
TRUNCATE TABLE streamingurl CASCADE;
TRUNCATE TABLE tracklist CASCADE;
TRUNCATE TABLE song CASCADE;
TRUNCATE TABLE customer CASCADE;
TRUNCATE TABLE album CASCADE;
TRUNCATE TABLE artist CASCADE;


INSERT INTO customer VALUES
    (9000, 'Roland', '12345', 'levai@musicorganizer.com');

INSERT INTO tracklist VALUES
    (9000, 9000, 'My first playlist');
    
INSERT INTO artist VALUES
	(9000, 'Daft Punk');

INSERT INTO song VALUES
    (9000, 'Voyager', 'French house', 9000);
INSERT INTO streamingurl VALUES
    (9000, 9000, 'YOUTUBE', 'https://www.youtube.com/watch?v=INbgG9M0WYE');  
INSERT INTO trackliststreamingurl VALUES
    (9000,9000);

INSERT INTO song VALUES
    (9001, 'Robot Rock', 'French house', 9000);
INSERT INTO streamingurl VALUES
    (9001, 9001, 'SPOTIFY', 'https://play.spotify.com/album/1Q6bt6li2PXmYVzhT9XAK9');
INSERT INTO trackliststreamingurl VALUES
    (9000,9001);

INSERT INTO artist VALUES
	(9001, 'Justice');
	
INSERT INTO song VALUES
    (9002, 'Stop', 'Nu-disco', 9001);
INSERT INTO streamingurl VALUES
    (9002, 9002, 'YOUTUBE', 'https://www.youtube.com/watch?v=1G9f5NLV3wE');  
INSERT INTO trackliststreamingurl VALUES
    (9000,9002);
	
INSERT INTO artist VALUES
	(9002, 'Altair Nouveau');

INSERT INTO song VALUES
    (9003, 'Showdown', 'Electronic', 9002);
INSERT INTO streamingurl VALUES
    (9003, 9003, 'SOUNDCLOUD', 'https://soundcloud.com/solardisco/altair-nouveau-showdown');
INSERT INTO trackliststreamingurl VALUES
    (9000,9003);
	
INSERT INTO artist VALUES
	(9003, 'Alessi Brothers');

INSERT INTO song VALUES
    (9004, 'Do you feel it?', 'Psychedelic rock', 9003);
INSERT INTO streamingurl VALUES
    (9004, 9004, 'YOUTUBE', 'https://www.youtube.com/watch?v=_02fl9-anf4');
INSERT INTO trackliststreamingurl VALUES
    (9000,9004);
  
	
INSERT INTO artist VALUES
	(9004, 'Phoenix');

INSERT INTO song VALUES
    (9005, 'If I ever feel better', 'Indie pop', 9004);
INSERT INTO streamingurl VALUES
    (9005, 9005, 'SPOTIFY', 'https://play.spotify.com/track/3AA8xNhDC0MpqwkGX3EP5V');
INSERT INTO trackliststreamingurl VALUES
    (9000,9005);
    
    
    
    
INSERT INTO tracklist VALUES
    (9001, 9000, 'Guitar driven music');
    
INSERT INTO artist VALUES
	(9005, 'Arctic Monkeys');

INSERT INTO song VALUES
    (9006, 'Do I Wanna Know?', 'Indie', 9005);
INSERT INTO streamingurl VALUES
    (9006, 9006, 'SPOTIFY', 'https://play.spotify.com/album/4GUJZkkzr14B7Eqwi6RD8B');  
INSERT INTO trackliststreamingurl VALUES
    (9001,9006);

INSERT INTO artist VALUES
	(9006, 'Red Hot Chili Peppers');

INSERT INTO song VALUES
    (9007, 'Feasting On The Flowers', 'Rock', 9006);
INSERT INTO streamingurl VALUES
    (9007, 9007, 'YOUTUBE', ' https://www.youtube.com/watch?v=p5WGmh3aMLc');  
INSERT INTO trackliststreamingurl VALUES
    (9001,9007);  
    
INSERT INTO song VALUES
    (9008, 'Taste The Pain', 'Funk rock', 9006);
INSERT INTO streamingurl VALUES
    (9008, 9008, 'SPOTIFY', ' https://play.spotify.com/track/3J9jA3mRH3mELAdP9kw2os');  
INSERT INTO trackliststreamingurl VALUES
    (9001,9008);   
    
    
commit;