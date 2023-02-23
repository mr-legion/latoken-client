package io.algostrategy.client.latoken.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String id;

    @JsonProperty("baseCurrency")
    private String baseAssetId;
    @JsonProperty("quoteCurrency")
    private String quoteAssetId;

    private MarketStatus status;

    private Double priceTick;
    private Integer priceDecimals;

    private Double quantityTick;
    private Integer quantityDecimals;

    private Integer costDisplayDecimals;

    private Double minOrderQuantity;
    private Double minOrderCostUsd;
    private Long maxOrderCostUsd;

    private String externalSymbol;

    private Integer popularity;

    private Long created;
}
