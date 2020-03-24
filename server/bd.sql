CREATE TABLE usuarios(
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    contato1 VARCHAR(20),
    contato2 VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_acesso TIMESTAMP,
    arquivado BOOLEAN,
    newsletter_user_fk INTEGER REFERENCES newsletter(id)
 );

CREATE TABLE newsletter(
    id SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    arquivado BOOLEAN    
);

CREATE TABLE legislacao(
    id SERIAL PRIMARY KEY,
    assunto VARCHAR(200) NOT NULL,
    data_leg DATE NOT NULL,
    tipo VARCHAR(200) NOT NULL,
    arquivado BOOLEAN
);

CREATE TABLE usuarios_legislacao(
    id SERIAL PRIMARY KEY,
    data_acesso TIMESTAMP,
    user_consulta_fk INTEGER REFERENCES usuarios(id),
    leg_consulta_fk INTEGER REFERENCES legislacao(id)
);

CREATE TABLE condomino(
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL, -- configurar validacao soh de numeros 
    data_cadastro DATE, -- capturar data do sistema
    nome VARCHAR(100) NOT NULL,
    observacao VARCHAR(200),
    arquivado BOOLEAN
    --FALTOU DEFINIR A CHAVE ESTRANGEIRA --> PAREI AQUI
);