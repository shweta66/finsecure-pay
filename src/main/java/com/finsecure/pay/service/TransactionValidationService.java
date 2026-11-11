package com.finsecure.pay.service;

import com.finsecure.pay.model.TransactionRequest;
import com.finsecure.pay.model.ValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidationService {

    public ValidationResponse validate(TransactionRequest request) {

        if (request.getTransactionId() == null
                || request.getTransactionId().isBlank()) {

            return new ValidationResponse(
                    "INVALID",
                    "Transaction ID is required");
        }

        if (request.getAccountNumber() == null
                || request.getAccountNumber().isBlank()) {

            return new ValidationResponse(
                    "INVALID",
                    "Account number is required");
        }

        if (request.getAmount() == null
                || request.getAmount() <= 0) {

            return new ValidationResponse(
                    "INVALID",
                    "Amount must be greater than zero");
        }

        if (request.getAmount() > 10000) {

            return new ValidationResponse(
                    "INVALID",
                    "Amount exceeds limit of 10000");
        }

        if (request.getCurrency() == null) {

            return new ValidationResponse(
                    "INVALID",
                    "Currency is required");
        }

        if (!(request.getCurrency().equalsIgnoreCase("SGD")
                || request.getCurrency().equalsIgnoreCase("USD")
                || request.getCurrency().equalsIgnoreCase("EUR"))) {

            return new ValidationResponse(
                    "INVALID",
                    "Unsupported currency");
        }

        return new ValidationResponse(
                "VALID",
                "Transaction approved");
    }
}