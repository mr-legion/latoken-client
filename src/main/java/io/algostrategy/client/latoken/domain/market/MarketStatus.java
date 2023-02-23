package io.algostrategy.client.latoken.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    @JsonProperty("PAIR_STATUS_ACTIVE")
    ACTIVE,
    @JsonProperty("PAIR_STATUS_INACTIVE")
    INACTIVE
}
