package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.OutputDTO;
import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.model.Transaction;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.AccountService;
import com.mustafabora.accounting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping(value = "/{customerId}")
    public OutputDTO getByCustomerId(@PathVariable String customerId) {
        /* pre CPG-007
        List<Account> byCustomerId = accountService.getByCustomerId(customerId);

        RestTemplate restTemplate = new RestTemplate();

        List<Transaction> transactionList = restTemplate.getForObject("http://localhost:8080/api/v1/transaction/transactions/" + customerId, List.class);

        OutputDTO outputDTO = OutputDTO.builder()
                .customerID(customerId)
                .;

*/
        return null;
    }

    @GetMapping(value = "/accountIds/{customerId}")
    public List<String> getAccountIds(@PathVariable String customerId) {
        return accountService.getAccountIdsByCustomerId(customerId);
    }

}
