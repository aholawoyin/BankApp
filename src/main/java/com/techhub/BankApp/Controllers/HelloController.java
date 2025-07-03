package com.techhub.BankApp.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.techhub.BankApp.Services.*;

@RestController
public class HelloController {

    private final GreetingService _greetingService;

    public HelloController(GreetingService greetingService) {
        this._greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String Greeting() {
        return _greetingService.greet();
    }
}
