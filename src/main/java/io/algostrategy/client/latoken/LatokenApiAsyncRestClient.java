package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import io.algostrategy.client.latoken.domain.market.OrderBook;

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

    /**
     * Get all asset networks (asynchronous).
     *
     * @return assets networks
     */
    CompletableFuture<List<AssetNetwork>> getAssetNetworks();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<List<MarketInfo>> getMarketInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<List<MarketTicker>> getMarketTickers();

    /**
     * Get orderbook for the market (asynchronous).
     *
     * @param baseCurrency  base currency id or symbol.
     * @param quoteCurrency quote currency id or symbol.
     * @param limit         depth of the order book. The default value is 200.
     * @return orderbook
     */
    CompletableFuture<OrderBook> getOrderBook(String baseCurrency, String quoteCurrency, Integer limit);
}