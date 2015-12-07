package info.metadude.java.library.brockman;

import com.squareup.moshi.Moshi;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import info.metadude.java.library.brockman.adapters.StreamAdapter;
import info.metadude.java.library.brockman.adapters.StreamTypeAdapter;
import info.metadude.java.library.brockman.adapters.VideoSizeAdapter;
import retrofit.MoshiConverterFactory;
import retrofit.Retrofit;

import java.util.List;

public final class ApiModule {

    public static StreamsService provideStreamsService(final String baseUrl) {
        return provideStreamsService(baseUrl, null);
    }

    public static StreamsService provideStreamsService(
            final String baseUrl, final List<Interceptor> httpClientInterceptors) {
        return createRetrofit(baseUrl, httpClientInterceptors)
                .create(StreamsService.class);
    }

    private static Retrofit createRetrofit(String baseUrl, List<Interceptor> httpClientInterceptors) {
        OkHttpClient httpClient = new OkHttpClient();
        if (httpClientInterceptors != null) {
            httpClient.interceptors().addAll(httpClientInterceptors);
        }

        Moshi moshi = new Moshi.Builder()
                .add(new StreamTypeAdapter())
                .add(new StreamAdapter())
                .add(new VideoSizeAdapter())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient)
                .build();
    }

}
