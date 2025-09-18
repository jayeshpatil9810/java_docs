package com.example.pocdemo.account.Service;

import com.example.pocdemo.account.DTO.AccountDto;
import com.example.pocdemo.account.DTO.EmployeeDetailsDto;

public interface AccountService {

    EmployeeDetailsDto getAccountDetailsByEmpid(Long empId);

    AccountDto createAccountDtlofEmployee(AccountDto req);
}
