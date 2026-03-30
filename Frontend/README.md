# 🔥 Calculadora de Combustível — Android + Kotlin + Retrofit

Aplicativo Android desenvolvido com **Kotlin** para calcular qual combustível é mais vantajoso — **Etanol** ou **Gasolina** — com base nos preços informados pelo usuário. O app consome uma API REST desenvolvida em **Java (Spring Boot)** via **Retrofit 2**.

---

## 📱 Telas

| Tela | Descrição |
|------|-----------|
| `SplashActivity` | Tela de abertura com animação de fade + zoom |
| `MainActivity` | Tela inicial com botão para acessar a calculadora |
| `CalculoActivity` | Tela principal com inputs, chamada à API e exibição do resultado |

---

## 🏗️ Estrutura do Projeto

```
app/
└── kotlin+java/
    └── com.example.calculadora_combustivel/
        ├── api/
        │   └── CombustivelApi.kt          # Interface Retrofit (endpoints)
        ├── dto/
        │   ├── request/
        │   │   └── CombustivelRequest.kt  # Dados enviados à API
        │   └── response/
        │       └── CombustivelResponse.kt # Dados recebidos da API
        ├── network/
        │   └── RetrofitClient.kt          # Singleton de configuração do Retrofit
        ├── CalculoViewModel.kt            # Lógica e chamada à API
        ├── CalculoActivity.kt             # Apenas UI (observa o ViewModel)
        ├── MainActivity.kt                # Tela inicial
        └── SplashActivity.kt             # Tela de splash com animação
```

---

## 🏛️ Arquitetura — MVVM

O projeto segue o padrão **MVVM (Model-View-ViewModel)**, recomendado pelo Google para apps Android modernos.

### Analogia com Spring Boot

| Camada Spring | Camada Android | Responsabilidade |
|---------------|----------------|-----------------|
| `Controller` | `Activity` | Recebe input do usuário, exibe resultado na tela |
| `Service` | `ViewModel` | Lógica, chamada à API, gerencia estado |
| `RestTemplate` | `Retrofit` | Executa as chamadas HTTP |
| `DTO` | `data class` | Representa os dados trafegados |

### Fluxo de dados

```
Usuário digita valores
        ↓
CalculoActivity.btnCalcular.setOnClickListener
        ↓
CalculoViewModel.calcular(etanol, gasolina)
        ↓
RetrofitClient.api.calcular(request)   ← chamada HTTP (suspend)
        ↓
ViewModel atualiza LiveData (resultado / erro / loading)
        ↓
Activity observa e atualiza a UI automaticamente
```

### Por que ViewModel e não só Activity?

A `Activity` pode ser destruída e recriada a qualquer momento (ao girar a tela, por exemplo). O `ViewModel` **sobrevive** a isso — mantém o estado e a chamada em andamento, entregando o resultado quando a Activity for recriada.

---

## 🔗 Conexão com o Backend

A comunicação com a API é feita via **Retrofit 2** com Coroutines e conversão JSON usando **Gson**.

### Endpoint consumido

```
POST /combustivel
```

**Request body:**
```json
{
  "valorEtanol": 3.50,
  "valorGasolina": 5.80
}
```

**Response body:**
```json
{
  "melhorCombustivel": "ETANOL",
  "proporcao": 0.603
}
```

### Interface Retrofit (com Coroutines)

```kotlin
interface CombustivelApi {
    @POST("/combustivel")
    suspend fun calcular(@Body request: CombustivelRequest): CombustivelResponse
}
```

### Configuração do cliente Retrofit

```kotlin
object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val api: CombustivelApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CombustivelApi::class.java)
    }
}
```

> ⚠️ O endereço `10.0.2.2` é o loopback do emulador Android para acessar o `localhost` da máquina host. Para dispositivos físicos, substitua pelo IP local da máquina onde o backend está rodando.

---

## 🧮 Lógica de Negócio

A lógica de comparação reside no **backend**. O app apenas envia os preços e exibe o resultado retornado.

A regra aplicada é a clássica do mercado brasileiro:

> **Etanol vale a pena** se seu preço for igual ou inferior a **70% do preço da gasolina**.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Uso |
|------------|-----|
| Kotlin | Linguagem principal |
| Android SDK | Desenvolvimento mobile |
| MVVM + ViewModel | Arquitetura e separação de responsabilidades |
| LiveData | Observação reativa de estado na UI |
| Coroutines | Chamadas assíncronas sem callbacks |
| Retrofit 2 | Chamadas HTTP à API REST |
| Gson Converter | Serialização/desserialização JSON |
| Material Components | UI — TextInputEditText, MaterialButton |
| Spring Boot (backend) | API REST em Java |

---

## ▶️ Como Executar

### Pré-requisitos

- Android Studio instalado
- Backend Java/Spring Boot rodando localmente na porta `8080`
- Emulador Android ou dispositivo físico configurado

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/calculadora-combustivel.git
```

2. Abra o projeto no **Android Studio**

3. Certifique-se de que o backend está rodando:
```bash
./mvnw spring-boot:run
```

4. Execute o app no emulador via Android Studio

> 💡 Se estiver usando dispositivo físico, altere o `BASE_URL` no `RetrofitClient.kt` para o IP local da sua máquina (ex: `http://192.168.1.10:8080/`).

---

## 📦 Dependências Android (build.gradle)

```groovy
// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// ViewModel + LiveData + Coroutines
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

// Material Design
implementation("com.google.android.material:material:1.11.0")
```

---

## 🔮 Melhorias Futuras

- [ ] Adicionar camada `Repository` entre ViewModel e API
- [ ] Injeção de dependência com **Hilt**
- [ ] Suporte a múltiplos ambientes via `BuildConfig` (dev, prod)
- [ ] Testes unitários do ViewModel com `JUnit` e `MockK`
- [ ] Testes de integração com `MockWebServer`

---

## 👨‍💻 Autor

Felipe Shimizu  

🔗 Portfólio: https://www.devfelipeshimizu.me/  
🔗 LinkedIn: https://www.linkedin.com/in/felipesshimizu

Desenvolvido como projeto de estudo de integração **Android Kotlin ↔ Backend Java REST**, com evolução de arquitetura de callbacks para MVVM + Coroutines.