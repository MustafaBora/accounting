package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.*;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.AccountService;
import com.mustafabora.accounting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
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
        OutputDTO outputDTO =
                new OutputDTO(customerId, user.getInitialCredit(), user.getName(), user.getSurname(), new ArrayList<>());
        RestTemplate restTemplate = new RestTemplate();
        for (Account account : accounts) {
            List<TransactionDTO> transactionList =
                    restTemplate.getForObject(
                            "http://localhost:8080/api/v1/transaction/transactionsByAccountId/" + account.getAccountId(),
                            List.class);
            AccountInfo accountInfo = new AccountInfo(customerId, account.getAccountId(), account.getBalance(), transactionList);
            outputDTO.getAccounts().add(accountInfo);
        }
        return outputDTO;
    }

    @GetMapping(value = "/accountIds/{customerId}")
    public List<String> getAccountIds(@PathVariable String customerId) {
        return accountService.getAccountIdsByCustomerId(customerId);
    }



}
