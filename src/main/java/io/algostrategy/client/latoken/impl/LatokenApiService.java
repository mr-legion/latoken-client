package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.domain.general.Asset;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Latoken's REST API URL mappings.
 */
public interface LatokenApiService {

    // General endpoints

    @GET("/v2/currency")
    Call<List<Asset>> getAssets();
}
