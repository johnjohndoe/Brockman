package info.metadude.java.library.brockman;

import com.squareup.moshi.Moshi;
import info.metadude.java.library.brockman.adapters.StreamAdapter;
import info.metadude.java.library.brockman.adapters.StreamTypeAdapter;
import info.metadude.java.library.brockman.adapters.VideoSizeAdapter;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public final class ApiModule {

    public static StreamsService provideStreamsService(final String baseUrl) {
        return provideStreamsService(baseUrl, null);
    }

    public static StreamsService provideStreamsService(
            final String baseUrl, final OkHttpClient okHttpClient) {
        return createRetrofit(baseUrl, okHttpClient)
                .create(StreamsService.class);
    }

    private static Retrofit createRetrofit(String baseUrl, OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }

        Moshi moshi = new Moshi.Builder()
                .add(new StreamTypeAdapter())
                .add(new StreamAdapter())
                .add(new VideoSizeAdapter())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build();
    }

}
