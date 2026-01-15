-- database: ../Databases/antCiberDron.sqlite
    
    PRAGMA foreign_keys = ON;


    DROP TABLE IF EXISTS trHormiga;
    DROP TABLE IF EXISTS trAntCiberDron;
    
    DROP TABLE IF EXISTS trCatalogo;
    DROP TABLE IF EXISTS trCatalogoTipo; 

    CREATE TABLE trCatalogoTipo (
        trIdCatalogoTipo  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        trNombre          VARCHAR(50) NOT NULL,
        trDescripcion     VARCHAR(90),
        trEstado          VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion   DATETIME DEFAULT CURRENT_TIMESTAMP,
        trFechaModifica   DATETIME
    );

    CREATE TABLE trCatalogo (
        trIdCatalogo      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        trIdCatalogoTipo  INTEGER NOT NULL REFERENCES trCatalogoTipo(trIdCatalogoTipo),
        trNombre          VARCHAR(10) NOT NULL,
        trDescripcion     VARCHAR(90),
        trEstado          VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion   DATETIME DEFAULT (datetime('now', 'localtime')),
        trFechaModifica   DATETIME,

        UNIQUE (trIdCatalogoTipo, trNombre)
    );


    CREATE TABLE trAntCiberDron (
        
        trIdAntCiberDron  INTEGER PRIMARY KEY AUTOINCREMENT,
        trNombre          TEXT NOT NULL,
        trSerie           TEXT NOT NULL,
        trDescripcion     TEXT,
        trEstado             VARCHAR(1)  NOT NULL DEFAULT 'A',
        trFechaCreacion      DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
        trFechaModifica      DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))

    );

    CREATE TABLE trHormiga (
        trIdHormiga                      INTEGER PRIMARY KEY AUTOINCREMENT, 

        trIdCatalogoTipo                 INTEGER NOT NULL,
        trIdCatalogoSexo                 INTEGER NOT NULL,
        trIdCatalogoAlimento             INTEGER NOT NULL,
        trIdCatalogoGenomas              INTEGER NOT NULL,

        trNombre                         VARCHAR(50) NOT NULL,
        trApellido                       VARCHAR(50) NOT NULL,

        trEstado                         VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion                  DATETIME DEFAULT (datetime('now', 'localtime')),
        trFechaModifica                  DATETIME,

        FOREIGN KEY (trIdCatalogoPersona) 
            REFERENCES trCatalogo(trIdCatalogo),

        FOREIGN KEY (trIdCatalogoSexo) 
            REFERENCES trCatalogo(trIdCatalogo),

        FOREIGN KEY (trIdCatalogoEstadoCivil) 
            REFERENCES trCatalogo(trIdCatalogo)

    );





CREATE TABLE Hormiga (
     IdHormiga      INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdHormigaTipo  INTEGER NOT NULL REFERENCES HormigaTipo (IdHormigaTipo)
    ,IdSexo         INTEGER NOT NULL REFERENCES Sexo        (IdSexo)
    ,IdEstado       INTEGER NOT NULL REFERENCES Estado      (IdEstado)
    ,Nombre         VARCHAR(20) NOT NULL  UNIQUE
    ,Descripcion    VARCHAR(20) NULL

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE AntCiberDron (
     IdAntCiberDron     INTEGER PRIMARY KEY AUTOINCREMENT
    ,Serie              VARCHAR(10) NOT NULL  UNIQUE
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion      DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica      DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

-- Insert initial data into Sexo table
INSERT INTO Sexo 
 (Nombre, Descripcion)  VALUES 
 ('Macho'  ,' masculino')
,('Hembra' ,' femenina') 
,('Hibrido',' Hibrido')
,('Asexual',' Asexual');

INSERT INTO AlimentoTipo
 (Nombre, Descripcion)  VALUES
 ('Carnivoro'   ,'Azucar')
,('Herbívoro' ,'Proteina')
,('Omnívoro'  ,'Lipidico')
,('Nectarivoro','Vitaminico');

INSERT INTO HormigaTipo
 (Nombre, Descripcion)  VALUES 
 ('Larva'     ,' en etapa de larva')
,('Soldado'   ,' encargada de la defensa')
,('Rastreadora',' encargada de buscar alimento')
,('Reina'     ,' encargada de la reproducción')
,('Zángano'   ,' macho para reproducción');

INSERT INTO Estado
 (Nombre, Descripcion)  VALUES 
 ('Vive' ,' está viva'),
 ('Muere',' ha muerto'),
 ('Finge',' su muerte');

INSERT INTO AntCiberDron
(Serie)     VALUES 
('S001'),
('S002'),
('S003'),
('S004');
    
INSERT INTO Hormiga
(IdHormigaTipo, IdSexo, IdEstado, Nombre, Descripcion) values 
(1, 2, 1, 'Hormiga1', 'Primera hormiga'),
(2, 1, 1, 'Hormiga2', 'Segunda hormiga'),
(3, 2, 1, 'Hormiga3', 'Tercera hormiga'),
(4, 1, 1, 'Hormiga4', 'Cuarta hormiga');

select * from Sexo;
select * from HormigaTipo;
select * from Estado;
select * from AlimentoTipo;
SELECT * FROM Hormiga;


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

SELECT IdHormiga
,Tipo
,Sexo
,EstadoHormiga
,Nombre
,Descripcion
,Estado
,FechaCreacion
,FechaModifica  
FROM vwHormiga;


SELECT * FROM Hormiga;



UPDATE Estado   SET Nombre = 'VIVA'
WHERE IdEstado = 1;

UPDATE Estado   SET Nombre = 'MUERTA'
WHERE IdEstado = 2;

UPDATE Estado   SET Estado = 'X'
WHERE IdEstado = 3;

select * from Estado;
    


