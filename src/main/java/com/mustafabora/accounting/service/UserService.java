package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.AccountInfo;
import com.mustafabora.accounting.dto.OutputDTO;
import com.mustafabora.accounting.dto.TransactionDTO;
import com.mustafabora.accounting.dto.UserDto;
import com.mustafabora.accounting.exception.CustomerNotFoundException;
import com.mustafabora.accounting.exception.TransactionServiceNotUpException;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private static final String TRANSACTIONS_BY_ACCOUNT_ID = "http://localhost:8081/api/v1/transaction/transactionsByAccountId/";
    private final UserRepository userRepository;

    @Deprecated
    public User save(UserDto userDto) {
        return userRepository.createUserIfNotExist(userDto);
    }

    public User getByCustomerId(String customerId) {
        return userRepository.getUserByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public OutputDTO prepareOutputDTO(User user, List<Account> accounts) {
        OutputDTO outputDTO = new OutputDTO(user.getCustomerID(),
                user.getInitialCredit(), user.getName(), user.getSurname(), new ArrayList<>());
        RestTemplate restTemplate = new RestTemplate();
        for (Account account : accounts) {
            try {
                List<TransactionDTO> transactionList =
                        restTemplate.getForObject(
                                TRANSACTIONS_BY_ACCOUNT_ID + account.getAccountId(),
                                List.class);
                AccountInfo accountInfo = new AccountInfo(user.getCustomerID(),
                        account.getAccountId(), account.getBalance(), transactionList);
                outputDTO.getAccountInfos().add(accountInfo);
            }
            catch (RestClientException restClientException) {
                throw new TransactionServiceNotUpException("Transactions could not be get by account number" + account.getAccountId());
            }

        }
        return outputDTO;

    }
}
