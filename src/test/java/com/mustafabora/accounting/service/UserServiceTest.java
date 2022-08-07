package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.exception.CustomerNotFoundException;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("should save but it's deprecated. Will be removed")
    public void shouldSave() {
        UserDto userDto = new UserDto("10", BigDecimal.TEN);
        User user = new User("10", BigDecimal.TEN, null, null, null);
        Mockito.when(repository.createUserIfNotExist(userDto))
                .thenReturn(user);
        User saved = service.save(userDto);
        Assertions.assertEquals(saved.getCustomerID(), userDto.getCustomerID());
        Assertions.assertEquals(saved.getInitialCredit(), userDto.getInitialCredit());
    }


    @Test(expected = CustomerNotFoundException.class)
    public void shouldThrow404CustomerNotFoundIfUserDoesNotExist() {
        String nonExistentCustomerId = "nfnf";
        service.getByCustomerId(nonExistentCustomerId);
    }

}
