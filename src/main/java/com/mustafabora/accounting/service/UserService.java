package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserDto userDto) {
        return userRepository.createUserIfNotExist(userDto);
    }

}
