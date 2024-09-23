INSERT INTO Endereco (rua, logradouro, numero, complemento, bairro, cidade, cep, estado, uf)
VALUES ('rua teste', 'logradouro teste', 10, 'apto 1', 'bairro teste', 'cidade teste', '00000-000', 'estado teste', 'IT'),
        ('rua teste 2', 'logradouro teste 2', 10, 'apto 2', 'bairro teste 2', 'cidade teste 2', '20000-000', 'estado teste 2', 'IT'),
        ('rua teste 3', 'logradouro teste 3', 10, 'apto 3', 'bairro teste 3', 'cidade teste 3', '30000-000', 'estado teste 3', 'IT');

INSERT INTO Restaurante (nome, endereco_Id, tipo_De_Cozinha, capacidade, horario_Funcionamento)
VALUES ('restaurante teste', 1, 'MEXICANA', 150, '12h às 23h'),
        ('restaurante teste 2', 2, 'MEXICANA', 150, '12h às 23h'),
        ('restaurante teste 3', 3, 'JAPONESA', 150, '12h às 23h');

INSERT INTO Usuario (nome, email, senha, telefone)
VALUES ('usuario teste', 'teste@email.com','Senha@90','99999-9999'),
       ('usuario teste 2', 'teste2@email.com','Senha@92','99999-9999'),
       ('Lucas Franco', 'lucas.franco@email.com', 'Senha@12', '11999999901'),
       ('João Silva', 'joao.silva@email.com', 'Senha@45', '11999999902'),
       ('Maria Souza', 'maria.souza@email.com', 'Senha@78', '11999999903'),
       ('Ana Costa', 'ana.costa@email.com', 'Senha@10', '11999999904'),
       ('Pedro Alves', 'pedro.alves@email.com', 'Senha@20', '11999999905'),
       ('Fernanda Lima', 'fernanda.lima@email.com', 'Senha@30', '11999999906'),
       ('Bruno Pereira', 'bruno.pereira@email.com', 'Senha@40', '11999999907'),
       ('Mariana Rocha', 'mariana.rocha@email.com', 'Senha@50', '11999999908'),
       ('Ricardo Mendes', 'ricardo.mendes@email.com', 'Senha@60', '11999999909'),
       ('Camila Dias', 'camila.dias@email.com', 'Senha@70', '11999999910');

INSERT INTO Avaliacao (restaurante_Id, usuario_Id, nota, comentario, data_avaliacao)
VALUES (1, 1, 5, 'Muito boa a comida!', '2024-09-10T11:47:37.912019300'),
       (2, 1, 1, 'Terrível a comida!', '2024-09-10T11:47:37.912019300'),
       (1, 2, 4, 'Atendimento top!', '2024-09-10T11:47:37.912019300'),
       (2, 2, 3, 'Mais ou menos', '2024-09-10T11:47:37.912019300');

INSERT INTO Mesa (restaurante_id, status, quantidade_Assentos)
VALUES (1, 'DISPONIVEL', 4),
        (1, 'DISPONIVEL', 4),
        (1, 'DISPONIVEL', 4),
        (1, 'DISPONIVEL', 4),
        (1, 'DISPONIVEL', 4),
        (2, 'DISPONIVEL', 4),
        (2, 'DISPONIVEL', 4),
        (2, 'DISPONIVEL', 4),
        (3, 'DISPONIVEL', 4),
        (3, 'DISPONIVEL', 4),
        (3, 'DISPONIVEL', 4);

