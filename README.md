# Exchange Rate Service (gRPC + REST)

이 프로젝트는 gRPC 서버와 REST API 클라이언트를 활용하여 환율 정보를 제공하는 서비스입니다.

```yml
├── exchange-api
│   ├── build.gradle
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── java
│   │   │   │           └── exchange
│   │   │   └── proto
│   │   │       └── exchange.proto
│   │   └── resources
├── exchange-client
│   ├── build.gradle
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── java
│   │   │   │           └── exchangeclient
│   │   │   │               ├── ExchangeApi.java
│   │   │   │               ├── ExchangeClientApplication.java
│   │   │   │               └── ExchangeClientService.java
│   │   │   └── resources
│   │   │       ├── application.yml
│   │   │       └── exchange-rate.http
├── exchange-server
│   ├── build.gradle
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── java
│   │   │   │           └── exchangeserver
│   │   │   │               ├── ExchangeServerApplication.java
│   │   │   │               └── ExchangeServiceImpl.java
│   │   │   └── resources
│   │   │       └── application.yml
```

---

## 구성 요소

### 1. **Exchange API **
- gRPC를 통해 서버-클라이언트 간의 통신을 위한 공통 메시지와 서비스를 정의합니다.

### 2. **Exchange Server**
- gRPC 서버를 구현하여 환율 정보를 제공합니다.
- 특정 통화 코드에 대해 환율 데이터를 반환합니다.

### 3. **Exchange Client**
- REST API 엔드포인트를 제공하여 사용자가 요청할 수 있는 클라이언트 역할을 합니다.
- REST API 요청을 받아 gRPC 클라이언트를 통해 서버와 통신하여 결과를 반환합니다.


![image](https://github.com/user-attachments/assets/886cf841-81d5-446e-a060-cb86c83d2138)

