package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiClientFactory;
import io.algostrategy.client.latoken.LatokenApiRestClient;
import io.algostrategy.client.latoken.domain.general.Asset;
import io.algostrategy.client.latoken.domain.general.AssetNetwork;
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
}