package io.algostrategy.client.latoken.impl;

import io.algostrategy.client.latoken.LatokenApiError;
import io.algostrategy.client.latoken.exception.LatokenApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.algostrategy.client.latoken.impl.LatokenApiServiceGenerator.getLatokenApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                LatokenApiError apiError = getLatokenApiError(response);
                onFailure(call, new LatokenApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new LatokenApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof LatokenApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new LatokenApiException(t));
        }
    }
}
