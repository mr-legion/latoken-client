package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AssetClass {
    @JsonProperty("ASSET_CLASS_UNKNOWN")
    UNKNOWN
}
