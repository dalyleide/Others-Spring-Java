package com.sousa.finance.vo.v3.get.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFx {

    TransactionMerchant merchant;

    @Override
    public String toString() {
        return "TransactionFx{" +
                "merchant=" + merchant +
                '}';
    }
}
