# Projeto-Final-Java
# Sistema de Gestão de OKRs (Objectives and Key Results)
# Vídeo da Apresentação: https://youtu.be/DcBnz86xyjM

Um sistema simplificado para acompanhamento de OKRs, permitindo o registro de objetivos, resultados-chave (KRs) e iniciativas relacionadas. Desenvolvido com **Java Spring Boot** para o back-end e preparado para integração com um front-end em NextJS.

---

## 📋 Funcionalidades

- **CRUD para Objetivos, KRs e Iniciativas**  
  Crie, edite, exclua e consulte objetivos estratégicos, resultados-chave e ações concretas.
  
- **Cálculo Automático de Progresso**  
  A porcentagem de conclusão de KRs e Objetivos é atualizada automaticamente com base nas iniciativas.

- **API REST Padronizada**  
  Endpoints claros para integração com front-end ou outras aplicações.

---

## 🛠 Tecnologias

### Back-end
- **Java 17**
- **Spring Boot 3.4.5**
- **Spring Data JPA (Hibernate)**
- **Lombok** (para redução de código boilerplate)
- **H2 Database** (banco em memória para desenvolvimento)

---

## 🔗 Endpoints da API

### **Objetivos** (`/objetivos`)
| Método HTTP | Endpoint               | Descrição                          |
|-------------|------------------------|------------------------------------|
| **GET**     | `/objetivos`           | Lista todos os objetivos.          |
| **GET**     | `/objetivos/{id}`      | Busca um objetivo por ID.          |
| **POST**    | `/objetivos`           | Cria um novo objetivo.             |
| **PUT**     | `/objetivos/{id}`      | Atualiza um objetivo existente.    |
| **DELETE**  | `/objetivos/{id}`      | Exclui um objetivo.                |
| **POST**    | `/objetivos/{id}/calcular` | Recalcula o percentual de conclusão do objetivo. |

---

### **Resultados-Chave** (`/resultados-chave`)
| Método HTTP | Endpoint                  | Descrição                          |
|-------------|---------------------------|------------------------------------|
| **GET**     | `/resultados-chave`       | Lista todos os resultados-chave.   |
| **GET**     | `/resultados-chave/{id}`  | Busca um resultado-chave por ID.   |
| **POST**    | `/resultados-chave`       | Cria um novo resultado-chave.      |
| **PUT**     | `/resultados-chave/{id}`  | Atualiza um resultado-chave.       |
| **DELETE**  | `/resultados-chave/{id}`  | Exclui um resultado-chave.         |

---

### **Iniciativas** (`/iniciativas`)
| Método HTTP | Endpoint                | Descrição                          |
|-------------|-------------------------|------------------------------------|
| **GET**     | `/iniciativas`          | Lista todas as iniciativas.        |
| **GET**     | `/iniciativas/{id}`     | Busca uma iniciativa por ID.       |
| **POST**    | `/iniciativas`          | Cria uma nova iniciativa.          |
| **PUT**     | `/iniciativas/{id}`     | Atualiza uma iniciativa.           |
| **DELETE**  | `/iniciativas/{id}`     | Exclui uma iniciativa.             |

