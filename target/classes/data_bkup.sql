
-- DROP TABLE IF EXISTS postures_master;
--
-- -- Table Definition ----------------------------------------------
--
-- CREATE TABLE postures_master (
--     id VARCHAR PRIMARY KEY,
--     name VARCHAR NOT NULL UNIQUE,
--     sanskrit_name VARCHAR UNIQUE,
--     level VARCHAR NOT NULL,
--     type VARCHAR NOT NULL,
--     benefits VARCHAR ,
--     duration DOUBLE precision NOT NULL,
--     double_sided BOOLEAN NOT NULL
-- )
-- AS SELECT * FROM CSVREAD('src/main/resources/static/postures_master.csv');
--
