CREATE TABLE pessoa (
   codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
   nome VARCHAR(50) NOT NULL,
   ativo BOOLEAN NOT NULL DEFAULT TRUE,
   logradouro VARCHAR(128),
   numero VARCHAR(8),
   complemento VARCHAR(128),
   bairro VARCHAR(64),
   cep VARCHAR(10),
   cidade VARCHAR(64),
   estado VARCHAR(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
VALUES ('André Gurgel', 'Praça Getulio Vargas', '86', 'Sindicato dos Bancários', 'Centro', '58700-230', 'Patos', 'PB', 1);

INSERT INTO pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo)
VALUES ('Ana Luisa', 'Av. Coronel Martiniano', '2142', 'Penedo', '59300-000', 'Caicó', 'RN', 1);

INSERT INTO pessoa (nome, ativo)
VALUES ('Thamerson Filgueiras', 1);

INSERT INTO pessoa (nome, logradouro, numero, bairro, cep, cidade, estado, ativo)
VALUES ('Carol Medeiros', 'Av. Vidal de Negreiros', '120', 'Centro', '58700-245', 'Patos', 'PB', 1);

INSERT INTO pessoa (nome, ativo)
VALUES ('Gustavo Vitor', 1);

INSERT INTO pessoa (nome, ativo)
VALUES ('Laisa Moura', 1);