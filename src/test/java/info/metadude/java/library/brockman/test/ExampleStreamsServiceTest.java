package info.metadude.java.library.brockman.test;

import info.metadude.java.library.brockman.ApiModule;
import info.metadude.java.library.brockman.StreamsService;
import info.metadude.java.library.brockman.models.Group;
import info.metadude.java.library.brockman.models.Offer;
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

    private StreamsService streamsService;

    @Before
    public void initStreamService() {
        streamsService = ApiModule.provideStreamsService("https://gist.githubusercontent.com");
    }

    @Test
    public void testThatExampleDataSetIsReadable() {
        Call<List<Offer>> streamsResponseCall = streamsService.getOffers(
                "/johnjohndoe/617bbfa2ac36f5148a049548b419e299/raw/7ab4e206f19ed4d63a67917fe6e3a15a96218ac9/streams-v2.json"
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
        // Offer
        assertThat(offer).isNotNull();
        assertThat(offer.author).isNotNull();
        assertThat(offer.conference).isNotNull();
        assertThat(offer.description).isNotNull();
        assertThat(offer.endsAt).isNotNull();
        assertThat(offer.keywords).isNotNull();
        assertThat(offer.slug).isNotNull();
        assertThat(offer.startsAt).isNotNull();
        assertThat(offer.groups)
                .isNotNull()
                .isNotEmpty();
        // Group
        for (Group group : offer.groups) {
            testGroup(group);
        }
    }

    private void testGroup(Group group) {
        assertThat(group).isNotNull();
        assertThat(group.group)
                .isNotNull()
                .isNotEmpty();
        // Rooms
        assertThat(group.rooms)
                .isNotNull()
                .isNotEmpty();
    }

}
