CREATE DATABASE matelas;
\c matelas; 
CREATE TABLE bloc(
   id SERIAL PRIMARY KEY,
   id_origine INTEGER ,/* NULL izy raha ohatra ka tsy reste */
   longueur DECIMAL NOT NULL,
   largeur DECIMAL NOT NULL,
   hauteur DECIMAL NOT NULL,
   daty DATE NOT NULL,
   prix_revient DECIMAL NOT NULL,
   FOREIGN KEY (id_origine) REFERENCES bloc(id) 
);

CREATE TABLE usuel(
   id SERIAL,
   designation VARCHAR(50) ,
   longueur DECIMAL  NOT NULL,
   largeur DECIMAL   NOT NULL,
   hauteur DECIMAL   NOT NULL,
   prix DECIMAL NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(designation)
);

CREATE TABLE reste_bloc(
    id SERIAL PRIMARY KEY,
    id_block INTEGER,
    volume DECIMAL,
    daty DATE
);

-- CREATE TABLE blocOrigine(
--     id VARCHAR PRIMARY KEY,
--     idBloc VARCHAR,
--     PRIMARY KEY (id,idBloc)
-- ); atao origine raha afaka manatambatra bloc

/* Tsy ilaina */
CREATE TABLE prix_usuel(
    id SERIAL PRIMARY KEY,
    id_usuel INTEGER,
    pu DECIMAL NOT NULL,
    daty DATE,
    FOREIGN KEY(id_usuel) REFERENCES usuel(id) 
);
/*--------------------------*/
CREATE TABLE fabrication(
    id SERIAL PRIMARY KEY,
    id_usuel INTEGER,
    id_bloc INTEGER,
    quantite INTEGER, 
    daty DATE,
    FOREIGN KEY(id_usuel) REFERENCES usuel(id),
    FOREIGN KEY(id_bloc) REFERENCES bloc(id) 
);

CREATE TABLE mvt_stock_usuel(
    id SERIAL PRIMARY KEY,
    id_fab INTEGER,
    entree INTEGER DEFAULT 0,
    sortie INTEGER DEFAULT 0,
    daty DATE,
    FOREIGN KEY(id_fab) REFERENCES fabrication(id)
);
CREATE OR REPLACE VIEW v_mvt_stock_usuel as 
SELECT msu.id,msu.id_fab,msu.entree,msu.sortie 

/* Le daty no mitovy raha mitady fabrication t@ Daty stock */


/* ALTER SEQUENCE seqUsuel RESTART; */


INSERT INTO usuel(id,designation,longueur,largeur,hauteur,prix) VALUES
                (1,'U1',16.00,4,2,20000.0),
                (2,'U2',5.0,1.0,1.0,12000.0),
                (3,'U3',10.0,7.0,1.0,600);
                
INSERT INTO bloc(id,longueur,largeur,hauteur,daty,prix_revient) VALUES
                (1,100,20,10,'2024-01-01',3000000),
                (2,100,40,10,'2024-01-01',2000000);

INSERT INTO fabrication(id,id_usuel,id_bloc,quantite,daty) VALUES
                (1,1,1,42,'2024-01-01'),
                (2,2,1,50,'2024-01-01'),
                (3,3,1,1000,'2024-01-01'),
                (4,1,2,100,'2024-01-01'),
                (5,2,2,250,'2024-01-01'),
                (6,3,2,500,'2024-01-01');

INSERT INTO mvt_stock_usuel(id,id_fab,entree,daty) VALUES
                            (1,1,42,'2024-01-01'),
                            (2,2,50,'2024-01-01'),
                            (3,3,1000,'2024-01-01'),
                            (4,4,100,'2024-01-01'),
                            (5,5,250,'2024-01-01'),
                            (6,6,500,'2024-01-01');
/*Reste*/
INSERT INTO bloc(id,id_origine,longueur,largeur,hauteur,daty,prix_revient) VALUES
                (21,2,500,2,3,'2024-01-01',3000),
                (22,2,500,2,3,'2024-01-01',3000); 



DELETE FROM fabrication;
DELETE FROM mvt_stock_usuel;

DROP TABLE mvt_stock_usuel;
DROP TABLE fabrication;
