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

    public Double getMinFixedWithdrawFee() {

        Double minFee = null;

        for (Network network : networks) {
            Double fee = network.getFixedWithdrawFee();
            if (minFee == null || (fee != null && fee < minFee)) {
                minFee = fee;
            }
        }

        return minFee;
    }

    public Double getMinRatioWithdrawFee() {

        Double minFee = null;

        for (Network network : networks) {
            Double fee = network.getRatioWithdrawFee();
            if (minFee == null || (fee != null && fee < minFee)) {
                minFee = fee;
            }
        }

        return minFee;
    }
}
