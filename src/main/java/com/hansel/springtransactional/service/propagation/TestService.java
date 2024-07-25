package com.hansel.springtransactional.service.propagation;

import com.hansel.springtransactional.entity.Test;
import com.hansel.springtransactional.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    /*
    MANDATORY
    Support a current transaction, throw an exception if none exists.

    NESTED
    Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise.

    REQUIRED (DEFAULT VALUE)
    Support a current transaction, create a new one if none exists.

    SUPPORTS
    Support a current transaction, execute non-transactional if none exists.
    * */

    @Transactional(propagation = Propagation.REQUIRED)
    public void testRequired() throws RuntimeException {
        for (int i = 0; i < 5; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
        throw new RuntimeException("Ups rollback please");
    }

    /* harus ada transactional sebelumnya agar function ini berjalan agar tidak error */
    @Transactional(propagation = Propagation.MANDATORY)
    public void testMandatory() {
        for (int i = 0; i < 5; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
    }

    /* ga boleh di ada transactional yang berjalan agar function ini berjalan */
    @Transactional(propagation = Propagation.NEVER)
    public void testNever() {
        for (int i = 5; i < 10; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
    }

    /* if error occur at this transaction, this transaction will not be rollback, only the parent transaction get rolled back */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testNotSupported() {
        for (int i = 5; i < 10; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
        throw new RuntimeException("Ups rollback please");
    }

    /* TODO : STILL NOT IMPLEMENTED */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testNew() {
        for (int i = 5; i < 10; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
        throw new RuntimeException("Ups rollback please");
    }
}
