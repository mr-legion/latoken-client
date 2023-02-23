package io.algostrategy.client.latoken;

import io.algostrategy.client.latoken.impl.LatokenApiAsyncRestClientImpl;
import io.algostrategy.client.latoken.impl.LatokenApiRestClientImpl;
import io.algostrategy.client.latoken.impl.LatokenApiService;
import io.algostrategy.client.latoken.impl.LatokenApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Latoken API client objects.
 */
public class LatokenApiClientFactory {

    private final LatokenApiServiceGenerator serviceGenerator;

    public LatokenApiClientFactory() {
        this.serviceGenerator = new LatokenApiServiceGenerator(new OkHttpClient());
    }

    public LatokenApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public LatokenApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new LatokenApiServiceGenerator(newClient);
    }

    /**
     * New instance without authentication.
     *
     * @return the Latoken API client factory
     */
    public static LatokenApiClientFactory newInstance() {
        return new LatokenApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public LatokenApiRestClient newRestClient() {
        return new LatokenApiRestClientImpl(serviceGenerator.createService(LatokenApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public LatokenApiAsyncRestClient newAsyncRestClient() {
        return new LatokenApiAsyncRestClientImpl(serviceGenerator.createService(LatokenApiService.class));
    }
}
