package info.metadude.java.library.brockman.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.ToJson;
import info.metadude.java.library.brockman.models.Stream;

public class StreamTypeAdapter {

    @ToJson
    public String toJson(Stream.TYPE type) {
        return type.toString();
    }

    @FromJson
    public Stream.TYPE fromJson(String type) {
        if (type.equalsIgnoreCase(Stream.TYPE.AUDIO.toString())) {
            return Stream.TYPE.AUDIO;
        }
        if (type.equalsIgnoreCase(Stream.TYPE.MUSIC.toString())) {
            return Stream.TYPE.MUSIC;
        }
        if (type.equalsIgnoreCase(Stream.TYPE.SLIDES.toString())) {
            return Stream.TYPE.SLIDES;
        }
        if (type.equalsIgnoreCase(Stream.TYPE.VIDEO.toString())) {
            return Stream.TYPE.VIDEO;
        }
        throw new JsonDataException("Unknown stream type: " + type);
    }

}
