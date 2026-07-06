#  Biblioteca API

API REST desenvolvida em **Java 17** com **Spring Boot**, criada para praticar arquitetura em camadas, JPA, PostgreSQL e regras de negócio em um sistema de biblioteca.

##  Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Hibernate

##  Arquitetura

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL

Cada camada possui uma responsabilidade específica:

- **Controller:** recebe as requisições HTTP.
- **Service:** contém as regras de negócio.
- **Repository:** realiza o acesso ao banco de dados.
- **Entity:** representa as tabelas do banco de dados.

---

## Funcionalidades

### Livros

- Cadastrar livro
- Listar livros
- Buscar livro por ID
- Atualizar livro
- Excluir livro

### Usuários

- Cadastrar usuário
- Listar usuários
- Buscar usuário por ID
- Atualizar usuário
- Excluir usuário

### Empréstimos

- Registrar empréstimo
- Registrar devolução
- Listar empréstimos
- Impedir empréstimo de livro já emprestado
- Limitar o usuário a 3 empréstimos ativos

---

## Como executar

Clone o projeto:

```bash
git clone https://github.com/GustaFlorenci/biblioteca-api.git
```

Entre na pasta:

```bash
cd biblioteca-api
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080
```

---

## 👨‍💻 Autor

**Gustavo Florencio**

GitHub:
https://github.com/GustaFlorenci
