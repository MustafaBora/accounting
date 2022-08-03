package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Spy
    UserRepository userRepository;

    public UserRepositoryTest() {}

    @Test
    public void shouldReturnWithSameValues() {
        Assertions.assertEquals(
            new User("1BIL", BigDecimal.ZERO, "Mustafa Bora", "Simsek", BigDecimal.ZERO),
                userRepository.getUserByCustomerId("1BIL")
        );
    }

    @Test
    public void shouldCreateUserIfNotExist() {
        String nonExistentCustomerId = "ttt";
        BigDecimal initialCredit = new BigDecimal(6);
        userRepository.createUserIfNotExist(new UserDto(nonExistentCustomerId, initialCredit) );
        assertNotNull(userRepository.getUserByCustomerId(nonExistentCustomerId));
        assertEquals(userRepository.getUserByCustomerId(nonExistentCustomerId).getCustomerID(), nonExistentCustomerId);
        assertEquals(userRepository.getUserByCustomerId(nonExistentCustomerId).getBalance(), initialCredit);
    }

}
