package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.exception.CustomerNotFoundException;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.AccountService;
import com.mustafabora.accounting.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    UserService userService;

    @Mock
    AccountService accountService;

    @InjectMocks
    AccountController accountController;

    private final String existentCustomerId = "1BIL";
    private final UserDto existentUserDto = new UserDto(existentCustomerId, BigDecimal.ZERO);
    private final User existentUser = new User(existentCustomerId, BigDecimal.ZERO, "Mustafa Bora", "Simsek", BigDecimal.ZERO);

    private final String nonExistentCustomerId = "yyyy";
    private final UserDto nonExistentUserDto = new UserDto(nonExistentCustomerId, BigDecimal.ZERO);

    @Test
    public void shouldReturnAccountIdWhenSuccess() {
        when(userService.getByCustomerId(anyString()))
                .thenReturn(existentUser);
        Assertions.assertNotNull(accountController.save(existentUserDto));
    }

    @Test(expected = CustomerNotFoundException.class)
    public void shouldReturnNotFoundWhenFail() {
        when(userService.getByCustomerId(nonExistentCustomerId))
                .thenThrow(new CustomerNotFoundException("Iron Man doesn't exist"));
        accountController.save(nonExistentUserDto);
    }
}
