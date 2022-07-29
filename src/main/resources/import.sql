INSERT INTO papel (autoridade) VALUES ('ADMIN');
INSERT INTO papel (autoridade) VALUES ('CLIENTE');
INSERT INTO papel (autoridade) VALUES ('VENDEDOR');
INSERT INTO papel (autoridade) VALUES ('FORNECEDOR');

INSERT INTO usuario (nome, email, senha) VALUES ('douglas', 'douglas@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO usuario (nome, email, senha) VALUES ('gabriel', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (1, 1);
INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (2, 2);
INSERT INTO usuario_papeis (usuario_id, papel_id) VALUES (2, 3);

INSERT INTO cidade (nome) VALUES ('Brasília');
INSERT INTO cidade (nome) VALUES ('Recanto das Emas');