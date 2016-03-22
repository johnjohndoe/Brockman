package info.metadude.java.library.brockman;

import info.metadude.java.library.brockman.models.Offer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

import java.util.List;

public interface StreamsService {

    @GET
    Call<List<Offer>> getOffers(@Url String url);

}
