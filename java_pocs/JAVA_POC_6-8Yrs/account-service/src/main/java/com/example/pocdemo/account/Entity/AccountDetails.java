package com.example.pocdemo.account.Entity;


import lombok.Data;
import javax.persistence.*;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name="Account_details")
public class AccountDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="acc_id", nullable = false, unique = false)
    private Long accId;

    @Column(name="emp_id", nullable = false)
    private Long empId;

    @Column(name="dept_id", nullable = false)
    private String deptId;

    @Column(name="org_id", nullable = false)
    private String orgId;

    @Column(name="bank_name", nullable = false)
    private String bankName;

    @Column(name="bank_acc_no", nullable = false)
    private String bankAccNo;

    @Column(name="ifsc_code", nullable = false)
    private String ifscCode;



}
