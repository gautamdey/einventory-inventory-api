package com.technath.einventory.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_supplier")
public class Supplier {
    @Id
    @Column(name = "supplierid")
    private long supplierId;

    @Column(name = "suppliername")
    private String supplierName;

    @Column(name = "accountnumber")
    private String accountNumber;

    @Column(name = "accountname")
    private String accountName;

    @Column(name = "ifcsCode")
    private String ifcsCode;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "bankBranch")
    private String bankBranch;

    @Column(name = "email")
    private String email;

    @Column(name = "contactperson")
    private String contactPerson;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIfcsCode() {
        return ifcsCode;
    }

    public void setIfcsCode(String ifcsCode) {
        this.ifcsCode = ifcsCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

}

