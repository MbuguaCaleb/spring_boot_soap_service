package com.codewithcaleb.springbootsoap.api.endpoint;


import com.codewithcaleb.springbootsoap.api.loaneligibility.Acknowledgement;
import com.codewithcaleb.springbootsoap.api.loaneligibility.CustomerRequest;
import com.codewithcaleb.springbootsoap.api.service.LoanEligibilityService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoadEligibilityIndicatorEndpoint {

    private static final String NAMESPACE ="http://www.codewithcaleb.com/springbootsoap/api/loanEligibility";


    private  final LoanEligibilityService loanEligibilityService;

    public LoadEligibilityIndicatorEndpoint(LoanEligibilityService loanEligibilityService) {
        this.loanEligibilityService = loanEligibilityService;
    }

    @PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return loanEligibilityService.checkLoanEligibility(request);
    }
}
