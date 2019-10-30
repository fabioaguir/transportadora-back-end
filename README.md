# Desafio (Projeto)
Portfólio de Transportadoras (Back-end)

## Sobre
Projeto de desenvolvimento de um sistema para que as transportadoras possam se
cadastrar para que a mesma possa ser consultada, aparecendo na listagem principal do sistema.

## Tecnologias
- Java: 8
- Spring Boot Framework: 2.2.0
- ORM Hibernate: 5
- JUnit: 5
- SGBD Mysql: 8

## Ferramentas de Desenvolvimento e Versionamento
- IDE: IntelliJ IDEA
- Versionamento: GIT (GitHub)

## Estrutura de Package
O projeto segue o padrão de arquitetura MVC

- `package padrão`: com.hive.transportadora
- `package controllers`:  Organizar as classes controladoras para recebimento das requisições e envio de resposta as mesmas
- `package dto`: (Data Transfer Object) - Organizar as classes utilizadas para o padrão DTO
- `package exceptions`: Organizar as classes utilizadas para tratamento personalizado de exceções
- `package models`: Organizar as classes de modelos de entidades (domain)
- `package queriesCustomized`: Organizar as classes onde se aplica a construção de consultas personalizadas das quais
se tenha dificuldade ou que não seja possível criá-las por meio do repository JPA
- `package repositories`: Organizar as classes de repositório (DAO) utilizada para trabalhar com a comunicação ao banco de dados
- `package services`: Organizar as classes de serviço utilizada para trabalhar as regras de negócio da aplicação
- `package utils`: Organizar as classes utilitárias

Peckages para fins de Testes Unitários
- `package padrão`: com.hive.transportadora
- `package repositories`: Organizar as classes de testes utilizadas para realizar testes unitários nos repositories da aplicação

## Dependências
O projeto utiliza o `Maven` para gerenciamento de dependências e atividades automatizadas

Dependências utilizadas:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mysql
- spring-boot-starter-test
- junit-vintage-engine

## Observação
No método `public void run(String... args)` na class `TransportadoraApplication` possui dois métodos para criar instâncias
de UFs e Modals populando a DB com tais dados, depois de executar esse métodos uma vez, comente os mesmos para que nas
próximas execuções da aplicação, os dados das Ufs e Modals não sejam duplicados no banco de dados