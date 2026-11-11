package com.finsecure.pay.controller;
import com.finsecure.pay.model.TransactionRequest;
import com.finsecure.pay.model.ValidationResponse;
import com.finsecure.pay.service.TransactionValidationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ValidationController {

    private final TransactionValidationService service;
    public ValidationController(
            TransactionValidationService service) {
            this.service = service;
}
        @PostMapping("/validate")
        public Map<String, String> validate(
        @RequestBody TransactionRequest request) {

        ValidationResponse result = service.validate(request);
            return Map.of(
            "transactionId",
                request.getTransactionId(),
            "status",
                result.getStatus()
        );
    }
}