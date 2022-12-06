CREATE TABLE lancamento (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(128),
    tipo VARCHAR(32) NOT NULL,
    codigo_categoria BIGINT(20) NOT NULL,
    codigo_pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ("Pagamento Black Desert", "2020-06-20", 150, "Compra de perolas", "DESPESA" , 1, 1);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ("Pagamento Minecraft", "2020-07-01", "2020-08-01", 99.99, "Minecraft original", "DESPESA" , 1, 1);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ("Alimentação", "2020-06-30", "2020-06-18", 243.54, "Feira do Mes", "DESPESA" , 3, 6);