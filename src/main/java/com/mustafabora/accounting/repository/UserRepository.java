package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {


    private final Map<String, User> userMap = new HashMap<>();

    public UserRepository() {
        //create initial users
        userMap.put("1BIL", new User("1BIL", BigDecimal.ZERO, "Mustafa Bora", "Simsek", BigDecimal.ZERO) );
        userMap.put("2CYB", new User("2CYB", BigDecimal.TEN, "Nigar", "Simsek", BigDecimal.TEN) );
        userMap.put("3HVL", new User("3HVL", BigDecimal.ONE, "Nusret", "Simsek", BigDecimal.ONE) );
        userMap.put("4CGM", new User("4CGM", BigDecimal.ZERO, "Baran", "Simsek", BigDecimal.ZERO) );
    }

    public User getUserByCustomerId(String customerID) {
        return userMap.get(customerID);
    }

    public User createUserIfNotExist(UserDto userDto) {
        if(userMap.get(userDto.getCustomerID()) == null)
            userMap.put(userDto.getCustomerID(), new User(userDto.getCustomerID(), userDto.getInitialCredit(), "", "", userDto.getInitialCredit()));
        return userMap.get(userDto.getCustomerID());
    }
}
