package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Spy
    UserRepository userRepository;

    public UserRepositoryTest() {}

    @Test
    public void shouldReturnWithSameValues() {
        Assertions.assertEquals(
                new User("1BIL", BigDecimal.ZERO, "Mustafa Bora", "Simsek", BigDecimal.ZERO),
                userRepository.getUserByCustomerId("1BIL").orElse(null)
        );
    }

    /**
     * Checks if createUserIfNotExist works
     * Note: createUserIfNotExist should not be used anymore
     */
    @Test
    public void shouldCreateUserIfNotExist() {
        String nonExistentCustomerId = "ttt";
        BigDecimal initialCredit = new BigDecimal(6);
        userRepository.createUserIfNotExist(new UserDto(nonExistentCustomerId, initialCredit) );
        assertNotNull(userRepository.getUserByCustomerId(nonExistentCustomerId));
        assertTrue(userRepository.getUserByCustomerId(nonExistentCustomerId).isPresent() );
        assertEquals(userRepository.getUserByCustomerId(nonExistentCustomerId).get().getCustomerID(), nonExistentCustomerId);
        assertEquals(userRepository.getUserByCustomerId(nonExistentCustomerId).get().getBalance(), initialCredit);
    }

    @Test
    public void shouldReturnOptionalNonPresentIfUserDoesNotExist() {
        String nonExistentCustomerId = "nfnf";
        assertFalse(userRepository.getUserByCustomerId(nonExistentCustomerId).isPresent() );
    }

}
