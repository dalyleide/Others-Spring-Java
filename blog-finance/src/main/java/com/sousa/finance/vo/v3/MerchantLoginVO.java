package com.sousa.finance.vo.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantLoginVO {

    String token;
    String status;

    @Override
    public String toString() {
        return "MerchantLoginVO{" +
                "token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
