package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiAsyncRestClient;
import io.algostrategy.client.latoken.LatokenApiClientFactory;
import io.algostrategy.client.latoken.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LatokenApiAsyncRestClientImplTest {

    private final LatokenApiAsyncRestClient latokenApiAsyncRestClient = LatokenApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        List<Asset> assets = latokenApiAsyncRestClient.getAssets().get();
        assertThat(assets, is(not(empty())));
    }
}