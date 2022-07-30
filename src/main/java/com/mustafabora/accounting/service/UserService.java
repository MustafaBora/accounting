package com.mustafabora.accounting.service;

import com.mustafabora.accounting.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {

    private final Map<String, User> userMap = new HashMap<>();

    private final AccountService accountService;

    public void save(User user) {   //customerID and initialCredit comes
        userMap.put(user.getCustomerID(), user);
        accountService.save(user.getCustomerID());
        if(user.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            accountService.setBalance(user.getCustomerID(), user.getInitialCredit());
        }
        //if initialCredit > 0 transaction ile yeni accounta para yolla
    }

    public User get(String customerID) {
        return userMap.get(customerID);
    }

}
