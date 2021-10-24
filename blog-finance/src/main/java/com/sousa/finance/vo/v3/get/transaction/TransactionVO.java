package com.sousa.finance.vo.v3.get.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVO {

    private String status;
    private String message;
    private Integer code;
    private TransactionFx fx;
    private TransactionCustomerInfo customerInfo;
    private Transaction transaction;
    private TransactionMerchant merchant;

    @Override
    public String toString() {
        return "TransactionVO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", fx=" + fx +
                ", customerInfo=" + customerInfo +
                ", transaction=" + transaction +
                ", merchant=" + merchant +
                '}';
    }
}
