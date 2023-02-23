package io.algostrategy.client.latoken.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private String symbol;

    @JsonProperty("baseCurrency")
    private String baseAssetId;
    @JsonProperty("quoteCurrency")
    private String quoteAssetId;

    private Double lastPrice;
    private Double lastQuantity;

    @JsonProperty("bestAsk")
    private Double ask;
    @JsonProperty("bestAskQuantity")
    private Double askQuantity;
    @JsonProperty("bestBid")
    private Double bid;
    @JsonProperty("bestBidQuantity")
    private Double bidQuantity;

    private Double volume24h;
    private Double volume7d;

    private Double change24h;
    private Double change7d;

    private Double amount24h;
    private Double amount7d;

    @JsonProperty("updateTimestamp")
    private Long updated;
}
