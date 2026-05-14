# 🛠️ Sistema OS - Gestão de Serviços

Este repositório contém um sistema de **Gestão de Ordens de Serviço (OS)** completo, desenvolvido em Java com integração ao banco de dados MySQL. O foco principal do projeto é a aplicação de conceitos de Programação Orientada a Objetos (POO) e manipulação de dados em ambiente desktop.

## 🚀 Tecnologias e Ferramentas
*   **Linguagem:** Java (JDK)
*   **Interface Gráfica:** Java Swing
*   **Banco de Dados:** MySQL
*   **Persistência de Dados:** JDBC (Java Database Connectivity)
*   **IDE:** NetBeans

## ✨ Funcionalidades Principais
*   **Autenticação:** Sistema de login com diferenciação de níveis de acesso (Admin e Usuário padrão).
*   **Módulo de Clientes:** CRUD completo (Create, Read, Update, Delete) com busca em tempo real via SQL.
*   **Gestão de Ordens de Serviço:** Registro detalhado de equipamentos, defeitos, técnicos responsáveis e valores, com geração automática de protocolo.
*   **Relatórios:** Integração para emissão de documentos de serviços e listagem de clientes.

## 🗄️ Estrutura do Banco de Dados
O banco de dados foi estruturado para garantir a integridade das informações através de relacionamentos:
*   `tbusuarios`: Controle de acesso e perfis.
*   `tbclientes`: Cadastro centralizado de clientes.
*   `tbos`: Registro de serviços vinculado aos clientes via Chave Estrangeira (FK).

## 🛠️ Como Executar
1. Certifique-se de ter o **MySQL** instalado e rodando.
2. Crie o banco de dados e as tabelas utilizando o script SQL (geralmente localizado na pasta de recursos do projeto).
3. No arquivo de conexão (`ModuloConexao.java`), ajuste as credenciais:
   - `user`: Seu usuário do MySQL.
   - `password`: Sua senha do banco.
4. Abra o projeto no **NetBeans** e execute o arquivo da tela de Login.

---
**Desenvolvido por Adrielle Mendes Caboclo**  
Estudante de Engenharia de Computação - UFRPE
