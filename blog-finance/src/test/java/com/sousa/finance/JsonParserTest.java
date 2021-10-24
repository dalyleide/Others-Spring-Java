package com.sousa.finance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sousa.finance.vo.v3.client.ClientVO;
import com.sousa.finance.vo.v3.get.transaction.TransactionVO;
import com.sousa.finance.vo.v3.list.transaction.TransactionListVO;
import com.sousa.finance.vo.v3.report.transaction.TransactionReportVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.fail;

@Slf4j
class JsonParserTest {

//    @Test
    void shouldParseTransactionReport(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-report.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TransactionReportVO transactionReportResposeVO;
        try {
            transactionReportResposeVO = objectMapper.readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()), TransactionReportVO.class);
            assertThat(transactionReportResposeVO.getStatus()).isEqualTo("APPROVED");
            assertThat(transactionReportResposeVO.getReports().size()).isEqualTo(2);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
        }
    }

//    @Test
    void shouldParseTransactionList(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-list.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TransactionListVO transactionListVO = objectMapper.readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()),
                            TransactionListVO.class);
            assertThat(transactionListVO.getPerPage()).isEqualTo(50);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
        }
    }

//    @Test
    void shouldParseClientGet(){
        Path resourceDirectory = Paths.get("src","test","resources","client-get.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClientVO clientVO = objectMapper.readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()), ClientVO.class);
            assertThat(clientVO.getCustomerInfo().getNumber()).isEqualTo("401288XXXXXX1881");
            assertThat(clientVO.getCustomerInfo().getEmail()).isEqualTo("michael@gmail.com");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
        }
    }

//    @Test
    void shouldParseTransactionGet(){
        Path resourceDirectory = Paths.get("src","test","resources","transaction-get.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TransactionVO transactionVO = objectMapper.readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()), TransactionVO.class);
            assertThat(transactionVO.getCustomerInfo().getNumber()).isEqualTo("401288XXXXXX1881");
            assertThat(transactionVO.getFx().getMerchant().getOriginalCurrency()).isEqualTo("EUR");
            assertThat(transactionVO.getMerchant().getName()).isEqualTo("Dev-Merchant");
            assertThat(transactionVO.getTransaction().getMerchant().getReferenceNo()).isEqualTo("reference_5617ae66281ee");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
        }
    }
}
