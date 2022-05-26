CREATE TABLE IF NOT EXISTS cities
(
    id_city                 SERIAL PRIMARY KEY ,
    name_City          TEXT NOT NULL ,
    num_population     SERIAL NOT NULL ,
    availability_metro BOOLEAN  NOT NULL,
    country            TEXT NOT NULL
    );
CREATE TABLE IF NOT EXISTS sights
(
    id_sights          SERIAL PRIMARY KEY ,
    name_sight         TEXT NOT NULL ,
    date               DATE NOT NULL ,
    description        TEXT  NOT NULL,
    type_sight         TEXT NOT NULL,
    id_city           SERIAL NOT NULL
);