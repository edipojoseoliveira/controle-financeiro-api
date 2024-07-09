CREATE TABLE despesas (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    vencimento DATE NOT NULL,
    situacao VARCHAR(100) NOT NULL,
    grupo VARCHAR(100) NOT NULL
);