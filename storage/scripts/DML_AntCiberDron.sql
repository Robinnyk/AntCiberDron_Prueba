-- database: ../Databases/antCiberDron.sqlite

INSERT INTO trCatalogoTipo (trNombre, trDescripcion) VALUES
( 'Tipo Hormiga'    , 'Tipos: larva, obrera, soldado, zangano, rastreadora, reina, obrera.'),
( 'Sexo'            , 'Tipos: masculino, femenino, ...'),
( 'Alimento'        , 'Tipos: nectarivoro, carnivoro, omnivoro, insectivoro, hervivoro.'), 
( 'Genomas'         , 'Tipos: XX, X, XY.');

INSERT INTO trCatalogo (trIdCatalogoTipo, trNombre, trDescripcion) VALUES
( 1                 ,'Larva', 'Tipo de hormiga'),                   -- 1
( 1                 ,'Soldado', 'Tipo de hormiga'),                 -- 2
( 1                 ,'Zángano', 'Tipo de hormiga'),                 -- 3
( 1                 ,'Rastreadora', 'Tipo de hormiga'),             -- 4
( 1                 ,'Reina', 'Tipo de hormiga'),                   -- 5
( 1                 ,'Obrera', 'Tipo de hormiga'),                  -- 6

( 2                 ,'Masculino', 'Tipo de sexualidad'),            -- 7
( 2                 ,'Femenino', 'Tipo de sexualidad'),             -- 8
( 2                 ,'Hibrido', 'Tipo de sexualidad'),              -- 9
( 2                 ,'Asexual', 'Tipo de sexualidad'),              -- 10

( 3                 ,'Nectarívoro', 'Tipo de alimentación'),        -- 11
( 3                 ,'Carnívoro', 'Tipo de alimentación'),          -- 12
( 3                 ,'Omnívoro', 'Tipo de alimentación'),           -- 13
( 3                 ,'Insectívoro', 'Tipo de alimentación'),        -- 14
( 3                 ,'Herbívoro', 'Tipo de alimentación'),          -- 15

( 4                 ,'XX', 'Tipo de genoma'),                       -- 16
( 4                 ,'X', 'Tipo de genoma'),                        -- 17
( 4                 ,'XY', 'Tipo de genoma');                       -- 18    


INSERT INTO trAntCiberDron (trIdIAbot, trNombre, trSerie) VALUES
( 1                 , "Exobot_001", "Serie E1"),
( 1                 , "Exobot_002", "Serie E2"),
( 1                 , "Exobot_003", "Serie E3");

INSERT INTO trHormiga   
(trIdCatalogoHormiga, trIdCatalogoSexo, trIdAlimento,  trIdCatalogoGenomas,    trNombre,     trApellido) VALUES
(6,                   7,                    15,              'XY',              'Juan',       'Pérez'),
(6,                   8,                    15,              'XX',              'María',      'Gómez'),
(6,                   10,                   11,              'X',               'Carlos',     'Ramírez'),
(4,                   8,                    12,              'XX',              'Ana',        'López'),
(1,                   7,                    13,              'XY',              'Pepito',     'Putin'),
(2,                   8,                    14,              'XX',              'Giuliana',   'Torres'),
(3,                   8,                    14,              'XX',              'Eva',        'Reyes'),
(5,                   8,                    12,              'XX',              'Perla',      'Villa');

SELECT trIdCatalogo
, trIdCatalogoTipo
, trNombre
, trDescripcion
, trEstado
, trFechaCreacion
, trFechaModifica
FROM trCatalogo
WHERE trEstado = 'A'
AND trIdCatalogoTipo = 2;

SELECT COUNT(*) TotalReg 
FROM trCatalogo 
WHERE trIdCatalogoTipo = 2 
AND trEstado = 'A';