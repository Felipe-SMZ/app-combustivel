# 🚀 Projeto Fullstack — Calculadora de Combustível

Aplicação fullstack para calcular qual combustível é mais vantajoso (Etanol ou Gasolina), com **backend em Java (Spring Boot)** e **frontend Android em Kotlin**. Projeto de estudo para portfólio e aprendizado de integração Android ↔ Backend.

---

## 📂 Estrutura do Projeto

```
📦 projeto
┣ 📂 combustivel       → Backend Spring Boot API
┣ 📂 android-app       → Frontend Android em Kotlin
┗ 📄 README.md         → README geral do projeto
```

> Cada módulo tem seu próprio README detalhado.

---

## 🧠 Objetivo

Criar uma aplicação completa que:

* Recebe valores de combustível (etanol e gasolina)
* Calcula a melhor opção com base na proporção (etanol ≤ 70% do preço da gasolina)
* Retorna o resultado para o usuário
* Integra backend com frontend (mobile)
* Evolui para persistência de dados e histórico de cálculos

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 21
* Spring Boot
* Spring Web / Bean Validation
* Maven
* (Futuro) Spring Security + JWT
* (Futuro) PostgreSQL / H2 para testes

### Frontend (em desenvolvimento)

* Kotlin
* Android SDK
* MVVM + LiveData + Coroutines
* Retrofit 2 + Gson
* Material Components

> Observação: Também é possível evoluir para frontend web com React.

---

## 🔗 Backend

A API já está implementada e funcional.

* Caminho do módulo: `/combustivel`
* Endpoint principal: `POST /combustivel`
* Detalhes e documentação interna: `/combustivel/README.md`

**Futuras melhorias no backend:**

* Persistência de cálculos com PostgreSQL
* Autenticação de usuários com JWT
* Histórico de cálculos por usuário
* Docker + deploy em nuvem gratuita (Azure / Railway / Render)

---

## 📱 Frontend Android

* Caminho do módulo: `/android-app`
* Já implementado: tela de cálculo, MVVM, LiveData, coroutines e integração com Retrofit
* Futuras melhorias:

  * Tela de login/cadastro com JWT
  * Tela de histórico de cálculos
  * Campo opcional “Posto”
  * Melhorias de UI/UX
  * Testes unitários e instrumentados

> Detalhes e documentação interna: `/android-app/README.md`

---

## 🚀 Roadmap / Próximos Passos

1. **Frontend Android**

   * [ ] Completar telas de login e cadastro
   * [ ] Integrar token JWT nas requisições
   * [ ] Criar tela de histórico de cálculos

2. **Backend**

   * [ ] Criar entidade `Usuario` + registro/login
   * [ ] Criar entidade `Calculo` + CRUD
   * [ ] Conectar PostgreSQL (ou H2 para testes)
   * [ ] Adicionar Dockerfile e docker-compose

3. **Deploy**

   * [ ] Deploy do backend em nuvem gratuita
   * [ ] Configuração de variáveis de ambiente (DB, JWT)
   * [ ] Testar integração com app Android

4. **Extras**

   * [ ] Testes unitários e de integração
   * [ ] Melhorias de UI/UX
   * [ ] Suporte a múltiplos ambientes (dev/prod)

---

## 🎯 Objetivo do Projeto

* Praticar **desenvolvimento fullstack**
* Aprender integração entre **Android ↔ API REST**
* Criar **aplicação de portfólio** mostrando boas práticas
* Evoluir arquitetura de callbacks para **MVVM + Coroutines**

---

## 👨‍💻 Autor

Felipe Shimizu

🔗 Portfólio: [https://www.devfelipeshimizu.me](https://www.devfelipeshimizu.me)

🔗 LinkedIn: [https://www.linkedin.com/in/felipesshimizu](https://www.linkedin.com/in/felipesshimizu)
