package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.AccountService;
import com.mustafabora.accounting.service.TransactionsService;
import com.mustafabora.accounting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    UserService userService;
    AccountService accountService;
    TransactionsService transactionsService;

    @PostMapping()
    public String save(@RequestBody UserDto userDto) {

        User user = userService.getByCustomerId(userDto.getCustomerID());

        accountService.save(user.getCustomerID(), user.getInitialCredit());

        return user.getCustomerID();
        //money issues using transactionsService in the future.

    }

}
