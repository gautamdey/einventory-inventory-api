package com.technath.einventory.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName(value = "supplier")
@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDTO {

    @XmlElement(name = "supplierid")
    @JsonProperty("supplierid")
    private long supplierId;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String supplierName;

    @XmlElement(name = "accountnumber")
    @JsonProperty("accountnumber")
    private String accountNumber;

    @XmlElement(name = "acccountname")
    @JsonProperty("acccountname")
    private String accountName;

    @XmlElement(name = "ifcsCode")
    @JsonProperty("ifcsCode")
    private String ifcsCode;

    @XmlElement(name = "bankname")
    @JsonProperty("bankname")
    private String bankName;

    @XmlElement(name = "bankbranch")
    @JsonProperty("bankbranch")
    private String bankBranch;

    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;

    @XmlElement(name = "contactperson")
    @JsonProperty("contactperson")
    private String contactPerson;

    @XmlElement(name = "phone1")
    @JsonProperty("phone1")
    private String phone1;

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
}
