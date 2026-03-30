# 📱 FuelCalc - App Android

Aplicação mobile desenvolvida em Kotlin no Android Studio para calcular qual combustível é mais vantajoso (etanol ou gasolina), com base nos valores informados pelo usuário.

---

## 📌 Funcionalidades

- Tela de Splash com animação
- Tela inicial (Home)
- Tela de cálculo de combustível
- Validação básica dos campos
- Cálculo da melhor opção:
  - Etanol ou Gasolina

---

## 🧠 Regra de Negócio

A aplicação utiliza a seguinte lógica:

- Se (etanol / gasolina) ≤ 0.7 → **Etanol é mais vantajoso**
- Se (etanol / gasolina) > 0.7 → **Gasolina é mais vantajosa**

---

## 🛠️ Tecnologias utilizadas

- Kotlin
- Android Studio
- Material Design (Material Components)
- ConstraintLayout

---

## 🎨 Interface

O app conta com uma interface moderna e simples, utilizando:

- Splash Screen com animação (fade + scale)
- Inputs estilizados com `TextInputLayout`
- Botões com `MaterialButton`
- Layout responsivo e organizado

---

## 📂 Estrutura de telas

- **SplashActivity** → Tela inicial com animação
- **MainActivity** → Tela de boas-vindas
- **CalculoActivity** → Tela principal de cálculo

---

## ▶️ Como executar

1. Clonar o repositório:

```bash
git clone <url-do-repositorio>
````

2. Abrir no Android Studio

3. Executar o projeto em:

   * Emulador Android
   * Dispositivo físico

---

## 📌 Integração com Backend

🔄 Em desenvolvimento

O app será integrado com uma API REST desenvolvida em Spring Boot para realizar o cálculo no backend.

---

## 🚀 Próximos passos

* [ ] Integração com API (Retrofit)
* [ ] Tratamento de erros
* [ ] Melhorias de UX/UI
* [ ] Feedback visual (loading, mensagens)
* [ ] Deploy do backend

---

## 🎯 Objetivo do projeto

Este projeto faz parte do meu portfólio como desenvolvedor, com foco em:

* Desenvolvimento mobile com Kotlin
* Consumo de APIs REST
* Aplicação de boas práticas de UI/UX
* Integração entre frontend e backend

---

## 👨‍💻 Autor

Felipe Shimizu

🔗 Portfólio: [https://www.devfelipeshimizu.me/](https://www.devfelipeshimizu.me/)
🔗 LinkedIn: [https://www.linkedin.com/in/felipesshimizu](https://www.linkedin.com/in/felipesshimizu)
