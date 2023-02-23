package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Asset networks information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetNetwork {

    @JsonProperty("id")
    private String assetId;
    @JsonProperty("tag")
    private String assetSymbol;

    @JsonProperty("bindings")
    private List<Network> networks;
}
