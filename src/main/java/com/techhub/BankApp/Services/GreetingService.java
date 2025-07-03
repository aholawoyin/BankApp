package com.techhub.BankApp.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private  final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    public String greet() {

        logger.info("Greeting method called");
        logger.debug("Debugging the greeting method");
        logger.warn("This is a warning message from the greeting method");  
        logger.error("This is an error message from the greeting method");
        // Simulating a greeting message
        // In a real application, this could be a more complex operation            
        return "Greeting from the service";
        

    }
}
// This service can be used to provide greeting messages
// and can be extended to include more complex logic or data retrieval.

