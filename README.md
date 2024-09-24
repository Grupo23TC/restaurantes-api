# Restaurantes API

### Proposta de projeto pós-graduação FIAP - Tech Challenge - fase 3

### Tópicos

- [Descrição do projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Ferramentas utilizadas](#ferramentas-utilizadas)
- [Acesso ao projeto](#acesso-ao-projeto)
- [Abrir e rodar o projeto](#abrir-e-rodar-o-projeto)
- [Desenvolvedores](#desenvolvedores)

## Descrição do projeto

<p align="justify">
Este projeto apresenta o desenvolvimento de um novo sistema de Restaurantes, com funcionalidades de cadastro de restaurantes, reserva de mesas, avaliações e comentários, busca de restaurantes e gerenciamento de reservas.
</p>

## Funcionalidades

`Funcionalidade 1:` Cadastro de Restaurantes

`Funcionalidade 2:` Reserva de Mesas

`Funcionalidade 3:` Avaliações e Comentários

`Funcionalidade 4:` Busca de Restaurantes

`Funcionalidade 5:` Gerenciamento de Reservas


## Ferramentas utilizadas

<a href="https://www.java.com" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/> 
</a>
<a href="https://spring.io/" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="Spring" width="40" height="40"/> 
</a>
<a href="https://www.postman.com/" target="_blank"> 
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" alt="Postman" width="40" /> 
</a>
<a href="https://junit.org/junit5/" target="_blank"> 
    <img src="https://camo.githubusercontent.com/47ab606787e47aee8033b92c8f1d05c0e74b9b81904550f35a8f54e39f6c993b/68747470733a2f2f6a756e69742e6f72672f6a756e6974352f6173736574732f696d672f6a756e6974352d6c6f676f2e706e67" alt="JUnit" width="40" height="40"/> 
</a>
<a href="https://www.h2database.com/" target="_blank"> 
    <img src="https://www.h2database.com/html/images/h2-logo-2.png" alt="H2 Database" width="40" height="40"/> 
</a>

## Acesso ao projeto

Você pode [acessar o código fonte do projeto](https://github.com/Grupo23TC/restaurantes-api).

## Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o `Intellij ou IDE de preferência para projetos Java`.

É necessário fazer as configurações de conexão com o banco de dados no application.properties com as variáveis 
```
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=root
spring.datasource.password=
```


Para executar o projeto localmente, deve estar usando a versão do JDK 17 ou superior e possuir o Maven em uma versão compatível configurado na sua máquina. Por se tratar de uma aplicação Spring Boot, o próprio Spring se encarregará de buildar e startar a aplicação em um servidor local Tomcat na porta 8080.

Para você acessar o Swagger, basta, enquanto o projeto estiver em execução, acessar o link: http://localhost:8080/swagger-ui/index.html


## Desenvolvedores

<table align="center">
  <tr>
    <td align="center">
      <div>
        <img src="https://avatars.githubusercontent.com/caiotfernandes" width="120px;" alt="Foto no GitHub" class="profile"/><br>
          <b> Caio Fernandes  </b><br>
            <a href="https://www.linkedin.com/in/caio-t%C3%A1rraga-fernandes-524373126/" alt="Linkedin"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" height="20"></a>
            <a href="https://github.com/caiotfernandes" alt="Github"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" height="20"></a>
      </div>
    </td>

   <td align="center">
      <div>
        <img src="https://avatars.githubusercontent.com/davialvs" width="120px;" alt="Foto no GitHub" class="profile"/><br>
          <b> Davi Alves  </b><br>
            <a href="https://www.linkedin.com/in/davi-alves-dev/" alt="Linkedin"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" height="20"></a>
            <a href="https://github.com/davialvs" alt="Github"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" height="20"></a>
      </div>
    </td>
<td align="center">
      <div>
        <img src="https://avatars.githubusercontent.com/LucasFrancoBN" width="120px;" alt="Foto no GitHub" class="profile"/><br>
          <b> Lucas Franco   </b><br>
            <a href="https://www.linkedin.com/in/lucas-franco-barbosa-navarro-a51937221/" alt="Linkedin"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" height="20"></a>
            <a href="https://github.com/LucasFrancoBN" alt="Github"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" height="20"></a>
      </div>
    </td>
  <td align="center">
      <div>
        <img src="https://avatars.githubusercontent.com/lucasctteixeira" width="120px;" alt="Foto no GitHub" class="profile"/><br>
          <b> Lucas Teixeira </b><br>
            <a href="https://www.linkedin.com/in/lucas-c-teixeira/" alt="Linkedin"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" height="20"></a>
            <a href="https://github.com/lucasctteixeira" alt="Github"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" height="20"></a>
      </div>
    </td>
