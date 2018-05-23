package com.tangbaobao.pojo;

import java.util.Date;
import java.util.List;

/**
 * Emp表
 *
 * @author 唐学俊
 * @create 2018/02/05
 * <p>
 * `emp_id` varchar(50) DEFAULT NULL,
 * `empName` varchar(15) DEFAULT NULL,
 * `empPassword` varchar(15) DEFAULT NULL,
 * `birthday` date DEFAULT NULL,
 **/

public class Emp {
    private String empId;
    private String empName;
    private String empPassword;
    private Date birthday;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 一对多
     */
    private List<Exp> expList;


    public List<Exp> getExpList() {
        return expList;
    }

    public void setExpList(List<Exp> expList) {
        this.expList = expList;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", expList=" + expList +
                '}';
    }
}
