package io.algostrategy.client.latoken.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Network information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    private String id;
    @JsonProperty("providerName")
    private String name;
    private String currencyProvider;

    @JsonProperty("fee")
    private Double fixedWithdrawFee;
    @JsonProperty("percentFee")
    private Double ratioWithdrawFee;

    private Double minAmount;
    private Double maxAmount;
}
