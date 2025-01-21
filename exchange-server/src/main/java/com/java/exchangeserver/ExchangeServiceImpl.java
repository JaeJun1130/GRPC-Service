package com.java.exchangeserver;

import com.java.exchange.ExchangeServiceGrpc;
import com.java.exchange.ExchangeServiceProto;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ExchangeServiceImpl extends ExchangeServiceGrpc.ExchangeServiceImplBase {
    private static final Map<String, BigDecimal> EXCHANGE_RATES = Map.of(
            "USD", BigDecimal.valueOf(1.0),    // 미국 달러
            "EUR", BigDecimal.valueOf(0.85),   // 유로
            "JPY", BigDecimal.valueOf(110.0)   // 일본 엔
    );

    @Override
    public void getExchangeRate(ExchangeServiceProto.ExchangeRequest request,
                                StreamObserver<ExchangeServiceProto.ExchangeResponse> responseObserver) {
        // 클라이언트 요청에서 통화 코드를 추출
        String currencyCode = request.getCurrencyCode();

        // 환율 데이터를 BigDecimal로 조회
        // - 요청된 통화 코드에 해당하는 환율을 EXCHANGE_RATES 맵에서 찾음
        // - 값이 없을 경우 기본 값으로 -1.0을 반환 (BigDecimal로 변환)
        BigDecimal rate = EXCHANGE_RATES.getOrDefault(currencyCode, BigDecimal.valueOf(-1.0));

        // 응답 객체 생성
        // - Protobuf에서 생성된 ExchangeResponse의 빌더를 사용
        // - currencyCode와 rate를 설정하여 응답 메시지를 구성
        ExchangeServiceProto.ExchangeResponse response = ExchangeServiceProto.ExchangeResponse.newBuilder()
                .setCurrencyCode(currencyCode)          // 응답에 통화 코드 설정
                .setExchangeRate(rate.floatValue())     // BigDecimal 값을 float로 변환하여 설정
                .build();

        // 응답 객체를 클라이언트로 전송
        responseObserver.onNext(response);

        // 클라이언트에게 스트림이 완료되었음을 알림
        responseObserver.onCompleted();
    }
}