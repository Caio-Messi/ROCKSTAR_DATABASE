create database rockstar_db;

use rockstar_db;

/*Area Jogos*/

create table jogos(
id_jogo int primary key auto_increment unique,
nome_jogo varchar (100) not null,
genero varchar (50) not null,
data_lancamento date not null unique,
preço_base decimal (10,2),
PLATAFORMA_ID INT,
FOREIGN KEY (PLATAFORMA_ID) REFERENCES PLATAFORMAS (ID_PLATAFORMA)
);

INSERT INTO JOGOS (NOME_JOGO, DATA_LANCAMENTO, PREÇO_BASE, GENERO) VALUES 
('Grand Theft Auto V', '2013-09-17', 59.99, 'Ação e Aventura'),
('Red Dead Redemption 2', '2018-10-26', 69.99, 'Ação e Aventura'),
('Red Dead Redemption', '2010-05-18', 39.99, 'Ação e Aventura'),
('Grand Theft Auto: San Andreas', '2004-10-26', 39.99, 'Ação e Aventura'),
('Grand Theft Auto IV', '2008-04-29', 49.99, 'Ação e Aventura'),
('Grand Theft Auto: Vice City', '2002-10-29', 29.99, 'Ação e Aventura'),
('Grand Theft Auto III', '2001-10-22', 29.99, 'Ação e Aventura'),
('Bully', '2006-10-17', 19.99, 'Ação e Aventura'),
('Max Payne 3', '2012-05-15', 49.99, 'Ação'),
('L.A. Noire', '2011-05-17', 39.99, 'Aventura e Investigação'),
('Midnight Club: Los Angeles', '2008-10-21', 29.99, 'Corrida'),
('Manhunt', '2003-11-18', 19.99, 'Terror'),
('Manhunt 2', '2007-10-29', 19.99, 'Terror'),
('Smuggler\s Run 2: Hostile Territory', '2001-10-30', 19.99, 'Corrida'),
('Oni', '2001-01-29', 19.99, 'Ação'),
('Midnight Club II', '2003-04-08', 29.99, 'Corrida'),
('Midnight Club 3: DUB Edition', '2005-04-11', 29.99, 'Corrida'),
('Grand Theft Auto: London 1969', '1999-03-31', 9.99, 'Ação e Aventura'),
('Grand Theft Auto', '1997-10-21', 9.99, 'Ação e Aventura'),
('Grand Theft Auto 2', '1999-09-30', 9.99, 'Ação e Aventura'),
('Red Dead Revolver', '2004-05-03', 19.99, 'Ação e Aventura'),
('Grand Theft Auto: The Ballad of Gay Tony', '2009-10-29', 19.99, 'Ação e Aventura'),
('Grand Theft Auto: The Lost and Damned', '2009-02-17', 19.99, 'Ação e Aventura'),
('Max Payne', '2001-07-23', 29.99, 'Ação');

delete from jogos where id_jogo = 10;
delete from jogos where id_jogo = 22;
delete from jogos where id_jogo = 23;

create table plataformas(
id_plataforma int not null primary key unique auto_increment,
nome_plataforma varchar (30) not null
); 	

INSERT INTO PLATAFORMAS (NOME_PLATAFORMA) VALUES
	('XBOX'),
    ('PLAYSTATION'),
    ('PC');
    
CREATE TABLE EXPANSOES (
    ID_EXPANSOES INT AUTO_INCREMENT PRIMARY KEY,
    NOME_EXPANSOES VARCHAR(255) NOT NULL,
    DESCRICAO TEXT,
    DATA_LANCAMENTO DATE,
    ID_JOGO INT,
    FOREIGN KEY (ID_JOGO) REFERENCES JOGOS(ID_JOGO)
);
INSERT INTO EXPANSOES (NOME_EXPANSOES, DESCRICAO, DATA_LANCAMENTO, ID_JOGO)
VALUES 
('Expansão do Mapa de Los Santos', 'Adiciona novas áreas e missões em Los Santos no jogo GTA V.', '2023-05-01', 1),
('Novo Passe de Temporada', 'Expande as opções de personalização e desafios diários no GTA Online.', '2023-06-15', 1),
('Pioneiros do Oeste', 'Nova expansão para Red Dead Online com missões inéditas e uma nova região.', '2023-07-20', 2),
('Caçadores de Tesouros', 'Introduz caçadas e descobertas no Red Dead Redemption 2.', '2023-08-12', 2),
('Modo Sobrevivência em Grupo', 'Novo modo competitivo de sobrevivência com equipes no GTA Online.', '2023-09-05', 1),
('Fazenda Virtual', 'Expansão que permite construir e gerenciar uma fazenda em Red Dead Online.', '2023-10-10', 2),
('Batalhas de Veículos', 'Expansão do modo de combate veicular em GTA V.', '2023-11-30', 1),
('Cidades Perdidas', 'Novas missões e uma cidade misteriosa descoberta no mapa de GTA V.', '2024-01-05', 1),
('Vingança no Oeste', 'Histórias novas e uma nova facção de vilões para enfrentar em Red Dead Redemption 2.', '2024-02-18', 2),
('Aventuras no Deserto', 'Expansão com novos cenários e missões no deserto de Red Dead Online.', '2024-03-07', 2),
('Operação Secreta', 'Missões secretas e novos veículos em GTA V.', '2024-04-22', 1),
('Aliança de Foras-da-Lei', 'Introduz facções rivais e novas missões cooperativas em Red Dead Online.', '2024-06-15', 2),
('Corridas de Aventura', 'Expansão de corridas de aventura com obstáculos e novos veículos em GTA Online.', '2024-07-10', 1),
('Red Dead Vampiros', 'Expansão temática com criaturas sobrenaturais e mistérios no velho oeste.', '2024-08-03', 2),
('GTA V: Guerra Cibernética', 'Nova expansão com hackeamento e combates tecnológicos no GTA Online.', '2024-09-17', 1),
('Exploração das Montanhas', 'Novo mapa nas montanhas de Red Dead Redemption 2 com missões de exploração.', '2024-10-20', 2),
('GTA Online: Golpes Mega', 'Golpes e assaltos mais complexos e com maiores recompensas em GTA Online.', '2024-11-04', 1),
('Desafio dos Caçadores', 'Missões e competições para caçar animais raros no mundo de Red Dead Online.', '2025-01-15', 2),
('Corrida Infinita', 'Expansão com novos modos de corrida e circuitos em GTA V.', '2025-02-22', 1),
('A Era do Ouro', 'Expansão que traz a corrida pelo ouro para Red Dead Redemption 2.', '2025-03-05', 2);

delete from expansoes where id_expansoes = 9;

CREATE TABLE contas (
    id_conta INT PRIMARY KEY AUTO_INCREMENT,
    tipo_conta ENUM('A_PAGAR', 'A_RECEBER') NOT NULL,
    descricao VARCHAR(255),
    valor DECIMAL(10,2),
    data DATE,
    status ENUM('EM_ABERTO', 'ATRASADO', 'LIQUIDADO') NOT NULL
);

create table contas_finaceiras(
	id int primary key auto_increment unique not null, 
    nome_conta varchar (100),
	tipo_conta enum ('CONTA CORRENTE', 'CONTA POUPANÇA', 'CAIXA'),
	agencia varchar (20),
    numero_conta varchar(20),
    saldo decimal (12,2) default 0
);

create table transferencias ( 
	id_transferencia int not null unique auto_increment,
    conta_origem int,
    conta_destino int,
    valor decimal (10,2) not null,
    data_movimentacao date not null,
    foreign key (conta_origem) references contas_finaceiras (id),
    foreign key (conta_destino) references contas_finaceiras (id)
);

/*drop table transferencias;*/

create table fluxo_caixa (
	id int primary key auto_increment not null unique,
    tipo_movimentacao ENUM ('ENTRADA', 'SAIDA'),
    descricao varchar (255), 
    valor decimal (10,2),
    data_movimentacao date,
    id_conta int ,
    id_transferencias int,
    foreign key (id_conta) references contas_finaceiras (id)
    );

/* Adição dos inserts*/

-- Contas a pagar
INSERT INTO contas (tipo_conta, descricao, valor, data, status)
VALUES 
('A_PAGAR', 'Licença de software anual', 1200.00, '2025-05-01', 'EM_ABERTO'),
('A_PAGAR', 'Campanha publicitária Q2', 5000.00, '2025-04-10', 'ATRASADO'),
('A_PAGAR', 'Serviços de hospedagem de site', 250.00, '2025-04-15', 'EM_ABERTO'),
('A_PAGAR', 'Pagamento de fornecedores de jogos', 45000.00, '2025-05-05', 'EM_ABERTO'),
('A_PAGAR', 'Contas de energia elétrica', 800.00, '2025-04-20', 'EM_ABERTO'),
('A_PAGAR', 'Taxas de manutenção de servidores', 600.00, '2025-04-22', 'EM_ABERTO'),
('A_PAGAR', 'Licenciamento de música para jogo', 1500.00, '2025-04-18', 'EM_ABERTO'),
('A_PAGAR', 'Despesas de marketing internacional', 8500.00, '2025-05-02', 'EM_ABERTO'),
('A_PAGAR', 'Reparo de equipamentos de estúdio', 1200.00, '2025-04-25', 'EM_ABERTO'),
('A_PAGAR', 'Consultoria de TI para servidores', 3200.00, '2025-04-30', 'EM_ABERTO');

-- Contas a receber
INSERT INTO contas (tipo_conta, descricao, valor, data, status)
VALUES 
('A_RECEBER', 'Venda de pacotes GTA Online', 320.00, '2025-04-20', 'LIQUIDADO'),
('A_RECEBER', 'Venda de produtos físicos (merchandising)', 1500.00, '2025-04-15', 'EM_ABERTO'),
('A_RECEBER', 'Licenciamento de jogos para plataformas externas', 5000.00, '2025-04-18', 'EM_ABERTO'),
('A_RECEBER', 'Assinaturas de jogadores no Rockstar Social Club', 800.00, '2025-04-22', 'EM_ABERTO'),
('A_RECEBER', 'Receita de vendas de Red Dead Redemption 2', 2400.00, '2025-04-10', 'LIQUIDADO'),
('A_RECEBER', 'Parceria de conteúdo com influenciadores', 2000.00, '2025-04-25', 'EM_ABERTO'),
('A_RECEBER', 'Venda de jogos físicos e digitais', 10000.00, '2025-05-01', 'EM_ABERTO'),
('A_RECEBER', 'Contrato de patrocinador para evento', 30000.00, '2025-04-15', 'EM_ABERTO'),
('A_RECEBER', 'Receita de vendas de DLCs', 1500.00, '2025-04-30', 'EM_ABERTO'),
('A_RECEBER', 'Licenciamento de personagens para outras mídias', 4000.00, '2025-05-05', 'EM_ABERTO');

/*select * from contas;*/

INSERT INTO contas_finaceiras (nome_conta, tipo_conta, agencia, numero_conta, saldo)
VALUES
  ('Bank of America','CONTA CORRENTE', '001', '123456789', 100000.00),
  ('JPMorgan Chase', 'CONTA POUPANÇA',  '002', '987654321',  50000.00),
  ('Wells Fargo', 'CONTA CORRENTE', '003', '111222333',  75000.00),
  ('Citibank', 'CONTA CORRENTE', '004', '444555666', 120000.00),
  ('Chase','CONTA POUPANÇA',  '005', '777888999',  30000.00),
  ('Caixa Interno ', 'CAIXA',  'N/A', '000000000',  20000.00);


INSERT INTO transferencias (conta_origem, conta_destino, valor, data_movimentacao)
VALUES
  -- 1: BoFA → JPMorgan
  (1, 2, 10000.00, '2025-04-01'),
  -- 2: Wells Fargo → Citibank
  (3, 4, 15000.00, '2025-04-05'),
  -- 3: Chase Poupança → BoFA
  (5, 1,  5000.00, '2025-04-10'),
  -- 4: Caixa Interno → Wells Fargo
  (6, 3,  2000.00, '2025-04-12'),
  -- 5: Citibank → Caixa Interno
  (4, 6,  3000.00, '2025-04-15');

INSERT INTO FLUXO_CAIXA (TIPO_MOVIMENTACAO, DESCRICAO, VALOR, DATA_MOVIMENTACAO) VALUES
('ENTRADA', 'Receita de vendas Steam', 89000.00, '2025-04-02'),
('SAÍDA', 'Licença de software', 2600.00, '2025-04-03'),
('ENTRADA', 'Venda de Cash Cards Xbox', 19000.00, '2025-04-04'),
('SAÍDA', 'Transferência para funcionários', 45000.00, '2025-04-06'),
('ENTRADA', 'Assinaturas Rockstar+', 12000.00, '2025-04-07'),
('SAÍDA', 'Campanha de marketing online', 15000.00, '2025-04-08'),
('ENTRADA', 'Licenciamento de engine', 15000.00, '2025-04-09'),
('SAÍDA', 'Serviço de catering', 3500.00, '2025-04-10'),
('ENTRADA', 'Venda de RDR2 Online', 16000.00, '2025-04-11'),
('SAÍDA', 'Pagamento fornecedor arte', 4000.00, '2025-04-12'),
('ENTRADA', 'Parceria Twitch', 11000.00, '2025-04-13'),
('SAÍDA', 'Serviço de backup em nuvem', 3000.00, '2025-04-14'),
('ENTRADA', 'Royalties de streaming', 4700.00, '2025-04-15'),
('SAÍDA', 'Consultoria UX', 4800.00, '2025-04-16'),
('ENTRADA', 'Venda GTA Trilogy', 32000.00, '2025-04-17'),
('SAÍDA', 'Compra de cadeiras', 6000.00, '2025-04-18'),
('ENTRADA', 'Receita de GTA+', 10000.00, '2025-04-19'),
('SAÍDA', 'Pagamento AWS', 14000.00, '2025-04-20'),
('ENTRADA', 'Venda Midnight Club', 9500.00, '2025-04-21'),
('SAÍDA', 'Serviço de manutenção elétrica', 1100.00, '2025-04-22');

INSERT INTO fluxo_caixa (tipo_movimentacao, descricao, valor, data_movimentacao) VALUES
('ENTRADA', 'Recebimento de pagamento de cliente', 5000.00, '2025-04-16'),
('SAÍDA', 'Pagamento de fornecedor', 2000.00, '2025-04-16'),
('ENTRADA', 'Venda de produto', 1500.00, '2025-04-16'),
('SAÍDA', 'Pagamento de conta de luz', 300.00, '2025-04-16'),
('ENTRADA', 'Recebimento de juros de conta bancária', 100.00, '2025-04-16'),
('SAÍDA', 'Pagamento de aluguel', 1000.00, '2025-04-16'),
('ENTRADA', 'Venda de ativos', 7000.00, '2025-04-16'),
('SAÍDA', 'Pagamento de salários', 4000.00, '2025-04-16'),
('ENTRADA', 'Recebimento de empréstimo bancário', 20000.00, '2025-04-16'),
('SAÍDA', 'Pagamento de impostos', 1200.00, '2025-04-16');


select * FROM CONTAS;
SELECT * FROM CONTAS_finaceiras;
SELECT * FROM TRANSFERENCIAS;
SELECT * FROM FLUXO_CAIXA;

/*AREA DE MARKETING*/

/*tabelas de normalização*/

create table faixa_etaria(
	id int primary key auto_increment,
    faixa varchar (50) not null
);

create table genero_campanha (
	id int primary key auto_increment,
    tipo varchar (50) not null
);

create table consumo (
	id int primary key auto_increment not null,
    descricao varchar (100)
);

CREATE TABLE LOCALIZACAO (
	ID_LOCALIZACAO INT primary KEY auto_increment,
    CIDADE VARCHAR (50),
    PAIS VARCHAR (50)
);
create table tipo_canal (
	id int primary key auto_increment,
    descricao varchar (100) not null
);

CREATE TABLE CAMPANHAS (
	ID_CAMPANHA INT NOT NULL auto_increment primary KEY,
    NOME_CAMPANHA VARCHAR (200) NOT NULL,
    DESCRICAO_CAMPANHA VARCHAR (500),
    DATA_INICIO  DATE NOT NULL,
    DATA_TERMINO DATE,
    VALOR_INVESTIDO DECIMAL (10,2) NOT NULL,
    MAXIMO_LANCE DECIMAL (4,1),
    PUBLICO_ALVO INT,
    FOREIGN KEY (PUBLICO_ALVO) REFERENCES PUBLICO (ID_PUBLICO)
    );

CREATE TABLE PUBLICO (
	ID_PUBLICO INT auto_increment PRIMARY KEY NOT NULL UNIQUE,
    FAIXA_ETARIA int,
    GENERO int,
    CONSUMO int,
    foreign key (faixa_etaria) references faixa_etaria(id),
    foreign key (genero) references genero_campanha (id),
    foreign key (consumo) references consumo (id)
    );
    
alter table publico
	add column renda_media decimal (10,2);
    
    /*drop table publico;*/
    
CREATE TABLE INTERESSE (
	ID_INTERESSE INT PRIMARY KEY auto_increment NOT NULL UNIQUE,
    DESCRICAO VARCHAR (100),
    publico_interesse int,
    foreign key (publico_interesse) references publico (id_publico)
    );
    
create table canais_distribuicao(
	ID_canais int auto_increment primary key not null unique,
    Campanha int,
    publico int,
    localizacao int,
    Nome_canal varchar (100) not null,
    descricao varchar (100) not null,
    tipo_canal int,
    foreign key(campanha) references campanhas (id_campanha),
    foreign key (publico) references publico (id_publico),
    foreign key (localizacao) references localizacao (id_localizacao),
    foreign key (tipo_canal) references tipo_canal (id)
);

create table produto_anuncio(
	ID int primary key auto_increment not null unique,
    campanha int,
    publico int, 
    localizacao int, 
    canais int,
    descricao varchar (500),
    marca varchar (50) not null,
    quantidade_anunciada int not null,
    foreign key (campanha) references campanhas (id_campanha),
    foreign key (publico) references publico (id_publico),
    foreign key (localizacao) references localizacao (id_localizacao),
    foreign key (canais) references canais_distribuicao (id_canais)
    );

/*drop table produto_anuncio;*/

alter table produto_anuncio 
add column produto int;

alter table produto_anuncio 
add foreign key (produto) references jogos (id_jogo);

INSERT INTO tipo_canal (descricao) VALUES
('Redes Sociais'),            
('Publicidade Digital'),      
('Email Marketing'),          
('Mensagens Instantâneas'),  
('Mensagens de Texto');      

INSERT INTO faixa_etaria (faixa) VALUES
('18-24'),
('25-34'),
('35-44'),
('45-54'),
('55-64'),
('65+'),
('Menores de 18'),
('65-74'),
('75-84'),
('85+');

INSERT INTO genero_campanha (tipo) VALUES
('Masculino'),
('Feminino'),
('Outro');

INSERT INTO canais_distribuicao (nome_canal, descricao)
VALUES
  ('Instagram', 'Canal de comunicação visual para promoção de produtos de Natal.'),
  ('Facebook', 'Promoção exclusiva para seguidores do Facebook durante o mês de Dezembro.'),
  ('Google Ads', 'Campanha de anúncios direcionados sobre o lançamento do Produto A.'),
  ('Email Marketing', 'Envio de email com ofertas especiais do lançamento do Produto A.'),
  ('WhatsApp', 'Interação direta com clientes sobre promoções de roupas de verão.'),
  ('TikTok', 'Campanha com influenciadores para divulgar as promoções de verão.'),
  ('Instagram Stories', 'Promoção do aniversário da loja com conteúdo interativo.'),
  ('Pinterest', 'Campanha de presentes para o Dia das Mães com imagens inspiradoras.'),
  ('Google Display', 'Anúncios de banners sobre presentes para o Dia das Mães.'),
  ('LinkedIn', 'Campanha voltada para profissionais que compram roupas de outono.'),
  ('YouTube', 'Anúncios em vídeo durante o Black Friday para promover descontos de até 70%.'),
  ('SMS', 'Notificação via SMS sobre as ofertas de Black Friday.'),
  ('WhatsApp', 'Promoção de pacotes de viagens durante as férias com desconto exclusivo.');

INSERT INTO Campanhas (NOME_CAMPANHA, DESCRICAO_CAMPANHA, DATA_INICIO, DATA_TERMINO, VALOR_INVESTIDO, MAXIMO_LANCE, PUBLICO_ALVO)
VALUES 
('Promoção Rockstar 2025', 'Campanha de promoção da Rockstar para o lançamento do novo jogo.', '2025-01-01', '2025-03-01', 50000.00, 99.9, NULL),
('Rockstar VIP', 'Campanha voltada para clientes VIP da Rockstar com prêmios exclusivos.', '2025-02-01', '2025-05-01', 100000.00, 150.0, NULL),
('Rockstar Summer Sale', 'Descontos exclusivos para os jogos da Rockstar durante o verão.', '2025-06-01', '2025-06-30', 25000.00, 49.9, NULL),
('Rockstar Black Friday', 'Descontos especiais para jogos e conteúdo da Rockstar durante a Black Friday.', '2025-11-01', '2025-11-30', 75000.00, 120.5, NULL),
('Rockstar Charity', 'Campanha de arrecadação para projetos de caridade apoiados pela Rockstar.', '2025-04-01', '2025-04-30', 20000.00, 80.0, NULL),
('Rockstar Fan Event', 'Evento exclusivo para fãs da Rockstar com sorteios e promoções.', '2025-05-01', '2025-05-10', 30000.00, 110.0, NULL),
('Rockstar Rewards', 'Programa de recompensas para compras realizadas na loja da Rockstar.', '2025-07-01', '2025-12-31', 45000.00, 60.0, NULL),
('Rockstar Pre-Order', 'Promoção para quem fizer a pré-venda do novo título da Rockstar.', '2025-08-01', '2025-09-01', 60000.00, 95.0, NULL),
('Rockstar Winter Sale', 'Descontos de inverno para os jogos e DLCs da Rockstar.', '2025-12-01', '2025-12-15', 35000.00, 70.0, NULL),
('Rockstar Esports', 'Promoção para torneios de esportes patrocinados pela Rockstar.', '2025-10-01', '2025-10-15', 50000.00, 85.0, NULL),
('Rockstar Anniversary', 'Campanha de comemoração do aniversário da Rockstar.', '2025-09-01', '2025-09-30', 80000.00, 130.0, NULL),
('Rockstar Fan Art Contest', 'Competição de fan art com prêmios exclusivos para os vencedores.', '2025-03-01', '2025-03-15', 15000.00, 50.0, NULL),
('Rockstar Special Edition', 'Promoção para edição especial de jogos da Rockstar.', '2025-07-15', '2025-08-15', 70000.00, 160.0, NULL),
('Rockstar Movie Night', 'Exibição de filmes relacionados aos jogos da Rockstar, com prêmios no final.', '2025-06-15', '2025-06-20', 20000.00, 90.0, NULL),
('Rockstar Social Media Challenge', 'Desafio nas redes sociais com prêmios para quem criar o melhor conteúdo sobre os jogos da Rockstar.', '2025-02-01', '2025-02-28', 25000.00, 75.0, NULL);

delete from Campanhas where id_campanha = 15;

INSERT INTO Localizacao (cidade, pais) VALUES
('Nova York', 'EUA'),
('Londres', 'UK'),
('Tóquio', 'JP'),
('Paris', 'FR'),
('Berlim', 'DE'),
('Sydney', 'AU'),
('Toronto', 'CA'),
('Cidade do Cabo', 'ZA'),
('Buenos Aires', 'AR'),
('São Paulo', 'BR'),
('Cidade do México', 'MX'),
('Xangai', 'CN'),
('Mumbai', 'IN'),
('Moscou', 'RU'),
('Roma', 'IT'),
('Seul', 'KR'),
('Bangkok', 'TH'),
('Istambul', 'TR'),
('Dubai', 'AE'),
('Los Angeles', 'EUA');

INSERT INTO Publico (renda_media) VALUES
(2000.00),
(2500.00),
(3000.00),
(2200.00),
(2700.00),
(3500.00),
(3200.00),
(2100.00),
(2600.00),
(3100.00),
(2800.00),
(2300.00),
(3300.00),
(3400.00);

INSERT INTO Interesse (descricao) VALUES
('GTA V'),
('Red Dead Redemption 2'),
('GTA Online'),
('Bully'),
('L.A. Noire'),
('Max Payne 3'),
('Table Tennis'),
('Midnight Club'),
('GTA: San Andreas'),
('GTA: Vice City'),
('Mods de GTA'),
('Roleplay'),
('Speedrun'),
('Colecionismo'),
('Cosplay'),
('Eventos Online'),
('Conteúdo de YouTube'),
('Streaming na Twitch'),
('Comunidade Discord'),
('Reviews e Notícias');
 
INSERT INTO produto_anuncio (descricao, marca, quantidade_anunciada)
VALUES
('Jogo de ação em mundo aberto ambientado na fictícia cidade de Los Santos, com missões e atividades diversas.', 'Rockstar Games', 500),
('Jogo de aventura e mundo aberto ambientado no Velho Oeste, com uma narrativa envolvente e gráficos impressionantes.', 'Rockstar Games', 350),
('Jogo de tiro em terceira pessoa com uma história profunda e mecânica de ação intensa, ambientado em São Paulo.', 'Rockstar Games', 200),
('Jogo de investigação ambientado nos anos 40, onde o jogador assume o papel de um detetive de homicídios em Los Angeles.', 'Rockstar Games', 150),
('Jogo de ação e aventura onde o jogador é um estudante em uma escola secundária e precisa enfrentar diferentes desafios.', 'Rockstar Games', 250),
('Aventura em mundo aberto, onde o jogador assume o papel de Niko Bellic, um imigrante que busca o sonho americano em Liberty City.', 'Rockstar Games', 400),
('Jogo de ação em mundo aberto onde o jogador explora a fictícia cidade de San Andreas e realiza diversas missões.', 'Rockstar Games', 600),
('Jogo de ação no Velho Oeste, onde o jogador controla John Marston em sua missão de caçar antigos companheiros de crime.', 'Rockstar Games', 350),
('Continuação de Max Payne, com mais ação intensa e uma história psicológica ainda mais complexa.', 'Rockstar Games', 180),
('Jogo de ação e aventura ambientado nos anos 80, onde o jogador explora a cidade de Vice City e enfrenta atividades criminosas.', 'Rockstar Games', 450),
('Modo multiplayer online de Red Dead Redemption 2, com missões, batalhas e atividades em grupo no Velho Oeste.', 'Rockstar Games', 500),
('Versão remasterizada de L.A. Noire com gráficos aprimorados e novos conteúdos para os jogadores.', 'Rockstar Games', 300),
('Versão expandida de Bully com novos desafios e missões para os jogadores que querem reviver a experiência escolar.', 'Rockstar Games', 220),
('Edição de luxo do GTA V, incluindo todos os DLCs e conteúdo extra para uma experiência completa.', 'Rockstar Games', 550),
('O clássico jogo de ação que introduziu a série GTA em 3D, com missões em uma cidade aberta cheia de atividades.', 'Rockstar Games', 500);


SELECT * FROM campanhas;
select * from localização;
select * from publico;
select * from interesse;

/* Area de Vendas*/

create table CLIENTES (
ID_CLIENTE INT NOT NULL UNIQUE auto_increment primary key,
NOME VARCHAR (50),
TIPO_DOCUMENTO VARCHAR (20),
NUMERO_DOCUMENTO VARCHAR (30),
TELEFONE_CONTATO VARCHAR (11),
EMAIL varchar (260),
CODIGO_POSTAL VARCHAR (20)
);

INSERT INTO CLIENTES (NOME, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, EMAIL, CODIGO_POSTAL)
VALUES
('Lucas Silva', 'RG', '123456789-SP', 'lucas@gmail.com', '01001-000'),
('Maria Oliveira', 'RG', '987654321-RJ', 'maria@gmail.com', '20040-002'),
('John Smith', 'Passaporte', 'A1234567', 'john@example.com', '10001'),
('Emma Johnson', 'Passaporte', 'UK9876543', 'emma@example.com', 'WC2N 5DU'),
('Akira Tanaka', 'Passaporte', 'JP0011223', 'akira@jpmail.jp', '160-0022'),
('Sophie Dubois', 'Passaporte', 'FR556677', 'sophie@frmail.fr', '75001'),
('Carlos Sánchez', 'Passaporte', 'MX998877', 'carlos@mxmail.mx', '06000'),
('Liam Brown', 'SSN', '123-45-6789', 'liam@usmail.com', '30301'),
('Laura Müller', 'Passaporte', 'DE7891234', 'laura@demail.de', '10115'),
('Zhang Wei', 'ID Nacional', 'CN102938', 'zhang@cnmail.cn', '200000'),
('Giulia Rossi', 'Passaporte', 'IT2233445', 'giulia@itmail.it', '00184'),
('Robert Thompson', 'SSN', '555-66-7777', 'robert@usmail.com', '94105'),
('Ananya Gupta', 'Aadhar', 'IN9988776655', 'ananya@inmail.in', '110001'),
('Chen Liu', 'ID Nacional', 'CN445566', 'chen@cnmail.cn', '510000'),
('Isabella Martínez', 'Passaporte', 'CO12349876', 'isabella@colmail.co', '110111'),
('André Dupont', 'Passaporte', 'FR9988776', 'andre@frmail.fr', '69001'),
('Mateo Fernández', 'DNI', 'AR45612378', 'mateo@arcor.com', 'C1043AAB'),
('Helena Costa', 'RG', '1122334455-SP', 'helena@gmail.com', '04094-050'),
('Noah Wilson', 'SSN', '222-33-4444', 'noah@usmail.com', '90001'),
('Amélie Laurent', 'Passaporte', 'FR1122334', 'amelie@frmail.fr', '13001');

CREATE TABLE PAGAMENTO (
	ID_PAGAMENTO INT auto_increment NOT NULL PRIMARY KEY,
    JOGOS_ID INT,
    UNIDADES_COMPRADAS INT,
    VALOR_PEDIDO DECIMAL (10,2),
    DESCONTOS DECIMAL (5,2),
    VALOR DECIMAL (10,2),
    FORMA_PAGAMENTO ENUM ('CARTÃO', 'BOLETO', 'TRANSFERÊNCIA'),
    DATA_PAGAMENTO DATE,
    STATUS_PAGAMENTO ENUM ('PENDENTE', 'APROVADO', 'CANCELADO'),
    FOREIGN KEY (JOGOS_ID) REFERENCES JOGOS (ID_JOGO)
    );
    
    INSERT INTO PAGAMENTO (
  UNIDADES_COMPRADAS, VALOR_PEDIDO, DESCONTOS, VALOR, FORMA_PAGAMENTO, DATA_PAGAMENTO, STATUS_PAGAMENTO
)
VALUES
  (2, 200.00, 10.00, 190.00, 'CARTÃO',        '2025-04-01', 'APROVADO'),
  (1, 120.00,  0.00, 120.00, 'BOLETO',        '2025-04-02', 'PENDENTE'),
  (3, 300.00, 30.00, 270.00, 'TRANSFERÊNCIA', '2025-04-03', 'CANCELADO'),
  (1, 100.00,  5.00,  95.00, 'CARTÃO',        '2025-04-04', 'APROVADO'),
  (2, 250.00, 25.00, 225.00, 'BOLETO',        '2025-04-05', 'APROVADO'),
  (1, 150.00,  0.00, 150.00, 'TRANSFERÊNCIA', '2025-04-06', 'PENDENTE'),
  (4, 400.00, 50.00, 350.00, 'CARTÃO',        '2025-04-07', 'CANCELADO'),
  (1,  90.00,  5.00,  85.00, 'BOLETO',        '2025-04-08', 'APROVADO'),
  (2, 220.00, 20.00, 200.00, 'TRANSFERÊNCIA', '2025-04-09', 'APROVADO'),
  (1, 130.00, 10.00, 120.00, 'CARTÃO',        '2025-04-10', 'PENDENTE'),
  (3, 300.00, 15.00, 285.00, 'BOLETO',        '2025-04-11', 'APROVADO'),
  (2, 240.00,  0.00, 240.00, 'TRANSFERÊNCIA', '2025-04-12', 'CANCELADO'),
  (1, 110.00,  5.00, 105.00, 'CARTÃO',        '2025-04-13', 'APROVADO'),
  (5, 500.00, 50.00, 450.00, 'BOLETO',        '2025-04-14', 'PENDENTE'),
  (2, 260.00, 20.00, 240.00, 'TRANSFERÊNCIA', '2025-04-15', 'APROVADO'),
  (1, 180.00, 10.00, 170.00, 'CARTÃO',        '2025-04-16', 'APROVADO'),
  (3, 330.00, 15.00, 315.00, 'TRANSFERÊNCIA', '2025-04-17', 'CANCELADO'),
  (2, 180.00,  5.00, 175.00, 'BOLETO',        '2025-04-18', 'PENDENTE'),
  (1,  95.00,  0.00,  95.00, 'CARTÃO',        '2025-04-19', 'APROVADO'),
  (4, 520.00, 40.00, 480.00, 'TRANSFERÊNCIA', '2025-04-20', 'APROVADO');


SELECT * FROM PAGAMENTO;

CREATE TABLE VENDAS_DIGITAIS(
	ID_VENDA_DIGITAL INT auto_increment PRIMARY KEY NOT NULL UNIQUE,
    DATA_VENDA date,
    JOGO INT,
    PLATAFORMA INT,
    UNIDADES INT,
    LOCALIZACAO INT,
    VALOR_BRUTO DECIMAL (10,2),
    VALOR_DESCONTO DECIMAL (5,2),
    VALOR_TOTAL DECIMAL (10,2),
    CLIENTE INT,
    PAGAMENTO INT,
    
    foreign key (JOGO) REFERENCES JOGOS (ID_JOGO),
    foreign key (PLATAFORMA) REFERENCES PLATAFORMAS (ID_PLATAFORMA),
    foreign key (LOCALIZACAO) REFERENCES LOCALIZACAO (ID_LOCALIZACAO),
    foreign key (CLIENTE) REFERENCES CLIENTES (ID_CLIENTE),
    foreign key (PAGAMENTO) REFERENCES PAGAMENTO (ID_PAGAMENTO)
    );
    
    /*drop table vendas_digitais;*/
    
   INSERT INTO vendas_digitais (data_venda, unidades, valor_bruto, valor_desconto, valor_total)
VALUES
('2025-04-01', 1, 200.00, 10.00, 190.00),
('2025-04-02', 2, 120.00, 0.00, 120.00),
('2025-04-03', 3, 300.00, 30.00, 270.00),
('2025-04-04', 4, 100.00, 5.00, 95.00),
('2025-04-05', 5, 250.00, 25.00, 225.00),
('2025-04-06', 6, 150.00, 0.00, 150.00),
('2025-04-07', 7, 400.00, 50.00, 350.00),
('2025-04-08', 8, 90.00, 5.00, 85.00),
('2025-04-09', 9, 220.00, 20.00, 200.00),
('2025-04-10', 10, 130.00, 10.00, 120.00),
('2025-04-11', 1, 300.00, 15.00, 285.00),
('2025-04-12', 2, 240.00, 0.00, 240.00),
('2025-04-13', 3, 110.00, 5.00, 105.00),
('2025-04-14', 4, 500.00, 50.00, 450.00),
('2025-04-15', 5, 260.00, 20.00, 240.00),
('2025-04-16', 6, 180.00, 10.00, 170.00),
('2025-04-17', 7, 330.00, 15.00, 315.00),
('2025-04-18', 8, 180.00, 5.00, 175.00),
('2025-04-19', 9, 95.00, 0.00, 95.00),
('2025-04-20', 10, 520.00, 40.00, 480.00);


SELECT * FROM VENDAS_DIGITAIS;

CREATE TABLE HISTORICO_MICROTRANSACOES(
	ID_HISTORICO INT auto_increment UNIQUE PRIMARY KEY,
    JOGO INT, 
    PAGAMENTO INT,
    TIPO_ITEM VARCHAR (110),
    VALOR DECIMAL (10,2),
   MOEDA_UTILIZADA ENUM('ROCKSTAR COINS', 'GTA COINS', 'RDR COINS', 'GTAV COINS'),
    DATA_TRANSACAO timestamp default current_timestamp,
    STATUS_TRANSACAO ENUM ('PAGA', 'PENDENTE', 'CANCELADA', 'REEMBOLSADA', ' EM PROCESSAMENTO'),
    foreign key (JOGO) REFERENCES JOGOS (ID_JOGO),
    foreign key (PAGAMENTO) REFERENCES PAGAMENTO (ID_PAGAMENTO)
    );

/*drop table historico_microtransacoes;*/

INSERT INTO HISTORICO_MICROTRANSACOES (TIPO_ITEM, VALOR, MOEDA_UTILIZADA, STATUS_TRANSACAO) 
VALUES 
('Skin exclusiva', 50.00, 'ROCKSTAR COINS', 'PAGA'),
('Passe de temporada', 100.00, 'GTA COINS', 'PENDENTE'),
('Pacote de armas', 25.00, 'RDR COINS', 'PAGA'),
('Conteúdo extra', 20.00, 'GTAV COINS', 'CANCELADA'),
('Vantagem no jogo', 10.00, 'ROCKSTAR COINS', 'PAGA'),
('Item cosmético', 15.00, 'RDR COINS', 'PENDENTE'),
('Aprimoramento de personagem', 40.00, 'GTA COINS', 'PAGA'),
('Arma lendária', 75.00, 'GTAV COINS', 'PENDENTE'),
('Passe de batalha', 120.00, 'RDR COINS', 'CANCELADA'),
('Skin rara', 30.00, 'ROCKSTAR COINS', 'PAGA'),
('Munição premium', 5.00, 'GTA COINS', 'PENDENTE'),
('Pacote de personalização', 60.00, 'GTAV COINS', 'PAGA'),
('Assinatura premium', 150.00, 'ROCKSTAR COINS', 'PAGA'),
('Novo veículo', 200.00, 'RDR COINS', 'PENDENTE'),
('XP Boost', 25.00, 'GTA COINS', 'CANCELADA'),
('Expansão de mapa', 50.00, 'GTAV COINS', 'PAGA'),
('Armadura especial', 40.00, 'ROCKSTAR COINS', 'PENDENTE'),
('Pacote de skins', 90.00, 'RDR COINS', 'CANCELADA'),
('Acessórios exclusivos', 15.00, 'GTA COINS', 'PAGA'),
('Upgrade de arma', 60.00, 'GTAV COINS', 'PENDENTE');

delete from historico_microtransacoes where id_historico = 7;
delete from historico_microtransacoes where id_historico = 12;
delete from historico_microtransacoes where id_historico = 19;


SELECT * FROM HISTORICO_MICROTRANSACOES;

/* ÁREA FUNCIONARIOS*/

CREATE TABLE CARGOS (
	ID_CARGO INT auto_increment PRIMARY KEY NOT NULL UNIQUE,
    NOME_CARGO VARCHAR (100) NOT NULL
    );
CREATE TABLE DEPARTAMENTOS (
	ID_DEPARTAMENTO INT auto_increment NOT NULL UNIQUE primary KEY,
    NOME_DEPARTAMENTO VARCHAR (100)
    );
CREATE TABLE FUNCIONARIOS(
	ID_FUNCIONARIO INT NOT NULL UNIQUE primary KEY auto_increment,
    NOME_FUNCIONARIO VARCHAR (100) NOT NULL,
    DATA_NASCIMENTO DATE NOT NULL,
    TELEFONE VARCHAR (100),
    EMAIL VARCHAR (100),
    PAIS VARCHAR (100),
    ADMISSAO DATE NOT NULL,
    CARGO INT,
    DEPARTAMENTO INT,
    foreign key (CARGO) references CARGOS (ID_CARGO),
    foreign key (DEPARTAMENTO) references DEPARTAMENTOS (ID_DEPARTAMENTO)
    );
    
CREATE TABLE SALARIOS (
	ID_SALARIO INT NOT NULL UNIQUE auto_increment PRIMARY KEY,
    FUNCIONARIO INT,
    CARGO INT,
    SALARIO DECIMAL (10,2) NOT NULL,
    BONUS DECIMAL (10,2),
    INCIO DATE NOT NULL,
    FIM DATE,
    foreign key (FUNCIONARIO) references FUNCIONARIOS (ID_FUNCIONARIO),
    foreign key (CARGO) REFERENCES CARGOS (ID_CARGO)
    );
    

    /*select inicio from salarios;*/
    
   /* DROP TABLE SALARIOS;*/

INSERT INTO CARGOS (NOME_CARGO) VALUES 
('Desenvolvedor'),
('Designer'),
('Gerente de Produto'),
('Analista de Marketing'),
('Especialista em Vendas'),
('Gestor de Projetos'),
('Assistente Administrativo');

INSERT INTO DEPARTAMENTOS (NOME_DEPARTAMENTO) VALUES 
('Desenvolvimento de Jogos'),
('Design Gráfico'),
('Marketing e Comunicação'),
('Vendas e Distribuição'),
('Recursos Humanos'),
('Suporte Técnico'),
('Financeiro');


INSERT INTO FUNCIONARIOS (NOME_FUNCIONARIO, DATA_NASCIMENTO, TELEFONE, EMAIL, ADMISSAO, CARGO, DEPARTAMENTO, PAIS) VALUES
('Lucas Silva', '1990-03-15', '11999998888', 'lucas@rockstar.com', '2020-05-10', 1, 1, 'Brasil'),
('Maria Oliveira', '1985-07-22', '21988887777', 'maria@rockstar.com', '2019-04-25', 2, 2, 'Brasil'),
('João Pereira', '1992-11-01', '3197776655', 'joao@rockstar.com', '2021-01-18', 3, 3, 'Portugal'),
('Ana Costa', '1988-02-20', '4195554433', 'ana@rockstar.com', '2018-06-30', 4, 6, 'Espanha'),
('Carlos Santos', '1995-09-10', '5194443322', 'carlos@rockstar.com', '2022-09-15', 5, 7, 'Argentina'),
('Juliana Souza', '1990-12-03', '6193332211', 'juliana@rockstar.com', '2020-03-12', 6, 5, 'França'),
('Paulo Henrique', '1987-06-25', '7192221100', 'paulo@rockstar.com', '2017-08-09', 7, 4, 'Reino Unido'),
('Elena Martinez', '1993-05-14', '6398887766', 'elena@rockstar.com', '2020-07-05', 1, 3, 'México'),
('Marco Rossi', '1984-10-11', '6395553344', 'marco@rockstar.com', '2019-11-17', 2, 2, 'Itália'),
('Sophie Dubois', '1986-03-18', '4933332211', 'sophie@rockstar.com', '2018-01-15', 3, 6, 'França'),
('Alexandre Almeida', '1991-07-09', '8497776655', 'alexandre@rockstar.com', '2021-04-20', 4, 4, 'Brasil'),
('David Green', '1989-01-23', '4434445566', 'david@rockstar.com', '2019-02-11', 5, 5, 'EUA'),
('Nina Rodrigues', '1997-11-28', '6198887766', 'nina@rockstar.com', '2021-09-09', 6, 3, 'Brasil'),
('Marcelo Oliveira', '1980-12-01', '8196665444', 'marcelo@rockstar.com', '2015-04-25', 7, 4, 'Portugal'),
('Tomás Gómez', '1983-03-12', '6445554433', 'tomas@rockstar.com', '2016-06-30', 1, 1, 'Espanha'),
('Haruto Takahashi', '1994-09-08', '8197778877', 'haruto@rockstar.com', '2020-01-10', 2, 5, 'Japão'),
('Luca Ferraro', '1991-04-14', '6398889922', 'luca@rockstar.com', '2020-05-18', 3, 7, 'Itália'),
('Kristen Wright', '1985-05-22', '4423332211', 'kristen@rockstar.com', '2017-08-15', 4, 3, 'Reino Unido'),
('Fernando Pérez', '1992-08-30', '6634442211', 'fernando@rockstar.com', '2019-09-11', 5, 2, 'Colômbia'),
('Karla Jensen', '1989-12-15', '4632211100', 'karla@rockstar.com', '2021-02-23', 6, 6, 'Dinamarca'),
('Johnathan Lee', '1987-11-18', '8398886555', 'johnathan@rockstar.com', '2018-10-08', 7, 1, 'EUA');

-- Inserts para a tabela SALARIO
INSERT INTO SALARIOS (SALARIO, BONUS, INCIO, FIM, CARGO) VALUES
(7000.00, 500.00, '2020-05-10', NULL, 1),
(7500.00, 700.00, '2019-04-25', '2023-12-31', 2),
(8000.00, 800.00, '2021-01-18', NULL, 3),
(6500.00, 300.00, '2018-06-30', '2022-11-30', 4),
(9000.00, 1000.00, '2022-09-15', NULL, 5),
(7100.00, 450.00, '2020-03-12', NULL, 6),
(7800.00, 650.00, '2017-08-09', '2023-07-01', 7),
(6700.00, 400.00, '2020-07-05', NULL, 1),
(7300.00, 600.00, '2019-11-17', NULL, 2),
(6900.00, 350.00, '2018-01-15', '2021-09-30', 3),
(8200.00, 900.00, '2021-04-20', NULL, 4),
(9200.00, 1200.00, '2019-02-11', NULL, 5),
(7100.00, 500.00, '2021-09-09', NULL, 6),
(8500.00, 1100.00, '2015-04-25', '2022-06-30', 7),
(6900.00, 400.00, '2016-06-30', '2020-12-31', 1),
(8900.00, 950.00, '2020-01-10', NULL, 2),
(8700.00, 850.00, '2020-05-18', NULL, 3),
(7500.00, 650.00, '2017-08-15', '2021-08-31', 4),
(9400.00, 1300.00, '2019-09-11', NULL, 5),
(7600.00, 700.00, '2021-02-23', NULL, 6),
(8100.00, 600.00, '2022-03-12', NULL, 7);


SELECT ID_FUNCIONARIO FROM FUNCIONARIOS;





    










    
