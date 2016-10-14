INSERT INTO CBMS_KEYWORD (keyword) VALUES ('zene');
INSERT INTO CBMS_KEYWORD (keyword) VALUES ('dal');
INSERT INTO CBMS_KEYWORD (keyword) VALUES ('parodia');
INSERT INTO CBMS_KEYWORD (keyword) VALUES ('humor');

INSERT INTO CBMS_USER (user_name, user_pw, user_email) VALUES ('musicaddict','musicaddict','musicaddict@nicsmail.com');

INSERT INTO CBMS_BOOKMARK (bookmark_title, bookmark_url, bookmark_description, bookmark_preview, bookmark_owner) VALUES ('POLGAR PETI - REISZ ANDRAS KANYE WEST PRESSER GABOR', 'https://www.youtube.com/watch?v=Orx3mvk-Vl8', 'Ujabb parodia Polgar Petitol', 'https://i.ytimg.com/vi/Orx3mvk-Vl8/hqdefault.jpg', 1);

INSERT INTO CBMS_BOOKMARK (bookmark_title, bookmark_url, bookmark_description, bookmark_preview, bookmark_owner) VALUES ('POLGAR PETI - BALATON SOUND', 'https://www.youtube.com/watch?v=bjkAPJHE-rk', 'Balaton Sound himnusz', 'https://i.ytimg.com/vi/bjkAPJHE-rk/hqdefault.jpg', 1);

INSERT INTO CBMS_SHARE (share_date, share_bookmark) VALUES ('2016-08-01 19:20:10-01', 1);
INSERT INTO CBMS_SHARE (share_date, share_bookmark) VALUES ('2016-08-01 19:20:10-01', 2);

INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (1, 1);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (1, 2);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (1, 3);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (1, 4);

INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (2, 1);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (2, 2);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (2, 3);
INSERT INTO CBMS_BM_KW_CONNECTION (bookmark, keyword) VALUES (2, 4);

INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (1, 1);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (1, 2);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (1, 3);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (1, 4);

INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (2, 1);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (2, 2);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (2, 3);
INSERT INTO CBMS_SHARE_KW_CONNECTION (cbms_share, keyword) VALUES (2, 4);