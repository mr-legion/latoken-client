package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Asset information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    private String id;

    @JsonProperty("tag")
    private String symbol;
    private String name;
    private String description;

    @JsonProperty("logo")
    private String logoUrl;

    private AssetStatus status;
    private AssetType type;
    private AssetClass assetClass;

    private Long tier;
    private Long decimals;
    private Long minTransferAmount;

    private Long created;
}