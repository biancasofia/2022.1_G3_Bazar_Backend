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
INSERT INTO estado (sigla, nome) VALUES ('GO', 'Goiás');

INSERT INTO cidade (nome, estado_id) VALUES ('Brasília', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Recanto das Emas', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Taguatinga', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Vicente Pires', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Gama', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Valraíso', 2);

INSERT INTO endereco (bairro, cep, numero, cidade_id, usuario_id) VALUES ('Quadra 400 conjunto 06', 78600400, 12, 1, 1);
INSERT INTO endereco (bairro, cep, numero, cidade_id, usuario_id) VALUES ('Quandra 600 conjunto 02', 72600400, 30, 1, 1);
INSERT INTO endereco (bairro, cep, numero, cidade_id, usuario_id) VALUES ('Quandra 600 conjunto 02', 72600400, 30, 1, 2);

INSERT INTO categoria (nome, icone) VALUES ('Informática', 'computer');
INSERT INTO categoria (nome, icone) VALUES ('Roupas', 'checkroom');
INSERT INTO categoria (nome, icone) VALUES ('Acessórios', 'headphones_battery');
INSERT INTO categoria (nome, icone) VALUES ('Eletrônicos', 'on_device_training');
