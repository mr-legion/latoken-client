package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;

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
}