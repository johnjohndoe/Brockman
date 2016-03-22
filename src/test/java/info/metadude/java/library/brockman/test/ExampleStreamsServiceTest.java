package info.metadude.java.library.brockman.test;

import info.metadude.java.library.brockman.ApiModule;
import info.metadude.java.library.brockman.StreamsService;
import info.metadude.java.library.brockman.models.Offer;
import info.metadude.java.library.brockman.models.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Network test using an example data set
 * since the production API is only online at the time of the conference.
 * Assumption: Data format stays the same 8-)
 */
@RunWith(JUnit4.class)
public final class ExampleStreamsServiceTest {

    protected StreamsService streamsService;

    @Before
    public void initStreamService() {
        streamsService = ApiModule.provideStreamsService("https://gist.githubusercontent.com");
    }

    @Test
    public void testThatExampleDataSetIsReadable() {
        Call<List<Offer>> streamsResponseCall = streamsService.getOffers(
                "/johnjohndoe/7c84b77fdbcaa332e4d8/raw/5c0b0f4edfc8e939029b1e539a2ef5757601b205/streams-v1.json"
        );
        try {
            Response<List<Offer>> response = streamsResponseCall.execute();
            if (response.isSuccessful()) {
                List<Offer> offers = response.body();
                // Expect at least some data
                assertThat(offers)
                        .isNotNull()
                        .isNotEmpty();
                for (Offer offer : offers) {
                    testOffer(offer);
                }
            } else {
                fail("GetOffers response is not successful.");
            }
        } catch (IOException e) {
            fail("Should not throw " + e);
        }
    }

    private void testOffer(Offer offer) {
        assertThat(offer).isNotNull();
        // Rooms
        List<Room> rooms = offer.rooms;
        assertThat(rooms)
                .isNotNull()
                .isNotEmpty();
        // Group
        String group = offer.group;
        assertThat(group)
                .isNotNull()
                .isNotEmpty();
    }

}
