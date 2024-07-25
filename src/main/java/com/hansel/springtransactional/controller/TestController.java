package com.hansel.springtransactional.controller;

import com.hansel.springtransactional.service.propagation.NeverService;
import com.hansel.springtransactional.service.propagation.NotSupportedService;
import com.hansel.springtransactional.service.propagation.RequiresNewService;
import com.hansel.springtransactional.service.propagation.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    private final NeverService neverService;
    private final RequiresNewService requiresNewService;
    private final NotSupportedService notSupportedService;

    @GetMapping("/test-required")
    public void testRequired() {
        testService.testRequired();
    }

    @GetMapping("/test-mandatory")
    public void testMandatory() {
        testService.testMandatory();
    }

    @GetMapping("/test-never")
    public void testNever() {
        neverService.testNever();
    }

    @GetMapping("/test-new")
    public void testNew() {
        requiresNewService.testNew();
    }

    @GetMapping("/test-not-supported")
    public void testNotSupported() {
        notSupportedService.testNotSupported();
    }
}
