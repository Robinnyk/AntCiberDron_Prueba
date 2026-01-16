-- database: ../Databases/antCiberDron.sqlite

DROP TABLE IF EXISTS trAntCiberDron;
DROP TABLE IF EXISTS trHormiga;
DROP TABLE IF EXISTS trSexo;
DROP TABLE IF EXISTS trEstado;
DROP TABLE IF EXISTS trHormigaTipo;
DROP TABLE IF EXISTS trAlimentoTipo; 
DROP TABLE IF EXISTS trEstadoAlimento;
DROP TABLE IF EXISTS trAlimentoExistente;

CREATE TABLE trAlimentoTipo(
    trIdAlimentoTipo INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre         VARCHAR(15)  NOT NULL UNIQUE
    ,trDescripcion    VARCHAR(100) NULL
    ,trEstado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE trHormigaTipo (
    trIdHormigaTipo  INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre         VARCHAR(15)  NOT NULL UNIQUE
    ,trDescripcion    VARCHAR(100) NULL
    ,trEstado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE trEstado (
    trIdEstado       INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre         VARCHAR(15)  NOT NULL UNIQUE
    ,trDescripcion    VARCHAR(100) NULL
    ,trEstado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE trSexo (
    trIdSexo         INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre         VARCHAR(15)  NOT NULL UNIQUE
    ,trDescripcion    VARCHAR(100) NULL
    ,trEstado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE trHormiga (
    trIdHormiga      INTEGER PRIMARY KEY AUTOINCREMENT
    ,trIdHormigaTipo  INTEGER NOT NULL REFERENCES trHormigaTipo (trIdHormigaTipo)
    ,trIdSexo         INTEGER NOT NULL REFERENCES trSexo        (trIdSexo)
    ,trIdEstado       INTEGER NOT NULL REFERENCES trEstado      (trIdEstado)
    ,trNombre         VARCHAR(20) NOT NULL 
    ,trDescripcion    VARCHAR(20) NULL

    ,trEstado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

DELETE FROM trHormiga;

CREATE TABLE trAntCiberDron (
    trIdAntCiberDron     INTEGER PRIMARY KEY AUTOINCREMENT
    ,trSerie              VARCHAR(10) NOT NULL  UNIQUE
    ,trEstado             VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion      DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,trFechaModifica      DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE trEstadoAlimento (
    trIdEstadoAlimento INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre           VARCHAR(15) NOT NULL UNIQUE
    ,trDescripcion      VARCHAR(100) NULL
    ,trEstado           VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion    DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,trFechaModifica    DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

CREATE TABLE trAlimentoExistente (
    trIdAlimentoExistente INTEGER PRIMARY KEY AUTOINCREMENT,
    trIdAlimentoTipo     INTEGER NOT NULL,
    trIdEstadoAlimento   INTEGER NOT NULL,
    trDescripcion        VARCHAR(50) NOT NULL,
    trGenoma             VARCHAR(3) NULL,
    trEstado             VARCHAR(1)  NOT NULL DEFAULT 'A',
    trFechaCreacion      DATETIME    NOT NULL DEFAULT (datetime('now','localtime')),
    trFechaModifica      DATETIME    NOT NULL DEFAULT (datetime('now','localtime')),
    FOREIGN KEY (trIdAlimentoTipo)   REFERENCES trAlimentoTipo   (trIdAlimentoTipo),
    FOREIGN KEY (trIdEstadoAlimento) REFERENCES trEstadoAlimento (trIdEstadoAlimento)
);

INSERT INTO trSexo 
 (trNombre, trDescripcion)  VALUES 
 ('Macho'  ,' masculino')
,('Hembra' ,' femenina') 
,('Hibrido',' Hibrido')
,('Asexual',' Asexual');

INSERT INTO trAlimentoTipo
 (trNombre, trDescripcion)  VALUES
 ('Carne'   ,'Azucar')
,('Hierba' ,'Proteina')
,('Mezcla'  ,'Lipidico')
,('Nectar','Vitaminico');

INSERT INTO trHormigaTipo
 (trNombre, trDescripcion)  VALUES 
 ('Larva'     ,' en etapa de larva')
,('Soldado'   ,' encargada de la defensa')
,('Rastreadora',' encargada de buscar alimento')
,('Reina'     ,' encargada de la reproducción')
,('Zángano'   ,' macho para reproducción')
,('Obrera'    ,' encargada de construir');

INSERT INTO trEstado
 (trNombre, trDescripcion)  VALUES 
 ('Vive' ,' está viva'),
 ('Muere',' ha muerto'),
 ('Finge',' su muerte');

INSERT INTO trAntCiberDron
(trSerie)     VALUES 
('S001'),
('S002'),
('S003'),
('S004');
    
INSERT INTO trHormiga
(trIdHormigaTipo, trIdSexo, trIdEstado, trNombre, trDescripcion) values 
(6, 2, 1, 'Hormiga1', 'Primera hormiga'),
(6, 1, 1, 'Hormiga2', 'Segunda hormiga'),
(6, 2, 1, 'Hormiga3', 'Tercera hormiga'),
(6, 1, 1, 'Hormiga4', 'Cuarta hormiga');

select * from trSexo;
select * from trHormigaTipo;
select * from trEstado;
select * from trAlimentoTipo;
SELECT * FROM trHormiga;

CREATE VIEW vwHormiga AS
SELECT 
    H.trIdHormiga,
    HT.trNombre AS Tipo,
    S.trNombre  AS Sexo,
    E.trNombre  AS EstadoHormiga,
    H.trNombre  AS Nombre,
    H.trDescripcion,
    H.trEstado,
    H.trFechaCreacion,
    H.trFechaModifica
FROM trHormiga H
JOIN trHormigaTipo HT ON H.trIdHormigaTipo = HT.trIdHormigaTipo
JOIN trSexo        S  ON H.trIdSexo        = S.trIdSexo
JOIN trEstado      E  ON H.trIdEstado      = E.trIdEstado
WHERE H.trEstado = 'A';


SELECT * FROM vwHormiga;

SELECT trIdHormiga
,trTipo
,trSexo
,trEstadoHormiga
,trNombre
,trDescripcion
,trEstado
,trFechaCreacion
,trFechaModifica  
FROM vwHormiga;


SELECT * FROM trHormiga;



UPDATE trEstado   SET trNombre = 'VIVA'
WHERE trIdEstado = 1;

UPDATE trEstado   SET trNombre = 'MUERTA'
WHERE trIdEstado = 2;

UPDATE trEstado   SET trEstado = 'X'
WHERE trIdEstado = 3;

select * from Estado;



INSERT INTO trEstadoAlimento (trNombre, trDescripcion)
VALUES
('SALUDABLE', 'Alimento en buen estado'),
('PODRIDO',   'Alimento descompuesto');

SELECT name FROM sqlite_master WHERE type='table';
