package com.sousa.finance.vo.v3.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientVO {

   private String status;
   private String message;
   private CustomerInfo customerInfo;

   @Override
   public String toString() {
      return "ClientVO{" +
              "status='" + status + '\'' +
              ", message='" + message + '\'' +
              ", customerInfo=" + customerInfo +
              '}';
   }
}
