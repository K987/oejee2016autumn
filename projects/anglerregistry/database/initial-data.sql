INSERT into anglerregistry.hal 
(HalNev, MinimumMeret, NapiDarabszam, TilalmiIdoszakKezdete, TilalmiIdoszakVege, Pusztulas ) 
VALUES ('Ponty', 30, 3, to_date('0502', 'MM-DD'), to_date('0531','MM-DD'), 1);
INSERT into anglerregistry.hal 
(HalNev, MinimumMeret, NapiDarabszam, TilalmiIdoszakKezdete, TilalmiIdoszakVege, Pusztulas ) 
VALUES ('Compó', 25, 3, to_date('0502', 'MM-DD'), to_date('0615','MM-DD'), 0.5);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Balin', 40, 3, to_date('0301', 'MM-DD'), to_date('0430','MM-DD'), 2);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Csuka', 40, 3, to_date('0201', 'MM-DD'), to_date('0331','MM-DD'), 0.5);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Harcsa', 60, 3, to_date('0502', 'MM-DD'), to_date('0615','MM-DD'), 1);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Amur', 40, -10, null, null, 1);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Süllő', 30, 3, to_date('0301', 'MM-DD'), to_date('0430','MM-DD'), 1);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Kárász', 20, -10, to_date('0301', 'MM-DD'), to_date('0531','MM-DD'), 5);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas )
VALUES ('Jászkeszeg', 20, -10, to_date('0415', 'MM-DD'), to_date('0531','MM-DD'), 10);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Dévérkeszeg', 20, -10, to_date('0415', 'MM-DD'), to_date('0531','MM-DD'), 3.5);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Sügér', null, 3, to_date('0301', 'MM-DD'), to_date('0430','MM-DD'), 4);
INSERT into anglerregistry.hal 
(HalNev , MinimumMeret , NapiDarabszam , TilalmiIdoszakKezdete , TilalmiIdoszakVege , Pusztulas ) 
VALUES ('Busa', null, 3, null, null, 1);

INSERT into anglerregistry.horgaszto
 (Vizterkod, Terulet, To_tipusa, LegnagyobbVizmelyseg, Tulajdonos, Horgasztanya)
 VALUES ('002041', 10, 'bányató', 7, 'Abony Városi Önkormányzat', 1);
INSERT into anglerregistry.horgaszto
 (Vizterkod, Terulet, To_tipusa, LegnagyobbVizmelyseg, Tulajdonos, Horgasztanya)
 VALUES ('002042', 5, 'bányató', 8, 'Abonyi Horgász Egyesület', 1);
INSERT into anglerregistry.horgaszto
 (Vizterkod, Terulet, To_tipusa, LegnagyobbVizmelyseg, Tulajdonos, Horgasztanya)
 VALUES ('002043', 5, 'bányató', 7, 'Abonyi Horgász Egyesület', 0);


INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Kiss Endre', 'Tamasi Olga', to_date('19530303', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Szelei út 50.', 6, to_date('20151130', 'yyyymmdd'), 1, 1);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Nagy Endre', 'Péceli Enikő', to_date('19540323', 'yyyymmdd'), 'Abony', 2740, 'Abony', 'Szelei út 59.', 3, null, 1, 1);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Kókai Béla', 'Zenke Ilona', to_date('19921217', 'yyyymmdd'), 'Szolnok', 2740, 'Abony', 'Tószegi út 2.', 4, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Szabó István', 'Kékesi Anna', to_date('19451121', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Váradi u. 12.', 7, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Szabó László', 'Egerszegi Júlia', to_date('19870804', 'yyyymmdd'), 'Cegléd', 2745, 'Kőröstetétlen', 'Árpád út 45.', 12, null, 0, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Juhász Tibor', 'Sinkovics Mária', to_date('19280720', 'yyyymmdd'), 'Tiszafüred', 2740, 'Abony', 'Szapáry u. 22.', 6, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Juhász György', 'Szabó Klára', to_date('20061109', 'yyyymmdd'), 'Szolnok', 2740, 'Abony', 'Szapáry u. 22.', 4, null, 0, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Juhász László', 'Kovács Erzsébet', to_date('19840813', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Ceglédi út 90.', 3, to_date('20141130', 'yyyymmdd'), 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Szabados László', 'Krupincza Annamária', to_date('19960401', 'yyyymmdd'), 'Budapest', 2740, 'Abony', 'Bicskei út 8.', 0, null, 0, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Halász Tibor', 'Miklós Tímea', to_date('19840413', 'yyyymmdd'), 'Szolnok', 2740, 'Abony', 'Szelei út 13.', 0, null, 1, 1);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Hunyadi Gábor', 'Israi Mária', to_date('19690422', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Batthyány Lajos u. 73.', 4, to_date('20150410', 'yyyymmdd'), 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Aczél Sándor', 'Pankucsi Erzsébet', to_date('19310518', 'yyyymmdd'), 'Abony', 2740, 'Abony', 'Mátyás király út 10.', 8, null, 1, 0);

INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Agócs Zoltán', 'Halmi Júlia', to_date('19470807', 'yyyymmdd'), 'Szolnok', 5091, 'Tószeg', 'Kécskei út 41/a.', 0, null, 0, 1);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Nagy Bálint', 'Esze Irma', to_date('19341222', 'yyyymmdd'), 'Cegléd', 2768, 'Újszilvás', 'Dózsa György u. 32.', 6, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Nagy Bálint', 'Antal Edit', to_date('19980714', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Kodály Zoltán u. 24.', 13, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Antal Miklós', 'Nagy Mária', to_date('20070728', 'yyyymmdd'), 'Szolnok', 2740, 'Abony', 'Szelei út 50.', 0, null, 0, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Szántai Tamás', 'Horváth Emma', to_date('19630310', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Kécskei út 54.', 2, null, 1, 1);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Szolnoki József', 'Nagy Mária', to_date('19980714', 'yyyymmdd'), 'Kolozsvár', 2740, 'Abony', 'Október 6. u. 13.', 14, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Bakonyi Tibor', 'Nagy Mária', to_date('19980714', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Abonyi Lajos út 102.', 3, null, 1, 0);
INSERT into anglerregistry.horgasz 
(Nev, AnyjaNeve, SzuletesiIdo, SzuletesiHely, Irsz, Varos, Cim, TarsadalmiMunka, Eltiltas, TagE, TitkarsagiTagE)
VALUES ('Hajdu Attila', 'Kolozsvári Mónika', to_date('19980714', 'yyyymmdd'), 'Cegléd', 2740, 'Abony', 'Kazinczy Ferenc u. 9.', 2, null, 1, 0);

INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (1, 'P186243', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (2, 'N233392', 'napijegy');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (3, 'O537633', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (4, 'E151918', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (4, 'H873978', 'napijegy');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (5, 'V543928', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (6, 'F841919', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (7, 'H131722', 'napijegy');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (8, 'X169946', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (9, 'P117455', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (10, 'N845801', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (11, 'H710900', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (12, 'M312025', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (13, 'Z834551', 'napijegy');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (14, 'K515687', 'napijegy');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (15, 'P271949', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (16, 'C903625', 'éves');
INSERT into anglerregistry.engedely
    (HorgaszID, AllamiJegyID, Engedely_tipusa)
    VALUES (17, 'L605660', 'napijegy');

INSERT into anglerregistry.telepites 
    (ToID, HalID, Datum, Kor, Mennyiseg, TilalmiNapokSzama)
    VALUES (1, 1, to_date('20140530', 'yyyymmdd'), 3, 2, 10);
INSERT into anglerregistry.telepites 
    (ToID, HalID, Datum, Kor, Mennyiseg, TilalmiNapokSzama)
    VALUES (2, 4, to_date('20140530', 'yyyymmdd'), 2, 1, 10);

INSERT into anglerregistry.fogasinaplo 
(EngedelyID, ToID, Idopont, HalID, Mennyiseg) 
VALUES (1, 1, to_timestamp('20140321 0820', 'yyyymmdd hh24mi'), 1, 2);
INSERT into anglerregistry.fogasinaplo 
(EngedelyID, ToID, Idopont, HalID, Mennyiseg)
VALUES (1, 2,  to_timestamp('20140321 1130', 'yyyymmdd hh24mi'), 3, 1.5);