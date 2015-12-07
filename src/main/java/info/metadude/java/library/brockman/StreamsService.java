package info.metadude.java.library.brockman;

import info.metadude.java.library.brockman.models.Offer;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Url;

import java.util.List;

public interface StreamsService {

    @GET
    Call<List<Offer>> getOffers(@Url String url);

}
