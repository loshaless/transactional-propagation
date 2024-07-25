package com.hansel.springtransactional.service.propagation;

import com.hansel.springtransactional.entity.Test;
import com.hansel.springtransactional.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequiresNewService {
    private final TestService testService;
    private final TestRepository testRepository;

   /* REQUIRES_NEW
    Create a new transaction, and suspend the current transaction if one exists.
*/
    @Transactional
    public void testNew() {
        for (int i = 0; i < 5; i++) {
            Test test = new Test();
            test.setName("test " + i);
            testRepository.save(test);
        }
        testService.testNew();
    }
}
