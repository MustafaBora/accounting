package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
public class AccountController {

    AccountService service;

}
