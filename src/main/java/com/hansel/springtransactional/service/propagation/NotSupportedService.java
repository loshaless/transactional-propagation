package com.hansel.springtransactional.service.propagation;

import com.hansel.springtransactional.entity.Test;
import com.hansel.springtransactional.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotSupportedService {
    private final TestService testService;
    private final TestRepository testRepository;

    /*NOT_SUPPORTED
    Execute non-transactional, suspend the current transaction if one exists.*/

    @Transactional
    public void testNotSupported() {
        for (int i = 0; i < 5; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
        testService.testNotSupported();
    }
}
