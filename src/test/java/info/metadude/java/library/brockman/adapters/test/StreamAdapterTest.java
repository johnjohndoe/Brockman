package info.metadude.java.library.brockman.adapters.test;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import info.metadude.java.library.brockman.adapters.StreamAdapter;
import info.metadude.java.library.brockman.adapters.StreamTypeAdapter;
import info.metadude.java.library.brockman.adapters.VideoSizeAdapter;
import info.metadude.java.library.brockman.models.Stream;
import info.metadude.java.library.brockman.models.Url;
import info.metadude.java.library.brockman.models.VideoSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public final class StreamAdapterTest {

    // ------------------------ AUDIO -------------------------

    private static final String AUDIO_STREAM_JSON = "{\n" +
            "  \"slug\": \"audio-stereo\",\n" +
            "  \"display\": \"Sendezentrum Audio\",\n" +
            "  \"type\": \"audio\",\n" +
            "  \"isTranslated\": false,\n" +
            "  \"videoSize\": null,\n" +
            "  \"urls\": {\n" +
            "    \"mp3\": {\n" +
            "      \"display\": \"MP3\",\n" +
            "      \"tech\": \"MP3-Audio, 96 kBit/s\",\n" +
            "      \"url\": \"http://example.com/s5_stereo.mp3\"\n" +
            "    },\n" +
            "    \"opus\": {\n" +
            "      \"display\": \"Opus\",\n" +
            "      \"tech\": \"Opus-Audio, 64 kBit/s\",\n" +
            "      \"url\": \"http://example.com/s5_stereo.opus\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    private static final Stream AUDIO_STREAM = new Stream(
            "Sendezentrum Audio",
            false,
            "audio-stereo",
            Stream.TYPE.AUDIO,
            null,
            new ArrayList<Url>() {{
                add(new Url(
                        Url.TYPE.MP3,
                        "MP3",
                        "MP3-Audio, 96 kBit/s",
                        "http://example.com/s5_stereo.mp3")
                );
                add(new Url(
                        Url.TYPE.OPUS,
                        "Opus",
                        "Opus-Audio, 64 kBit/s",
                        "http://example.com/s5_stereo.opus")
                );
            }}
    );

    @Test
    public void toJsonWithAudio() {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        try {
            streamAdapter.toJson(AUDIO_STREAM);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .contains("Not yet implemented.");
        }
    }

    @Test
    public void fromJsonWithAudio() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        assertThat(streamAdapter.fromJson(AUDIO_STREAM_JSON))
                .isNotNull()
                .isEqualTo(AUDIO_STREAM);
    }

    // ------------------------ MUSIC -------------------------

    private static final String MUSIC_STREAM_JSON = "{\n" +
            "    \"slug\": \"music-native\",\n" +
            "    \"display\": \"Ambient Music\",\n" +
            "    \"type\": \"music\",\n" +
            "    \"isTranslated\": false,\n" +
            "    \"videoSize\": null,\n" +
            "    \"urls\": {\n" +
            "        \"mp3\": {\n" +
            "            \"display\": \"MP3\",\n" +
            "            \"tech\": \"MP3-Audio, 192 kBit/s\",\n" +
            "            \"url\": \"http://example.com/ambient.mp3\"\n" +
            "        },\n" +
            "        \"opus\": {\n" +
            "            \"display\": \"Opus\",\n" +
            "            \"tech\": \"Opus-Audio, 96 kBit/s\",\n" +
            "            \"url\": \"http://example.com/ambient.opus\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    private static final Stream MUSIC_STREAM = new Stream(
            "Ambient Music",
            false,
            "music-native",
            Stream.TYPE.MUSIC,
            null,
            new ArrayList<Url>() {{
                add(new Url(
                        Url.TYPE.MP3,
                        "MP3",
                        "MP3-Audio, 192 kBit/s",
                        "http://example.com/ambient.mp3")
                );
                add(new Url(
                        Url.TYPE.OPUS,
                        "Opus",
                        "Opus-Audio, 96 kBit/s",
                        "http://example.com/ambient.opus")
                );
            }}
    );

    @Test
    public void toJsonWithMusic() {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        try {
            streamAdapter.toJson(MUSIC_STREAM);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .contains("Not yet implemented.");
        }
    }

    @Test
    public void fromJsonWithMusic() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        assertThat(streamAdapter.fromJson(MUSIC_STREAM_JSON))
                .isNotNull()
                .isEqualTo(MUSIC_STREAM);
    }

    // ------------------------ SLIDES -------------------------

    private static final String SLIDES_STREAM_JSON = "{\n" +
            "    \"slug\": \"slides-translated\",\n" +
            "    \"display\": \"Saal 1 Slides (Translation)\",\n" +
            "    \"type\": \"slides\",\n" +
            "    \"isTranslated\": true,\n" +
            "    \"videoSize\": [\n" +
            "        1024,\n" +
            "        576\n" +
            "    ],\n" +
            "    \"urls\": {\n" +
            "        \"webm\": {\n" +
            "            \"display\": \"WebM\",\n" +
            "            \"tech\": \"1024x576, VP8+Vorbis in WebM, XXX kBit/s\",\n" +
            "            \"url\": \"http://example.com/s1_translated_slides.webm\"\n" +
            "        },\n" +
            "        \"hls\": {\n" +
            "            \"display\": \"HLS\",\n" +
            "            \"tech\": \"1024x576, h264+AAC im MPEG-TS-Container via HTTP, XXX kBit/s\",\n" +
            "            \"url\": \"http://example.com/hls/s1_translated_slides.m3u8\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    private static final Stream SLIDES_STREAM = new Stream(
            "Saal 1 Slides (Translation)",
            true,
            "slides-translated",
            Stream.TYPE.SLIDES,
            new VideoSize(1024, 576),
            new ArrayList<Url>() {{
                add(new Url(
                        Url.TYPE.WEBM,
                        "WebM",
                        "1024x576, VP8+Vorbis in WebM, XXX kBit/s",
                        "http://example.com/s1_translated_slides.webm")
                );
                add(new Url(
                        Url.TYPE.HLS,
                        "HLS",
                        "1024x576, h264+AAC im MPEG-TS-Container via HTTP, XXX kBit/s",
                        "http://example.com/hls/s1_translated_slides.m3u8")
                );
            }}
    );

    @Test
    public void toJsonWithSlides() {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        try {
            streamAdapter.toJson(SLIDES_STREAM);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .contains("Not yet implemented.");
        }
    }

    @Test
    public void fromJsonWithSlides() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .add(new VideoSizeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        assertThat(streamAdapter.fromJson(SLIDES_STREAM_JSON))
                .isNotNull()
                .isEqualTo(SLIDES_STREAM);
    }

    // ------------------------ VIDEO -------------------------

    private static final String VIDEO_STREAM_JSON = "{\n" +
            "    \"slug\": \"hd-translated\",\n" +
            "    \"display\": \"Saal 1 FullHD Video (Translation)\",\n" +
            "    \"type\": \"video\",\n" +
            "    \"isTranslated\": true,\n" +
            "    \"videoSize\": [\n" +
            "        1920,\n" +
            "        1080\n" +
            "    ],\n" +
            "    \"urls\": {\n" +
            "        \"webm\": {\n" +
            "            \"display\": \"WebM\",\n" +
            "            \"tech\": \"1920x1080, VP8+Vorbis in WebM, 2.8 MBit/s\",\n" +
            "            \"url\": \"http://example.com/s1_translated_hd.webm\"\n" +
            "        },\n" +
            "        \"hls\": {\n" +
            "            \"display\": \"HLS\",\n" +
            "            \"tech\": \"1920x1080, h264+AAC im MPEG-TS-Container via HTTP, 3 MBit/s\",\n" +
            "            \"url\": \"http://example.com/hls/s1_translated_hd.m3u8\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    private static final Stream VIDEO_STREAM = new Stream(
            "Saal 1 FullHD Video (Translation)",
            true,
            "hd-translated",
            Stream.TYPE.VIDEO,
            new VideoSize(1920, 1080),
            new ArrayList<Url>() {{
                add(new Url(
                        Url.TYPE.WEBM,
                        "WebM",
                        "1920x1080, VP8+Vorbis in WebM, 2.8 MBit/s",
                        "http://example.com/s1_translated_hd.webm")
                );
                add(new Url(
                        Url.TYPE.HLS,
                        "HLS",
                        "1920x1080, h264+AAC im MPEG-TS-Container via HTTP, 3 MBit/s",
                        "http://example.com/hls/s1_translated_hd.m3u8")
                );
            }}
    );

    @Test
    public void toJsonWithVideo() {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        try {
            streamAdapter.toJson(VIDEO_STREAM);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage())
                    .contains("Not yet implemented.");
        }
    }

    @Test
    public void fromJsonWithVideo() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(new StreamAdapter())
                .add(new StreamTypeAdapter())
                .add(new VideoSizeAdapter())
                .build();
        JsonAdapter<Stream> streamAdapter = moshi.adapter(Stream.class);
        assertThat(streamAdapter.fromJson(VIDEO_STREAM_JSON))
                .isNotNull()
                .isEqualTo(VIDEO_STREAM);
    }

}
