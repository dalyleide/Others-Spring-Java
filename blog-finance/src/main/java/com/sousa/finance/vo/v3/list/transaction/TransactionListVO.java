package com.sousa.finance.vo.v3.list.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionListVO {

    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("next_page_url")
    private String nextPageUrl;
    @JsonProperty("prev_page_url")
    private String prevPageUrl;
    @JsonProperty("from")
    private Integer from;
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("data")
    private Collection<Data> data;

    @Override
    public String toString() {
        return "TransactionListVO{" +
                "perPage=" + perPage +
                ", currentPage=" + currentPage +
                ", nextPageUrl='" + nextPageUrl + '\'' +
                ", prevPageUrl='" + prevPageUrl + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", data=" + data +
                '}';
    }
}
