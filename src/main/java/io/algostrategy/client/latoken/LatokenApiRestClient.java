package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.domain.general.Asset;

import java.util.List;

/**
 * Latoken API facade, supporting synchronous/blocking access Latoken's REST API.
 */
public interface LatokenApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    List<Asset> getAssets();
}