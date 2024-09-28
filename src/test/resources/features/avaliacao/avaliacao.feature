# language: pt

Funcionalidade: Avaliação
  Cenario: Cadastrar avaliação
    Dado que um restaurante já está cadastrado
    E o usuário já está cadastrado
    Quando enviar uma avaliação para um Restaurante
    Então a avaliação é registrada com sucesso
    E deve ser apresentada

  Cenario: Buscar avaliação por Restaurante
    Dado que um restaurante já está cadastrado
    E o usuário já está cadastrado
    Quando efetuar a busca de avaliação de restaurante
    Então o restaurante e a avaliação são exibidos

  Cenario: Alterar avaliação
    Dado que um restaurante já está cadastrado
    E o usuário já está cadastrado
    Então efeturar a requisição para atualizar a avaliação
    Então a avaliação é atualizada com sucesso
    E deve ser apresentada

  Cenario: Remover avaliação
    Dado que um restaurante já está cadastrado
    E o usuário já está cadastrado
    Quando requisitar a remoção da avaliação
    Então a avaliação é removida com sucesso