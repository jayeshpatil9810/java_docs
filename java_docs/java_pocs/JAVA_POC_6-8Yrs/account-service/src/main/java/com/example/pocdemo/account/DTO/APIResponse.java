package com.example.pocdemo.account.DTO;

import lombok.Data;

@Data
public class APIResponse {
    private EmployeeDTO employee;
    private DepartmentDTO department;
    private OrganizationDto organizationDto;

}
