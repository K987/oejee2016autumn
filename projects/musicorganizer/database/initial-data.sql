

INSERT INTO customer VALUES
    (9000, 'Roland', '12345', 'levai@musicorganizer.com');

INSERT INTO tracklist VALUES
    (9000, 9000, 'My first playlist');

INSERT INTO song VALUES
    (9000, 'first song title', null);
INSERT INTO streamingurl VALUES
    (9000, 9000, 'YOUTUBE', 'http://youtube.com/1');  
INSERT INTO trackliststreamingurl VALUES
    (9000,9000);

INSERT INTO song VALUES
    (9001, 'second song title', null);
INSERT INTO streamingurl VALUES
    (9001, 9001, 'YOUTUBE', 'http://youtube.com/2');
INSERT INTO trackliststreamingurl VALUES
    (9000,9001);

INSERT INTO song VALUES
    (9002, 'third song title', null);
INSERT INTO streamingurl VALUES
    (9002, 9002, 'YOUTUBE', 'http://youtube.com/3');  
INSERT INTO trackliststreamingurl VALUES
    (9000,9002);

INSERT INTO song VALUES
    (9003, 'fourth song title', null);
INSERT INTO streamingurl VALUES
    (9003, 9003, 'SOUNDCLOUD', 'http://soundcloud.com/4');
INSERT INTO trackliststreamingurl VALUES
    (9000,9003);
    
commit;