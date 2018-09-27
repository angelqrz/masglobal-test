package com.masglobal.test.contract;

import java.math.BigDecimal;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public abstract class Employee {
    private int id;
    private String name;
    private String contractTypeName;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private BigDecimal hourlySalary;
    private BigDecimal monthlySalary;
    private BigDecimal annualSalary;

    public Employee() {
    }

    public Employee(int id, String name, String contractTypeName, int roleId, String roleName,
            String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
        this.id = id;
        this.name = name;
        this.contractTypeName = contractTypeName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.hourlySalary = hourlySalary;
        this.monthlySalary = monthlySalary;
        this.calculateAnnualSalary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public BigDecimal getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(BigDecimal hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public abstract void calculateAnnualSalary();

    @Override public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contractTypeName='" + contractTypeName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", hourlySalary=" + hourlySalary +
                ", monthlySalary=" + monthlySalary +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
