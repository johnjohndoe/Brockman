package info.metadude.java.library.brockman.test;

import info.metadude.java.library.brockman.VideoSizeAdapter;
import info.metadude.java.library.brockman.models.VideoSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public final class VideoSizeAdapterTest {

    protected final VideoSizeAdapter adapter = new VideoSizeAdapter();

    protected final int[] dimensions = new int[]{1024, 768};

    protected final VideoSize videoSize = new VideoSize(1024, 768);

    @Test
    public void fromJsonWithWidthAndHeight() throws Exception {
        assertThat(adapter.fromJson(dimensions))
                .isEqualTo(videoSize);
    }

    @Test
    public void fromJsonWithWidth() {
        int[] incompleteDimensions = new int[]{1024};
        try {
            adapter.fromJson(incompleteDimensions);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .isEqualTo("Expected 2 elements but was " + Arrays.toString(incompleteDimensions));
        }
    }

    @Test
    public void fromJsonWithoutDimension() {
        try {
            adapter.fromJson(null);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .isEqualTo("Expected dimensions not to be null.");
        }
    }

    @Test
    public void toJsonWithVideoSize() throws Exception {
        assertThat(adapter.toJson(videoSize))
                .isEqualTo(dimensions);
    }

    @Test
    public void toJsonWithoutVideoSize() {
        try {
            adapter.toJson(null);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .isEqualTo("Expected video size not to be null.");
        }
    }

}
