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