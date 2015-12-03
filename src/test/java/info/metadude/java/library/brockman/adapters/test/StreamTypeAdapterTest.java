package info.metadude.java.library.brockman.adapters.test;

import info.metadude.java.library.brockman.adapters.StreamTypeAdapter;
import info.metadude.java.library.brockman.models.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public final class StreamTypeAdapterTest {

    protected final StreamTypeAdapter adapter = new StreamTypeAdapter();

    @Test
    public void toJsonWithAudio() throws Exception {
        assertThat(adapter.toJson(Stream.TYPE.AUDIO))
                .isEqualTo(Stream.TYPE.AUDIO.toString());
    }

    @Test
    public void toJsonWithMusic() throws Exception {
        assertThat(adapter.toJson(Stream.TYPE.MUSIC))
                .isEqualTo(Stream.TYPE.MUSIC.toString());
    }

    @Test
    public void toJsonWithSlides() throws Exception {
        assertThat(adapter.toJson(Stream.TYPE.SLIDES))
                .isEqualTo(Stream.TYPE.SLIDES.toString());
    }

    @Test
    public void toJsonWithVideo() throws Exception {
        assertThat(adapter.toJson(Stream.TYPE.VIDEO))
                .isEqualTo(Stream.TYPE.VIDEO.toString());
    }

    @Test
    public void fromJsonWithAudio() throws Exception {
        assertThat(adapter.fromJson(Stream.TYPE.AUDIO.toString()))
                .isEqualTo(Stream.TYPE.AUDIO);
    }

    @Test
    public void fromJsonWithMusic() throws Exception {
        assertThat(adapter.fromJson(Stream.TYPE.MUSIC.toString()))
                .isEqualTo(Stream.TYPE.MUSIC);
    }

    @Test
    public void fromJsonWithSlides() throws Exception {
        assertThat(adapter.fromJson(Stream.TYPE.SLIDES.toString()))
                .isEqualTo(Stream.TYPE.SLIDES);
    }

    @Test
    public void fromJsonWithVideo() throws Exception {
        assertThat(adapter.fromJson(Stream.TYPE.VIDEO.toString()))
                .isEqualTo(Stream.TYPE.VIDEO);
    }

    @Test
    public void fromJsonWithUnknownType() throws Exception {
        String type = "unknown-type";
        try {
            adapter.fromJson(type);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .isEqualTo("Unknown stream type: " + type);
        }
    }

}
