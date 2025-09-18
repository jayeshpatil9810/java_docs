package com.example.pocdemo.account.DTO;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {

    private Long accId;

    @Min(message = "empId is required", value = 1)
    private Long empId;

    @Min(message = "deptId is required", value = 1)
    private String deptId;

    @NotEmpty(message = "orgId is required")
    private String orgId;

    //@Digits(message = "maximum digits in sal should be till 9 digits", integer = 10, fraction = 2)

    @NotEmpty(message = "bankName is required")
    private String bankName;

    @NotEmpty(message = "bankAccNo is required")
    private String bankAccNo;

    @NotEmpty(message = "ifscCode is required")
    private String ifscCode;

}
