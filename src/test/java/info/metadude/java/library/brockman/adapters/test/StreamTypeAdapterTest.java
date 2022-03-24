package info.metadude.java.library.brockman.adapters.test;

import info.metadude.java.library.brockman.adapters.StreamTypeAdapter;
import info.metadude.java.library.brockman.models.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public final class StreamTypeAdapterTest {

    private final StreamTypeAdapter adapter = new StreamTypeAdapter();

    @Test
    public void toJsonWithAudio() {
        assertThat(adapter.toJson(Stream.TYPE.AUDIO))
                .isEqualTo(Stream.TYPE.AUDIO.toString());
    }

    @Test
    public void toJsonWithMusic() {
        assertThat(adapter.toJson(Stream.TYPE.MUSIC))
                .isEqualTo(Stream.TYPE.MUSIC.toString());
    }

    @Test
    public void toJsonWithSlides() {
        assertThat(adapter.toJson(Stream.TYPE.SLIDES))
                .isEqualTo(Stream.TYPE.SLIDES.toString());
    }

    @Test
    public void toJsonWithVideo() {
        assertThat(adapter.toJson(Stream.TYPE.VIDEO))
                .isEqualTo(Stream.TYPE.VIDEO.toString());
    }

    @Test
    public void fromJsonWithAudio() {
        assertThat(adapter.fromJson(Stream.TYPE.AUDIO.toString()))
                .isEqualTo(Stream.TYPE.AUDIO);
    }

    @Test
    public void fromJsonWithMusic() {
        assertThat(adapter.fromJson(Stream.TYPE.MUSIC.toString()))
                .isEqualTo(Stream.TYPE.MUSIC);
    }

    @Test
    public void fromJsonWithSlides() {
        assertThat(adapter.fromJson(Stream.TYPE.SLIDES.toString()))
                .isEqualTo(Stream.TYPE.SLIDES);
    }

    @Test
    public void fromJsonWithVideo() {
        assertThat(adapter.fromJson(Stream.TYPE.VIDEO.toString()))
                .isEqualTo(Stream.TYPE.VIDEO);
    }

    @Test
    public void fromJsonWithUnknownType() {
        assertThat(adapter.fromJson("unknown-type"))
                .isEqualTo(Stream.TYPE.UNKNOWN);
    }

}
