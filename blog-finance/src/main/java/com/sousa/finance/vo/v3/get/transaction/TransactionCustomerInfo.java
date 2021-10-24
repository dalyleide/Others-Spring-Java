package com.sousa.finance.vo.v3.get.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCustomerInfo {

    private float id;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String startMonth;
    private String startYear;
    private String issueNumber;
    private String email;
    private String birthday;
    private String gender;
    private String billingTitle;
    private String billingFirstName;
    private String billingLastName;
    private String billingCompany;
    private String billingAddress1;
    private String billingAddress2;
    private String billingCity;
    private String billingPostcode;
    private String billingState;
    private String billingCountry;
    private String billingPhone;
    private String billingFax;
    private String shippingTitle;
    private String shippingFirstName;
    private String shippingLastName;
    private String shippingCompany;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingCity;
    private String shippingPostcode;
    private String shippingState;
    private String shippingCountry;
    private String shippingPhone;
    private String shippingFax;

    @Override
    public String toString() {
        return "TransactionCustomerInfo{" +
                "id=" + id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                ", number='" + number + '\'' +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", startMonth='" + startMonth + '\'' +
                ", startYear='" + startYear + '\'' +
                ", issueNumber='" + issueNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", billingTitle='" + billingTitle + '\'' +
                ", billingFirstName='" + billingFirstName + '\'' +
                ", billingLastName='" + billingLastName + '\'' +
                ", billingCompany='" + billingCompany + '\'' +
                ", billingAddress1='" + billingAddress1 + '\'' +
                ", billingAddress2='" + billingAddress2 + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingPostcode='" + billingPostcode + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", billingPhone='" + billingPhone + '\'' +
                ", billingFax='" + billingFax + '\'' +
                ", shippingTitle='" + shippingTitle + '\'' +
                ", shippingFirstName='" + shippingFirstName + '\'' +
                ", shippingLastName='" + shippingLastName + '\'' +
                ", shippingCompany='" + shippingCompany + '\'' +
                ", shippingAddress1='" + shippingAddress1 + '\'' +
                ", shippingAddress2='" + shippingAddress2 + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingPostcode='" + shippingPostcode + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                ", shippingPhone='" + shippingPhone + '\'' +
                ", shippingFax='" + shippingFax + '\'' +
                '}';
    }
}
