CREATE TABLE usuarios(
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    contato1 VARCHAR(20),
    contato2 VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_acesso TIMESTAMP,
    data_cadastro DATE, -- capturar data do sistema
    senha VARCHAR(20), -- configurar validacao da senha e encriptacao no banco usando SHA
    arquivado BOOLEAN,
    admininistrador BOOLEAN,
    bloqueado BOOLEAN, -- configurar validacao para que o administrador libere o cadastro do usuario
    newsletter_user_fk INTEGER REFERENCES newsletter(id),
    noticias_user_fk INTEGER REFERENCES noticias_avisos(id),
    documentos_user_fk INTEGER REFERENCES documentos(id),
    chamado_user_fk INTEGER REFERENCES chamado(numero),
    estacionamento_user_fk INTEGER REFERENCES estacionamento(id),
    funcionarios_user_fk INTEGER REFERENCES funcionarios(id),
    depositos_user_fk INTEGER REFERENCES depositos(id)
 );

CREATE TABLE depositos(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    apartamento VARCHAR(3) NOT NULL,
    data_deposito DATE NOT NULL,
    valor FLOAT NOT NULL,
    obs VARCHAR(200)
);

CREATE TABLE inadimplentes( -- logica de calculo de juros e multa no backend
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    mes CHAR(2) NOT NULL,
    ano CHAR(4) NOT NULL,
    vmensal FLOAT NOT NULL,
    vdevido FLOAT NOT NULL,
    juros FLOAT NOT NULL,
    multa FLOAT NOT NULL,
    vrestante FLOAT NOT NULL,
    arquivado BOOLEAN
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
    anexo VARCHAR(100), -- tela de anexar arquivo somente para o administrador
    arquivado BOOLEAN
);

CREATE TABLE usuarios_legislacao(
    id SERIAL PRIMARY KEY,
    data_acesso TIMESTAMP,
    user_consulta_fk INTEGER REFERENCES usuarios(id),
    leg_consulta_fk INTEGER REFERENCES legislacao(id)
);

CREATE TABLE condominos(
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL, -- configurar validacao soh de numeros 
    data_cadastro DATE, -- capturar data do sistema
    nome VARCHAR(100) NOT NULL,
    observacao VARCHAR(200),
    arquivado BOOLEAN,
    usuarios_condominos_fk INTEGER REFERENCES usuarios(id)
);

CREATE TABLE noticias_avisos(
    id SERIAL PRIMARY KEY,
    texto VARCHAR(200), -- configurar referencia e validacao de caracteres
    arquivado BOOLEAN
);

CREATE TABLE documentos(
    id SERIAL PRIMARY KEY,
    obs VARCHAR(200) NOT NULL,
    data_doc DATE,
    tipo VARCHAR(200) NOT NULL,
    adicionar VARCHAR(100), -- configurar referencia
    arquivado BOOLEAN
);

CREATE TABLE chamado(
    numero SERIAL PRIMARY KEY,
    assunto VARCHAR(200),
    email VARCHAR(50) NOT NULL,
    contato VARCHAR(20),
    nome VARCHAR(100) NOT NULL,
    resposta VARCHAR(400), 
    anexo VARCHAR(100), -- configurar referencia
    arquivado BOOLEAN
);

CREATE TABLE estacionamento(
    id SERIAL PRIMARY KEY,
    apartamento VARCHAR(3) NOT NULL,
    morador VARCHAR(100) NOT NULL,
    obs VARCHAR(200),
    vaga CHAR(2) NOT NULL,
    arquivado BOOLEAN 
);

CREATE TABLE funcionarios(
    id SERIAL PRIMARY KEY,
    data_admissao DATE,
    cpf VARCHAR(11) UNIQUE NOT NULL, -- configurar validacao soh de numeros 
    arquivado BOOLEAN
);

CREATE TABLE relatorios(
    dia VARCHAR(4),
    mes VARCHAR(4), -- configurar validacao
    ano VARCHAR(4), -- configurar validacao
    tipo VARCHAR(30),
    CONSTRAINT pk_dia_mes_ano PRIMARY KEY(dia,mes,ano)    
);

-- CREATE TABLE user_relatorios(
--     id SERIAL PRIMARY KEY,
--     data_acesso TIMESTAMP, -- capturar a data hora do sistema
--     user_acesso_fk INTEGER REFERENCES usuarios(id),
--     relatorios_acesso_fk TIMESTAMP REFERENCES relatorios(data_acesso)
-- );

CREATE TABLE condominio(
    dia VARCHAR(4),
    mes VARCHAR(4), -- configurar validacao
    ano VARCHAR(4), -- configurar validacao
    lancamento VARCHAR(200) NOT NULL,
    vtotal FLOAT NOT NULL, -- funcao de calculo por unidade(48) no backend
    arquivado BOOLEAN,
    CONSTRAINT pk_dia_mes_ano_condominio PRIMARY KEY(dia,mes,ano),
    CONSTRAINT relatorios_condominio_fk FOREIGN KEY(dia,mes,ano) REFERENCES  relatorios(dia,mes,ano)
);

CREATE TABLE consumo(
    dia VARCHAR(4),
    mes VARCHAR(4), -- configurar validacao
    ano VARCHAR(4), -- configurar validacao
    vtotal FLOAT NOT NULL,
    consumo INTEGER NOT NULL,
    arquivado BOOLEAN,
    CONSTRAINT pk_dia_mes_ano_consumo PRIMARY KEY(dia,mes,ano),
    CONSTRAINT relatorios_consumo_fk FOREIGN KEY(dia,mes,ano) REFERENCES  relatorios(dia,mes,ano)
);

CREATE TABLE conta( -- logica do saldo devera ser configurada no backend
    dia VARCHAR(4),
    mes VARCHAR(4), -- configurar validacao
    ano VARCHAR(4), -- configurar validacao
    lancamento VARCHAR(200) NOT NULL,
    documento VARCHAR(30),
    valor FLOAT NOT NULL,
    identificacao VARCHAR(30),
    arquivado BOOLEAN,
    CONSTRAINT pk_dia_mes_ano_conta PRIMARY KEY(dia,mes,ano),
    CONSTRAINT relatorios_conta_fk FOREIGN KEY(dia,mes,ano) REFERENCES  relatorios(dia,mes,ano)
);
