package com.example.pocdemo.account.controller;

import com.example.pocdemo.account.DTO.AccountDto;
import com.example.pocdemo.account.DTO.EmployeeDetailsDto;
import com.example.pocdemo.account.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@RestController
public class AccountController {

    @Autowired
    public AccountService accServiceObj;


    @GetMapping("/getaccdtlbyempid")
    public ResponseEntity<EmployeeDetailsDto> getAccountDetailsByEmpid(@NotEmpty @RequestParam("empId") Long empId){
        EmployeeDetailsDto resp = accServiceObj.getAccountDetailsByEmpid(empId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/createaccdtl")
    public ResponseEntity<AccountDto> createAccountDtlofEmployee(
            @Valid @RequestBody AccountDto req){
        AccountDto resp = accServiceObj.createAccountDtlofEmployee(req);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
}
