package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AssetStatus {
    @JsonProperty("CURRENCY_STATUS_ACTIVE")
    ACTIVE,
    @JsonProperty("CURRENCY_STATUS_INACTIVE")
    INACTIVE
}
