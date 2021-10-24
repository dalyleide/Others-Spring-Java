package com.sousa.finance.vo.v3.report.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    Integer count;
    BigInteger total;
    String currency;

    @Override
    public String toString() {
        return "Report{" +
                "count=" + count +
                ", total=" + total +
                ", currency='" + currency + '\'' +
                '}';
    }
}
