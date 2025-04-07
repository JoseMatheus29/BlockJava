# 🚀 BlockJava API

**BlockJava** é uma API desenvolvida em **Java com Spring Boot** para registrar e consultar dados com integridade garantida por **blockchain**, utilizando o **BigchainDB** como camada de imutabilidade.

---

## 📌 Descrição

Essa API permite receber dados estruturados via JSON, gerar o **hash dos dados** (SHA-256) e:
- Armazenar os dados em um repositório na nuvem (ou local)
- Registrar o hash e metadados na blockchain via BigchainDB
- Consultar registros por ID, hash ou palavra-chave

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Web
- Spring Security
- Spring Data JPA (opcional para persistência)
- BigchainDB (via REST API)
- Maven

---

## 🧱 Arquitetura

- API REST → Recebe os dados e executa a lógica
- Hashing Service → Gera SHA-256 dos dados recebidos
- Storage Service → Armazena os dados (ex: S3, MongoDB, etc.)
- BigchainDB Client → Registra o hash + metadata na blockchain
- Validação → Consulta e verifica a integridade com base no hash

---

## ⚙️ Como rodar o projeto

### ✅ Pré-requisitos

- Java 21
- Maven
- Docker (para rodar BigchainDB localmente)
- Git

### 🔄 Clonar o repositório
```bash
git clone https://github.com/seu-usuario/blockjava-api.git
cd blockjava-api
```
📦 Instalar dependências
```bash
mvn clean install
```
▶️ Rodar o projeto
```bash
mvn spring-boot:run
```

## 📌 Endpoints Principais

### **🔹 Usuários (`/users`)**
| Método  | Endpoint          | Descrição                                      |
|---------|-------------------|------------------------------------------------|
| `POST`   | `/registro`      | Registra dados e hash na blockchain            |
| `GET`    | `/registro/{id}` | Consulta um registro pelo ID do BigchainDB     |
| `GET`    | `/verificar`     | Valida se o hash de um dado já foi registrado  |

Desenvolvido José Matheus✌  [Veja meu Linkedin](https://www.linkedin.com/in/josé-matheus-de-lima-27706a1b6/)

