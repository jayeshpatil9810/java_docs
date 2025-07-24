package com.example.pocdemo.account.Service;

import com.example.pocdemo.account.DTO.APIResponse;
import com.example.pocdemo.account.DTO.AccountDto;
import com.example.pocdemo.account.DTO.EmployeeDTO;
import com.example.pocdemo.account.DTO.EmployeeDetailsDto;
import com.example.pocdemo.account.Entity.AccountDetails;
import com.example.pocdemo.account.Repositories.AccountgRepositories;
import com.example.pocdemo.account.exception.ObjectAlreadyExist;
import com.example.pocdemo.account.exception.ObjectNotFoundException;
import com.example.pocdemo.account.feignclient.EmployeeCLient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class AccountServicImpl implements AccountService{

    @Autowired
    AccountgRepositories accRepo;

    @Autowired
    ModelMapper modelMapperObj;

    @Autowired
    EmployeeCLient cLientObj;


    @Override
    public AccountDto createAccountDtlofEmployee(AccountDto req) {
        AccountDetails reqobj = modelMapperObj.map(req,AccountDetails.class);
        Optional<AccountDetails> dbObjOpt = accRepo.findByBankAccNo(reqobj.getBankAccNo());
        AccountDto respObj = null;
        if(!dbObjOpt.isPresent()){
            AccountDetails saveObj = accRepo.save(reqobj);
            respObj = modelMapperObj.map(saveObj, AccountDto.class);
        }else
            throw new ObjectAlreadyExist("The account details of "+req.getEmpId()+" already exist");

        return respObj;
    }

    @CircuitBreaker(name="employeeServiceCircuitBreaker", fallbackMethod = "getEmpByEmpIdFallback")
    @Override
    public EmployeeDetailsDto getAccountDetailsByEmpid(Long empId) {
        Optional<AccountDetails> objOpt = accRepo.findByEmpId(empId);
        EmployeeDetailsDto respObj = null;
        if(objOpt.isPresent()){
            AccountDetails obj = objOpt.get();
            AccountDto accObj = modelMapperObj.map(obj, AccountDto.class);
            ResponseEntity<APIResponse> clientRespObj = cLientObj.getEmployee(empId);
            if(clientRespObj.getStatusCode().equals(HttpStatus.OK) && clientRespObj.hasBody()){
                EmployeeDTO empObj = clientRespObj.getBody().getEmployee();
                if(empObj != null) {
                    respObj = new EmployeeDetailsDto();
                    respObj.setEmpObj(empObj);
                }
            }
            respObj.setAccObj(accObj);
        }else
            throw new ObjectNotFoundException("The account details of "+empId+" does not exist");

        return respObj;
    }

    public EmployeeDetailsDto getEmpByEmpIdFallback(Throwable obj){
        EmployeeDetailsDto empObj = new EmployeeDetailsDto();
        //AccountDto acc = new AccountDto();
       // acc.setEmpId(new Long(1));
        //acc.setBankName();
        //empObj.setAccObj(acc);
        return empObj;
    }

}
