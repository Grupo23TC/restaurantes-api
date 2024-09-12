INSERT INTO Endereco (rua, logradouro, numero, complemento, bairro, cidade, cep, estado, uf)
VALUES ('rua teste', 'logradouro teste', 10, 'apto 1', 'bairro teste', 'cidade teste', '00000-000', 'estado teste', 'IT'),
        ('rua teste 2', 'logradouro teste 2', 10, 'apto 2', 'bairro teste 2', 'cidade teste 2', '20000-000', 'estado teste 2', 'IT'),
        ('rua teste 3', 'logradouro teste 3', 10, 'apto 3', 'bairro teste 3', 'cidade teste 3', '30000-000', 'estado teste 3', 'IT');
INSERT INTO Restaurante (nome, endereco_Id, tipo_De_Cozinha, capacidade, horario_Funcionamento)
VALUES ('restaurante teste', 1, 'MEXICANA', 150, '12h às 23h'),
        ('restaurante teste 2', 2, 'MEXICANA', 150, '12h às 23h'),
        ('restaurante teste 3', 3, 'JAPONESA', 150, '12h às 23h');

INSERT INTO Usuario (nome, email, senha, telefone)
VALUES ('usuario teste', 'teste@email.com','senha123','99999-9999'),
        ('usuario teste 2', 'teste2@email.com','senha123','99999-9999');

INSERT INTO Avaliacao (restaurante_Id, usuario_Id, nota, comentario, data_avaliacao)
VALUES (1, 1, 5, 'Muito boa a comida!', '2024-09-10T11:47:37.912019300'),
        (2, 1, 1, 'Terrível a comida!', '2024-09-10T11:47:37.912019300'),
        (1, 2, 4, 'Atendimento top!', '2024-09-10T11:47:37.912019300'),
        (2, 2, 3, 'Mais ou menos', '2024-09-10T11:47:37.912019300');
