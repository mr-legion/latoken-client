package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.domain.general.Asset;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Latoken API facade, supporting asynchronous/non-blocking access Latoken's REST API.
 */
public interface LatokenApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<List<Asset>> getAssets();
}