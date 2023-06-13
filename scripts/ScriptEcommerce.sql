CREATE TABLE public.categoria (
	cod_categoria serial4 NOT NULL,
	nome varchar NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (cod_categoria)
);
CREATE TABLE public.produto (
	cod_produto serial4 NOT NULL,
	nome varchar NOT NULL,
	valor numeric NOT NULL,
	quantidade int4 NULL,
	categoria int4 NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (cod_produto),
	CONSTRAINT produto_fk FOREIGN KEY (categoria) REFERENCES public.categoria(cod_categoria)
);

CREATE TABLE public.cidade (
	cod_cidade serial4 NOT NULL,
	nome varchar NOT NULL,
	uf varchar NOT NULL,
	CONSTRAINT cidade_pk PRIMARY KEY (cod_cidade)
);
CREATE TABLE public.endereco (
	cod_endereco serial4 NOT NULL,
	rua varchar NOT NULL,
	bairro varchar NOT NULL,
	cidade int4 NOT NULL,
	CONSTRAINT endereco_pk PRIMARY KEY (cod_endereco),
	CONSTRAINT endereco_fk FOREIGN KEY (cidade) REFERENCES public.cidade(cod_cidade)
);
CREATE TABLE public.cliente (
	cod_cliente serial4 NOT NULL,
	nome varchar NOT NULL,
	sexo varchar NOT NULL,
	data_nascimento date NOT NULL,
	endereco int4 NOT NULL,
	CONSTRAINT cliente_pk PRIMARY KEY (cod_cliente),
	CONSTRAINT cliente_fk FOREIGN KEY (endereco) REFERENCES public.endereco(cod_endereco)
);
CREATE TABLE public.telefone (
	cod_telefone serial4 NOT NULL,
	numero varchar NOT NULL,
	cliente int4 NOT NULL,
	CONSTRAINT telefone_pk PRIMARY KEY (cod_telefone),
	CONSTRAINT telefone_fk FOREIGN KEY (cliente) REFERENCES public.cliente(cod_cliente)
);
CREATE TABLE public.venda (
	cod_venda serial4 NOT NULL,
	data_venda date NOT NULL,
	cliente int4 NOT NULL,
	CONSTRAINT venda_pk PRIMARY KEY (cod_venda),
	CONSTRAINT venda_fk FOREIGN KEY (cliente) REFERENCES public.cliente(cod_cliente)
);

CREATE TABLE public.detalhes_venda (
	cod_detalhes serial4 NOT NULL,
	venda int4 NOT NULL,
	produto int4 NOT NULL,
	quantidade int4 NOT NULL,
	CONSTRAINT detalhes_venda_pk PRIMARY KEY (cod_detalhes),
	CONSTRAINT detalhes_venda_fk FOREIGN KEY (venda) REFERENCES public.venda(cod_venda),
	CONSTRAINT detalhes_venda_fk_1 FOREIGN KEY (produto) REFERENCES public.produto(cod_produto)
);

--A tabela de categorias deve possuir 10 registros
insert into categoria (nome) values ('Móveis');
insert into categoria (nome) values ('Ferramentas');
insert into categoria (nome) values ('Jardinagem');
insert into categoria (nome) values ('Eletrônicos');
insert into categoria (nome) values ('Vestuário');
insert into categoria (nome) values ('Livros');
insert into categoria (nome) values ('Esportes');
insert into categoria (nome) values ('Alimentos');
insert into categoria (nome) values ('Automóveis');
insert into categoria (nome) values ('Escolar');

--A tabela de produtos deve possuir 6 produtos
insert into produto (nome,valor,quantidade, categoria)
values ('Cadeira','100','20',1);
insert into produto (nome,valor,quantidade, categoria)
values ('Mesa','300','10',1);
insert into produto (nome,valor,quantidade, categoria)
values ('Martelo','30','50',2);
insert into produto (nome,valor,quantidade, categoria)
values ('Caneta','3','200',10);
insert into produto (nome,valor,quantidade, categoria)
values ('Fone de ouvido','50','60',4);
insert into produto (nome,valor,quantidade, categoria)
values ('Camiseta','30','100',5);
insert into cidade (nome, uf) 
values ('Tubarão','SC');
insert into cidade (nome, uf) 
values ('Torres','RS');
insert into cidade (nome, uf) 
values ('São Paulo','SP');
insert into cidade (nome, uf) 
values ('Rio de Janeiro','RJ');

insert into endereco (rua, bairro, cidade)
values('Rua A', 'Bairro Centro', 2);
insert into endereco (rua, bairro, cidade)
values('Rua B', 'Bairro Dehon', 1);
insert into endereco (rua, bairro, cidade)
values('Rua C', 'Bairro Centro', 3);
insert into endereco (rua, bairro, cidade)
values('Rua D', 'Bairro Copacabana', 4);

--A tabela de clientes deve possuir dois clientes.
insert into cliente (nome,sexo,data_nascimento, endereco)
values ('Gabriely Siqueira','F','18/07/2004', 2);
insert into cliente (nome,sexo,data_nascimento, endereco)
values ('Paulo Siqueira','M','09/06/1970', 4);

insert into telefone (numero,cliente)
values ('48987654321',1);
insert into telefone (numero,cliente)
values ('51912345678',2);

--simulação de diversas vendas para esses dois clientes.
insert into venda (data_venda, cliente)
values ('15/11/2022',1);
insert into venda (data_venda, cliente)
values ('05/01/2023',1);
insert into venda (data_venda, cliente)
values ('09/06/2023',1);
insert into venda (data_venda, cliente)
values ('02/04/2023',2);
insert into venda (data_venda, cliente)
values ('05/06/2023',2);

insert into detalhes_venda (venda, produto, quantidade)
values (1,5,1);
insert into detalhes_venda (venda, produto, quantidade)
values (2,4,5);
insert into detalhes_venda (venda, produto, quantidade)
values (3,7,3);
insert into detalhes_venda (venda, produto, quantidade)
values (4,2,1);
insert into detalhes_venda (venda, produto, quantidade)
values (5,7,5);

--listar clientes por cidade (utilizar qualquer cidade para testes)
select cliente.nome, cidade.nome
from cidade
inner join endereco on endereco.cidade = cidade.cod_cidade
inner join cliente on cliente.endereco = endereco.cod_endereco
where cidade.nome = 'Tubarão';

--listar vendas por cliente (utilizar qualquer cliente para teste)

select  cliente.nome, venda.data_venda 
from cliente 
inner join venda on venda.cliente = cliente.cod_cliente
where cliente.nome = 'Gabriely Siqueira';

--para listar todos os produtos e categorias
select p.nome, c.nome
FROM produto p
right join categoria c ON p.categoria = c.cod_categoria;

--Relatório de vendas por categoria:
select categoria.nome, sum(detalhes_venda.quantidade)as total_vendido
from Categoria
inner join produto on categoria.cod_categoria  = produto.categoria
inner join detalhes_venda on Produto.cod_produto = detalhes_venda.produto
group by categoria.nome;

--Relatório de vendas por cliente e valor total:
select cliente.nome, count(venda.cod_venda) as total_vendas,
sum(produto.valor) as valor_total
from cliente 
inner join venda on cliente.cod_cliente = venda.cliente
inner join detalhes_venda on venda.cod_venda = detalhes_venda.venda
inner join Produto on detalhes_venda.produto = produto.cod_produto 
group by cliente.nome;

--Relatório de produtos com estoque baixo:
select produto.nome, produto.quantidade
from produto 
where produto.quantidade < 20;




















