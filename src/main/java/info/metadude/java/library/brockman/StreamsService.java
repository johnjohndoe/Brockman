package info.metadude.java.library.brockman;

import info.metadude.java.library.brockman.models.Offer;
import retrofit.Call;
import retrofit.http.GET;

import java.util.List;

public interface StreamsService {

    // String BASE_URL = "https://streaming.media.ccc.de";
    String BASE_URL = "https://gist.githubusercontent.com";

    // @GET("/streams/v1.json")
    @GET("/MaZderMind/d5737ab867ade7888cb4/raw/5c0b0f4edfc8e939029b1e539a2ef5757601b205/streams-v1.json")
    Call<List<Offer>> getOffers();

}
