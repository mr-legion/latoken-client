package io.algostrategy.client.latoken.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An order.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private Double price;
    private Double quantity;
    private Double cost;
    private Double accumulated;
}
