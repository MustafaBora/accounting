package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.OutputDTO;
import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.AccountService;
import com.mustafabora.accounting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  accounting profile is the default active profile
 */
@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
@Profile("accounting")
public class AccountController {

    UserService userService;
    AccountService accountService;

    @PostMapping()
    public String save(@RequestBody UserDto userDto) {

        User user = userService.getByCustomerId(userDto.getCustomerID());

        Account acc = accountService.save(user.getCustomerID(), userDto.getInitialCredit());

        accountService.firstTransaction(acc, userDto.getInitialCredit());

        return acc.getAccountId();
    }


    @GetMapping(value = "/{accountId}")
    public Account getByAccountId(@PathVariable String accountId) {
        return accountService.getByAccountId(accountId);
    }

    @GetMapping(value = "getByCustomerId/{customerId}")
    public OutputDTO getByCustomerId(@PathVariable String customerId) {

        List<Account> accounts = accountService.getByCustomerId(customerId);
        User user = userService.getByCustomerId(customerId);

        return userService.prepareOutputDTO(user, accounts);
    }

    @GetMapping(value = "/accountIds/{customerId}")
    public List<String> getAccountIds(@PathVariable String customerId) {
        return accountService.getAccountIdsByCustomerId(customerId);
    }

}
