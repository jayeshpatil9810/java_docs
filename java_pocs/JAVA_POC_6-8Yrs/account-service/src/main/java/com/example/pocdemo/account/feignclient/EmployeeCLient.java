package com.example.pocdemo.account.feignclient;


import com.example.pocdemo.account.DTO.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service", path = "/employee-service/api/employee", url = "http://localhost:8081")
public interface EmployeeCLient {

    @GetMapping("/getempbyid/{emp-id}")
    public ResponseEntity<APIResponse> getEmployee(@PathVariable("emp-id") @NonNull Long empId);

}
