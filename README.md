
# ParkChatBot

Este é um projeto de gestão de aluguel de vagas de condomínio entre moradores, desenvolvido com Spring Boot. A aplicação simula um fluxo automatizado de aluguel via chatbot do WhatsApp (a ser integrado), permitindo proprietários oferecerem vagas e outros moradores manifestarem interesse.

💬 Atualmente, todas as operações (cadastro de moradores, vagas, ofertas, interesses e confirmações) são realizadas via Swagger ou ferramentas como Insomnia/Postman.

---

## 🛠️ Tecnologias Utilizadas

- Java 21  
- Spring Boot    
- Spring Data JPA  
- Swagger OpenAPI (Documentação e Testes de API)  
- PostgreSQL  
- Docker  
- IntelliJ IDEA  

---

## 🚀 Como Executar o Projeto

Clone o repositório:

```bash
git clone https://github.com/diegoliveiraa/parkchatbot.git
```

Acesse o diretório:

```bash
cd parkchatbot
```

Suba o banco PostgreSQL com Docker:

```bash
docker-compose up -d
```

Execute o projeto com Spring Boot na sua IDE ou via terminal:

```bash
./mvnw spring-boot:run
```

Acesse a documentação da API via Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Funcionalidades

- Cadastro de moradores e vagas de garagem  
- Criação de ofertas de aluguel de vagas  
- Manifestação de interesse por vagas disponíveis  
- Confirmação de aluguel (proprietário aceita interesse)  
- Cancelamento manual de interesses e contratos  
- Encerramento automático de aluguéis vencidos (Scheduler)
- Consulta de histórico de aluguéis por vaga e morador 

---

## 👨‍💻 Autor

Desenvolvido por **Diego Oliveira**  
[LinkedIn](https://www.linkedin.com/in/diegoliveiraa/) | [GitHub](https://github.com/diegoliveiraa)
