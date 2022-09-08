INSERT INTO papel (autoridade) VALUES ('ROLE_ADMIN');
INSERT INTO papel (autoridade) VALUES ('ROLE_CLIENTE');
INSERT INTO papel (autoridade) VALUES ('ROLE_VENDEDOR');
INSERT INTO papel (autoridade) VALUES ('ROLE_FORNECEDOR');

INSERT INTO usuario (nome, email, senha) VALUES ('douglas', 'douglas@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO usuario (nome, email, senha) VALUES ('gabriel', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (1, 1);
INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (2, 2);
INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (2, 3);

INSERT INTO estado (sigla, nome) VALUES ('DF', 'Distrito Federal');

INSERT INTO cidade (nome, estado_id) VALUES ('Brasília', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Recanto das Emas', 1);

INSERT INTO endereco (bairro, cep, numero, cidade_id, usuario_id) VALUES ('Recanto das Emas', 72600400, 12, 1, 1);

INSERT INTO categoria (nome, icone) VALUES ('Informática', 'computer');
INSERT INTO categoria (nome, icone) VALUES ('Roupas', 'checkroom');
INSERT INTO categoria (nome, icone) VALUES ('Acessórios', 'headphones_battery');

INSERT INTO produto (nome, preco) VALUES ('Xiaomi Redmi 11s', 1475.00);
INSERT INTO produto (nome, preco) VALUES ('Xiaomi POCO M3', 1350.00);
INSERT INTO produto (nome, preco) VALUES ('Pulseira de ouro', 10500.00);
INSERT INTO produto (nome, preco) VALUES ('Brincos', 10500.00);
INSERT INTO produto (nome, preco) VALUES ('Trevesseiro', 50.00);

INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (1, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (2, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (3, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (4, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (5, 3);
