package com.finsecure.pay;

import com.finsecure.pay.model.TransactionRequest;
import com.finsecure.pay.model.ValidationResponse;
import com.finsecure.pay.service.TransactionValidationService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionValidationServiceTest {

    private final TransactionValidationService service =
            new TransactionValidationService();

    @Test
    void validTransactionShouldPass() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("TX1001");
        request.setAccountNumber("ACC12345");
        request.setAmount(5000.0);
        request.setCurrency("SGD");

        ValidationResponse response =
                service.validate(request);

        assertEquals("VALID", response.getStatus());
    }

    @Test
    void missingTransactionIdShouldFail() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("");
        request.setAccountNumber("ACC12345");
        request.setAmount(5000.0);
        request.setCurrency("SGD");

        ValidationResponse response =
                service.validate(request);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void missingAccountNumberShouldFail() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("TX1001");
        request.setAccountNumber("");
        request.setAmount(5000.0);
        request.setCurrency("SGD");

        ValidationResponse response =
                service.validate(request);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void negativeAmountShouldFail() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("TX1001");
        request.setAccountNumber("ACC12345");
        request.setAmount(-100.0);
        request.setCurrency("SGD");

        ValidationResponse response =
                service.validate(request);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void amountExceedsLimitShouldFail() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("TX1001");
        request.setAccountNumber("ACC12345");
        request.setAmount(25000.0);
        request.setCurrency("SGD");

        ValidationResponse response =
                service.validate(request);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void unsupportedCurrencyShouldFail() {

        TransactionRequest request = new TransactionRequest();

        request.setTransactionId("TX1001");
        request.setAccountNumber("ACC12345");
        request.setAmount(5000.0);
        request.setCurrency("BTC");

        ValidationResponse response =
                service.validate(request);

        assertEquals("INVALID", response.getStatus());
    }
}
