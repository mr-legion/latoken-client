package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiAsyncRestClient;
import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import io.algostrategy.client.latoken.domain.market.OrderBook;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Latoken's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class LatokenApiAsyncRestClientImpl implements LatokenApiAsyncRestClient {

    private final LatokenApiService latokenApiService;

    public LatokenApiAsyncRestClientImpl(LatokenApiService latokenApiService) {
        this.latokenApiService = latokenApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<List<Asset>> getAssets() {
        CompletableFuture<List<Asset>> future = new CompletableFuture<>();
        latokenApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<AssetNetwork>> getAssetNetworks() {
        CompletableFuture<List<AssetNetwork>> future = new CompletableFuture<>();
        latokenApiService.getAssetNetworks().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<List<MarketInfo>> getMarketInfo() {
        CompletableFuture<List<MarketInfo>> future = new CompletableFuture<>();
        latokenApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<MarketTicker>> getMarketTickers() {
        CompletableFuture<List<MarketTicker>> future = new CompletableFuture<>();
        latokenApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<OrderBook> getOrderBook(String baseCurrency, String quoteCurrency, Integer limit) {
        CompletableFuture<OrderBook> future = new CompletableFuture<>();
        latokenApiService.getOrderBook(baseCurrency, quoteCurrency, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
