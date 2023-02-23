package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import io.algostrategy.client.latoken.domain.market.OrderBook;

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

    /**
     * Get all asset networks.
     *
     * @return assets networks
     */
    List<AssetNetwork> getAssetNetworks();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    List<MarketInfo> getMarketInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    List<MarketTicker> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param baseCurrency  base currency id or symbol.
     * @param quoteCurrency quote currency id or symbol.
     * @param limit         depth of the order book. The default value is 200.
     * @return orderbook
     */
    OrderBook getOrderBook(String baseCurrency, String quoteCurrency, Integer limit);
}