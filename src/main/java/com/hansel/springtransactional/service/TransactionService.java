package com.hansel.springtransactional.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionService {
    private final AnotherService anotherService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredTransaction() {
        // Business logic
        anotherService.someMethod();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewTransaction() {
        // Business logic
        anotherService.someMethod();
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nestedTransaction() {
        // Business logic
        anotherService.someMethod();
    }
}