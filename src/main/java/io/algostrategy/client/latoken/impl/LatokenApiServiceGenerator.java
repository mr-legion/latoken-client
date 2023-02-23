package io.algostrategy.client.latoken.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.algostrategy.client.latoken.LatokenApiError;
import io.algostrategy.client.latoken.exception.LatokenApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static io.algostrategy.client.latoken.constant.LatokenApiConstants.API_BASE_URL;

/**
 * Generates a Huobi API implementation based on @see {@link LatokenApiService}.
 */
public class LatokenApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, LatokenApiError> errorBodyConverter =
            (Converter<ResponseBody, LatokenApiError>) converterFactory.responseBodyConverter(
                    LatokenApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public LatokenApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                LatokenApiError apiError = getLatokenApiError(response);
                throw new LatokenApiException(apiError);
            }
        } catch (IOException e) {
            throw new LatokenApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static LatokenApiError getLatokenApiError(Response<?> response) throws IOException, LatokenApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
