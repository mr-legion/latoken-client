package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AssetType {
    @JsonProperty("CURRENCY_TYPE_CRYPTO")
    CRYPTO,
    @JsonProperty("CURRENCY_TYPE_IEO")
    IEO,
    @JsonProperty("CURRENCY_TYPE_ALTERNATIVE")
    ALTERNATIVE
}
