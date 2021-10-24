package com.sousa.finance.vo.v3.report.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionReportVO {

    private String status;
    private String message;
    private Integer code;
    @JsonProperty("response")
    private ArrayList<Report> reports;

    @Override
    public String toString() {
        return "TransactionReportVO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", reports=" + reports +
                '}';
    }
}
