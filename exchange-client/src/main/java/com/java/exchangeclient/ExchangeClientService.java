package com.java.exchangeclient;

import com.java.exchange.ExchangeServiceGrpc;
import com.java.exchange.ExchangeServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class ExchangeClientService {
    private final ExchangeServiceGrpc.ExchangeServiceBlockingStub exchangeServiceBlockingStub;

    public ExchangeClientService() {
        // ManagedChannel 생성 (gRPC 서버 주소와 포트 설정)
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090) // gRPC 서버 주소와 포트
                .usePlaintext() // 평문 통신 설정
                .build();

        // BlockingStub 초기화
        this.exchangeServiceBlockingStub = ExchangeServiceGrpc.newBlockingStub(channel);
    }

    public String getExchangeRate(String currencyCode) {
        // gRPC 요청 메시지 생성
        ExchangeServiceProto.ExchangeRequest request = ExchangeServiceProto.ExchangeRequest.newBuilder()
                .setCurrencyCode(currencyCode)
                .build();

        // gRPC 서버로 요청 보내고 응답 받기
        ExchangeServiceProto.ExchangeResponse response = exchangeServiceBlockingStub.getExchangeRate(request);

        // 결과 반환
        return String.format("Currency: %s, Exchange Rate: %.2f",
                response.getCurrencyCode(), response.getExchangeRate());
    }
}
