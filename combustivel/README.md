# 🚗 API de Cálculo de Combustível

API REST desenvolvida em Java com Spring Boot para calcular qual combustível é mais vantajoso (etanol ou gasolina) com base na proporção entre os preços.

---

## 📌 Regra de Negócio

A aplicação utiliza a seguinte regra:

- Se (etanol / gasolina) ≤ 0.7 → **Etanol é mais vantajoso**
- Se (etanol / gasolina) > 0.7 → **Gasolina é mais vantajosa**

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Bean Validation (Jakarta Validation)
- Maven

---

## 📂 Estrutura do projeto

```

controller/
service/
dto/
request/
response/

````

---

## 🚀 Endpoint

### 📌 Calcular melhor combustível

**POST** `/combustivel`

---

### 📥 Request

```json
{
  "valorEtanol": 3.79,
  "valorGasolina": 5.49
}
````

---

### 📤 Response

```json
{
  "melhorCombustivel": "ETANOL",
  "proporcao": 0.6903
}
```

---

## ⚠️ Validações

A API valida automaticamente os dados de entrada:

* Campos obrigatórios (`@NotNull`)
* Valores maiores que zero (`@DecimalMin`)
* Limite de casas decimais (`@Digits`)

---

## ▶️ Como executar

```bash
# Clonar o repositório
git clone <url-do-repositorio>

# Entrar na pasta do backend
cd combustivel

# Rodar o projeto
./mvnw spring-boot:run
```

---

## 🧪 Testando a API

Você pode utilizar:

* Postman
* Insomnia

URL local:

```
http://localhost:8080/combustivel
```

---

## 📌 Status do projeto

✅ Backend funcional
🔄 Melhorias futuras:

* Tratamento global de erros
* Testes automatizados
* Integração com frontend

---

## 👨‍💻 Autor

Felipe Shimizu



