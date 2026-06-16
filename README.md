# 📬 MS Notificação API

API responsável pelo envio de notificações por e-mail baseada em eventos de tarefas.
Este microserviço permite integrar sistemas e disparar notificações automatizadas utilizando templates HTML.

🔗 Repositório:
https://github.com/marciosalesdev/ms-notificacao

---

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Mail
* Thymeleaf (template de e-mail)
* Lombok
* SMTP (Gmail)

---

## 📌 Objetivo do projeto

Este microserviço foi desenvolvido para:

* Enviar notificações de tarefas por e-mail
* Utilizar templates HTML dinâmicos
* Ser facilmente integrável com outros serviços (arquitetura de microserviços)
* Demonstrar boas práticas com Spring Boot

---

## 🧱 Estrutura do projeto

```
ms-notificacao
│
├── controller
│   └── EmailController.java
│
├── business
│   ├── EmailService.java
│   └── dto
│       └── TarefasDTO.java
│
├── infrastructure
│   └── exception
│       └── EmailException.java
│
├── resources
│   ├── templates
│   │   └── EmailTemplate.html
│   └── application.yml
```

---

## 📬 Endpoint

### 🔹 Enviar e-mail

**POST** `/email`

---

## 📥 Request Body

```json
{
  "emailUsuario": "usuario@email.com",
  "nomeTarefa": "Estudar Docker",
  "dataEvento": "2026-05-31T00:00",
  "descricao": "Estudar todos os módulos do curso"
}
```

---

## 📤 Response

```
200 OK
```

---

## ⚙️ Configuração

### application.yml

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${EMAIL_USERNAME}
    password: ${EMAIL_PASSWORD}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true

envio:
  email:
    remetente: ${EMAIL_USERNAME}
    nomeRemetente: 'MS Notificação'
```

---

## 🔐 Segurança

⚠️ Nunca exponha credenciais diretamente no código.

Use variáveis de ambiente:

```bash
EMAIL_USERNAME=seu_email@gmail.com
EMAIL_PASSWORD=sua_senha_app
```

---

## 🎨 Template de E-mail

O projeto utiliza Thymeleaf para gerar e-mails dinâmicos:

* Nome da tarefa
* Data do evento
* Descrição

📁 Local:
`/resources/templates/EmailTemplate.html`

---

## 🧪 Testando a API

Você pode testar usando:

* Postman
* Insomnia
* curl

### Exemplo curl

```bash
curl -X POST http://localhost:8083/email \
-H "Content-Type: application/json" \
-d '{
  "emailUsuario": "teste@email.com",
  "nomeTarefa": "Estudar Spring",
  "dataEvento": "2026-05-31T10:00",
  "descricao": "Finalizar módulo de email"
}'
```

---

## 🧠 Possíveis melhorias

* [ ] Implementar fila (RabbitMQ / Kafka)
* [ ] Retry automático de envio
* [ ] Logs estruturados
* [ ] Monitoramento (Spring Actuator)
* [ ] Suporte a múltiplos templates
* [ ] Versionamento da API
* [ ] Testes unitários

---

## 📦 Boas práticas aplicadas

* Separação de responsabilidades (Controller / Service)
* Uso de DTO
* Tratamento de exceções customizadas
* Injeção de dependência com Lombok

---

## 👨‍💻 Autor

**Marcio Sales**

* GitHub: https://github.com/marciosalesdev
* Projeto realizado pelo curso Javanauta 

---

## 📄 Licença

Este projeto está sob a licença MIT.
