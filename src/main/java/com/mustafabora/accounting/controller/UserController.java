package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.model.User;
import com.mustafabora.accounting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/userinformation")
@AllArgsConstructor
public class UserController {

    UserService service;

    @PostMapping()
    public void save(@RequestBody User user) {
        service.save(user);
    }   //customerID and initialCredit comes
}
