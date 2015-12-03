package info.metadude.java.library.brockman.test;

import info.metadude.java.library.brockman.UrlTypeAdapter;
import info.metadude.java.library.brockman.models.Url;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public final class UrlTypeAdapterTest {

    protected final UrlTypeAdapter adapter = new UrlTypeAdapter();

    @Test
    public void toJsonWithHls() throws Exception {
        assertThat(adapter.toJson(Url.TYPE.HLS))
                .isEqualTo(Url.TYPE.HLS.toString());
    }

    @Test
    public void toJsonWithMp3() throws Exception {
        assertThat(adapter.toJson(Url.TYPE.MP3))
                .isEqualTo(Url.TYPE.MP3.toString());
    }

    @Test
    public void toJsonWithOpus() throws Exception {
        assertThat(adapter.toJson(Url.TYPE.OPUS))
                .isEqualTo(Url.TYPE.OPUS.toString());
    }

    @Test
    public void toJsonWithWebm() throws Exception {
        assertThat(adapter.toJson(Url.TYPE.WEBM))
                .isEqualTo(Url.TYPE.WEBM.toString());
    }

    @Test
    public void fromJsonWithHls() throws Exception {
        assertThat(adapter.fromJson(Url.TYPE.HLS.toString()))
                .isEqualTo(Url.TYPE.HLS);
    }

    @Test
    public void fromJsonWithMp3() throws Exception {
        assertThat(adapter.fromJson(Url.TYPE.MP3.toString()))
                .isEqualTo(Url.TYPE.MP3);
    }

    @Test
    public void fromJsonWithOpus() throws Exception {
        assertThat(adapter.fromJson(Url.TYPE.OPUS.toString()))
                .isEqualTo(Url.TYPE.OPUS);
    }

    @Test
    public void fromJsonWithWebm() throws Exception {
        assertThat(adapter.fromJson(Url.TYPE.WEBM.toString()))
                .isEqualTo(Url.TYPE.WEBM);
    }

    @Test
    public void fromJsonWithUnknownType() throws Exception {
        String type = "unknown-type";
        try {
            adapter.fromJson(type);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .isEqualTo("Unknown URL type: " + type);
        }
    }

}
