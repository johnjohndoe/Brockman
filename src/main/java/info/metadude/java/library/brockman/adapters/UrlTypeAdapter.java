package info.metadude.java.library.brockman.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.ToJson;
import info.metadude.java.library.brockman.models.Url;

public class UrlTypeAdapter {

    @ToJson
    public String toJson(Url.TYPE type) {
        return type.toString();
    }

    @FromJson
    public Url.TYPE fromJson(String type) {
        if (type.equalsIgnoreCase(Url.TYPE.HLS.toString())) {
            return Url.TYPE.HLS;
        }
        if (type.equalsIgnoreCase(Url.TYPE.MP3.toString())) {
            return Url.TYPE.MP3;
        }
        if (type.equalsIgnoreCase(Url.TYPE.OPUS.toString())) {
            return Url.TYPE.OPUS;
        }
        if (type.equalsIgnoreCase(Url.TYPE.WEBM.toString())) {
            return Url.TYPE.WEBM;
        }
        throw new JsonDataException("Unknown URL type: " + type);
    }

}
