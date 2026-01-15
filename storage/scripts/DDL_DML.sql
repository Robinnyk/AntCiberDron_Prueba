
-- database: storage\Databases\antCiberDron.sqlite

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
    ,trIdHormigaTipo  INTEGER NOT NULL REFERENCES HormigaTipo (IdHormigaTipo)
    ,trIdSexo         INTEGER NOT NULL REFERENCES Sexo        (IdSexo)
    ,trIdEstado       INTEGER NOT NULL REFERENCES Estado      (IdEstado)
    ,trNombre         VARCHAR(20) NOT NULL  UNIQUE
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

-- Insert initial data into Sexo table
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
,('Obrera'    ,' encargada de construir')

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
(1, 2, 1, 'Hormiga1', 'Primera hormiga'),
(2, 1, 1, 'Hormiga2', 'Segunda hormiga'),
(3, 2, 1, 'Hormiga3', 'Tercera hormiga'),
(4, 1, 1, 'Hormiga4', 'Cuarta hormiga');

select * from trSexo;
select * from trHormigaTipo;
select * from trEstado;
select * from trAlimentoTipo;
SELECT * FROM trHormiga;


DROP VIEW IF EXISTS vwHormiga;

CREATE VIEW vwHormiga AS
SELECT 
    H.IdHormiga
    ,HT.Nombre AS Tipo
    ,S.Nombre  AS Sexo
    ,E.Nombre  AS EstadoHormiga
    ,H.Nombre  AS Nombre
    ,H.Descripcion
    ,H.Estado
    ,H.FechaCreacion
    ,H.FechaModifica
FROM Hormiga H
JOIN HormigaTipo    HT ON H.IdHormigaTipo = HT.IdHormigaTipo
JOIN Sexo           S  ON H.IdSexo        = S.IdSexo
JOIN Estado         E  ON H.IdEstado      = E.IdEstado
WHERE H.Estado = 'A';

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
FROM trvwHormiga;


SELECT * FROM trHormiga;



UPDATE trEstado   SET trNombre = 'VIVA'
WHERE trIdEstado = 1;

UPDATE trEstado   SET trNombre = 'MUERTA'
WHERE trIdEstado = 2;

UPDATE trEstado   SET trEstado = 'X'
WHERE trIdEstado = 3;

select * from Estado;

CREATE TABLE trEstadoAlimento (
    trIdEstadoAlimento INTEGER PRIMARY KEY AUTOINCREMENT
    ,trNombre           VARCHAR(15) NOT NULL UNIQUE
    ,trDescripcion      VARCHAR(100) NULL
    ,trEstado           VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,trFechaCreacion    DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,trFechaModifica    DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

INSERT INTO trEstadoAlimento (trNombre, trDescripcion)
VALUES
('SALUDABLE', 'Alimento en buen estado'),
('PODRIDO',   'Alimento descompuesto');


CREATE TABLE trAlimentoExistente (
    trIdAlimentoExistente INTEGER PRIMARY KEY AUTOINCREMENT,
    trIdAlimentoTipo     INTEGER NOT NULL,
    trIdEstadoAlimento   INTEGER NOT NULL,
    trDescripcion        VARCHAR(50) NOT NULL,
    trGenoma             VARCHAR(3) NULL,
    trEstado             VARCHAR(1)  NOT NULL DEFAULT 'A',
    trFechaCreacion      DATETIME    NOT NULL DEFAULT (datetime('now','localtime')),
    trFechaModifica      DATETIME    NOT NULL DEFAULT (datetime('now','localtime')),
    FOREIGN KEY (trIdAlimentoTipo)   REFERENCES AlimentoTipo   (trIdAlimentoTipo),
    FOREIGN KEY (trIdEstadoAlimento) REFERENCES EstadoAlimento (trIdEstadoAlimento)
);

DELETE FROM trAlimentoExistente;


