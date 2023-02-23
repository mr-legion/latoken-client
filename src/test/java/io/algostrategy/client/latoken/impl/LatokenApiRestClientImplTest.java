package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiClientFactory;
import io.algostrategy.client.latoken.LatokenApiRestClient;
import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LatokenApiRestClientImplTest {

    private final LatokenApiRestClient latokenApiRestClient = LatokenApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = latokenApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getAssetNetworks_ShouldReturnAssetNetworks() {
        List<AssetNetwork> assetNetworks = latokenApiRestClient.getAssetNetworks();
        assertThat(assetNetworks, is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        List<MarketInfo> marketInfo = latokenApiRestClient.getMarketInfo();
        assertThat(marketInfo, is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        List<MarketTicker> marketTickers = latokenApiRestClient.getMarketTickers();
        assertThat(marketTickers, is(not(empty())));
    }
}