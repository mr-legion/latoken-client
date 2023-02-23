package io.algostrategy.client.latoken.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market orderbook.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {

    @JsonProperty("ask")
    private List<Order> asks;
    @JsonProperty("bid")
    private List<Order> bids;

    private Double totalAsk;
    private Double totalBid;
}
