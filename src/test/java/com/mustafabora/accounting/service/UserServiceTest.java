package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
    public void shouldSave() {
        UserDto userDto = new UserDto("10", BigDecimal.TEN);
        User user = new User("10", BigDecimal.TEN, null, null, null);
        Mockito.when(repository.createUserIfNotExist(userDto))
                .thenReturn(user);
        User save = service.save(userDto);
        Assertions.assertEquals(user.getCustomerID(), userDto.getCustomerID());
        Assertions.assertEquals(user.getInitialCredit(), userDto.getInitialCredit());
    }

}
