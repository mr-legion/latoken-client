package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiAsyncRestClient;
import io.algostrategy.client.latoken.LatokenApiClientFactory;
import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
import io.algostrategy.client.latoken.domain.market.MarketInfo;
import io.algostrategy.client.latoken.domain.market.MarketTicker;
import io.algostrategy.client.latoken.domain.market.OrderBook;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LatokenApiAsyncRestClientImplTest {

    private final LatokenApiAsyncRestClient latokenApiAsyncRestClient = LatokenApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        List<Asset> assets = latokenApiAsyncRestClient.getAssets().get();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getAssetNetworks_ShouldReturnAssetNetworks() throws ExecutionException, InterruptedException {
        List<AssetNetwork> assetNetworks = latokenApiAsyncRestClient.getAssetNetworks().get();
        assertThat(assetNetworks, is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        List<MarketInfo> marketInfo = latokenApiAsyncRestClient.getMarketInfo().get();
        assertThat(marketInfo, is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        List<MarketTicker> marketTickers = latokenApiAsyncRestClient.getMarketTickers().get();
        assertThat(marketTickers, is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        OrderBook orderBook = latokenApiAsyncRestClient.getOrderBook("BTC", "USDT", 10).get();
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }
}