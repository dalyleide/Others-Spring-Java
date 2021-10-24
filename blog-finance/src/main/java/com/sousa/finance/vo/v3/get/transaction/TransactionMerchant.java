package com.sousa.finance.vo.v3.get.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionMerchant {

    //Fields for Object TransactionVO
    private String name;

    //Fields for Object Transaction
    private String referenceNo;
    private Float merchantId;
    private String status;
    private String channel;
    private String customData;
    private String chainId;
    private Float agentInfoId;
    private String operation;
    private Float fxTransactionId;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("created_at")
    private String createdAt;
    private Float id;
    private Float acquirerTransactionId;
    private String code;
    private String message;
    private String transactionId;
    private Object agent;

    //Fields for Object TransactionFx
    private Float originalAmount;
    private String originalCurrency;

    @Override
    public String toString() {
        return "TransactionMerchant{" +
                "name='" + name + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", merchantId=" + merchantId +
                ", status='" + status + '\'' +
                ", channel='" + channel + '\'' +
                ", customData='" + customData + '\'' +
                ", chainId='" + chainId + '\'' +
                ", agentInfoId=" + agentInfoId +
                ", operation='" + operation + '\'' +
                ", fxTransactionId=" + fxTransactionId +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id=" + id +
                ", acquirerTransactionId=" + acquirerTransactionId +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", agent=" + agent +
                ", originalAmount=" + originalAmount +
                ", originalCurrency='" + originalCurrency + '\'' +
                '}';
    }
}
