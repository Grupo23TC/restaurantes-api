# language: pt

Funcionalidade: Reserva
  Cenario: Cadastrar reserva
    Dado que o Usuário já está cadastrado
    Quando cadastrar uma reserva para o restaurante
    Então a reserva é registrada com sucesso
    E deve ser apresentada

  Cenario: Buscar reserva
    Dado que a reserva já está cadastrada
    Quando efetuar a busca da reserva
    Então as reserva é exibida

  Cenario: Alterar reserva
    Dado que a reserva já está cadastrada
    Então efeturar a requisição para atualizar a reserva
    Então a reserva é atualizada com sucesso
    E deve ser apresentada

  Cenario: Remover reserva
    Dado que uma reserva já está cadastrada
    Quando requisitar a remoção da reserva
    Então a reserva é removida com sucesso