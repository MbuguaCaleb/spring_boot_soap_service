package com.codewithcaleb.springbootsoap.api.service;

import com.codewithcaleb.springbootsoap.api.loaneligibility.Acknowledgement;
import com.codewithcaleb.springbootsoap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoanEligibilityService {

    //Response Endpoint after submitting Loan Eligibility Request
    public Acknowledgement checkLoanEligibility(CustomerRequest request){
        Acknowledgement acknowledgement = new Acknowledgement();

        //xml response for mismatch
        //it is an Object that i will put my data when there is a mismatch
       // List<String> mismatchCriteriaList = new ArrayList<>();

        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        int minimumIncome = 200000;
        int cibilScore = 500;

        if(!(request.getAge() > 30 && request.getAge() <=60)){
            mismatchCriteriaList.add("Person age should be between 30 to 60");
        }
        if(!(request.getYearlyIncome() > minimumIncome)){
            mismatchCriteriaList.add("Minimum income should be more than"+ minimumIncome);
        }
        if(!(request.getCibilScore() > cibilScore)){
            mismatchCriteriaList.add("Cibilscore  should be more than"+ cibilScore);
        }

        if(mismatchCriteriaList.size() > 0){
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }else{
            acknowledgement.setApprovedAmount(50000);
            acknowledgement.setIsEligible(true);
        }

        return acknowledgement;
    }
}
