package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.exception.CustomerNotFoundException;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Deprecated
    public User save(UserDto userDto) {
        return userRepository.createUserIfNotExist(userDto);
    }

    public User getByCustomerId(String customerId) {
        return userRepository.getUserByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

}
