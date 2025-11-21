# UpSkill API - Global Solution FIAP 2025

API RESTful para plataforma de Upskilling/Reskilling (Tema: Futuro do Trabalho).


## Apresentação descritiva
A DHM – Desenvolvimento de Habilidades Modernas é uma plataforma criada para ajudar pessoas a se manterem relevantes em um mercado que muda numa velocidade absurda. O nosso foco é simples: facilitar o aprendizado de novas competências e apoiar quem quer evoluir na carreira, seja melhorando o que já sabe ou mudando completamente de área.
## Tecnologias
- Java 21
- Spring Boot 3.2.x
- H2 (in-memory)
- Spring Data JPA
- Bean Validation

## Como rodar
1. `mvn clean install`
2. `mvn spring-boot:run`

API base: http://localhost:8080

H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:upskilldb
username: sa
password:

## Endpoints principais
Usuarios:
- GET /api/usuarios
- GET /api/usuarios/{id}
- POST /api/usuarios
- PUT /api/usuarios/{id}
- DELETE /api/usuarios/{id}

Trilhas:
- GET /api/trilhas
- GET /api/trilhas/{id}
- POST /api/trilhas
- PUT /api/trilhas/{id}
- DELETE /api/trilhas/{id}

Matriculas:
- GET /api/matriculas
- POST /api/matriculas  (body: { "usuarioId":1, "trilhaId":2 })