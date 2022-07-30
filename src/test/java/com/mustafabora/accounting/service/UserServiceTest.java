package com.mustafabora.accounting.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

//    @Mock
//    AccountService accountService;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldReturnNullWhenNotInitialized() {
        Assertions.assertNull( userService.get("customerID"));
    }


}
