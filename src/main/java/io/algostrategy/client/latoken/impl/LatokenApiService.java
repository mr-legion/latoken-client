package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import io.algostrategy.client.latoken.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Latoken's REST API URL mappings.
 */
public interface LatokenApiService {

    // General endpoints

    @GET("/v2/currency")
    Call<List<Asset>> getAssets();

    @GET("/v2/transaction/bindings")
    Call<List<AssetNetwork>> getAssetNetworks();

    // Market endpoints

    @GET("/v2/pair")
    Call<List<MarketInfo>> getMarketInfo();

    @GET("/v2/ticker")
    Call<List<MarketTicker>> getMarketTickers();

    @GET("/v2/book/{baseCurrency}/{quoteCurrency}")
    Call<OrderBook> getOrderBook(@Path("baseCurrency") String baseCurrency,
                                 @Path("quoteCurrency") String quoteCurrency,
                                 @Query("limit") Integer limit);
}
