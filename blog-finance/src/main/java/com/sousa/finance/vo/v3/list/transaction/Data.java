package com.sousa.finance.vo.v3.list.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private Object fx;
    private Object customerInfo;
    private Object merchant;
    private Object ipn;
    private Object transaction;
    private Object acquirer;
    private Boolean refundable;

    @Override
    public String toString() {
        return "Data{" +
                "fx=" + fx +
                ", customerInfo=" + customerInfo +
                ", merchant=" + merchant +
                ", ipn=" + ipn +
                ", transaction=" + transaction +
                ", acquirer=" + acquirer +
                ", refundable=" + refundable +
                '}';
    }
}