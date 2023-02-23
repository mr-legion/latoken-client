package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiRestClient;
import io.algostrategy.client.latoken.domain.general.Asset;

import java.util.List;

/**
 * Implementation of Latoken's REST API using Retrofit with synchronous/blocking method calls.
 */
public class LatokenApiRestClientImpl implements LatokenApiRestClient {

    private final LatokenApiService latokenApiService;

    public LatokenApiRestClientImpl(LatokenApiService latokenApiService) {
        this.latokenApiService = latokenApiService;
    }

    // General endpoints

    @Override
    public List<Asset> getAssets() {
        return LatokenApiServiceGenerator.executeSync(latokenApiService.getAssets());
    }
}
