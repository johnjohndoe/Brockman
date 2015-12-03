package info.metadude.java.library.brockman.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import info.metadude.java.library.brockman.models.Stream;
import info.metadude.java.library.brockman.models.Url;
import info.metadude.java.library.brockman.models.VideoSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamAdapter {

    @ToJson
    public String toJson(Stream stream) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @FromJson
    public Stream fromJson(StreamJson streamJson) throws Exception {
        String slug = streamJson.slug;
        String display = streamJson.display;
        boolean isTranslated = streamJson.isTranslated;
        Stream.TYPE type = streamJson.type;
        VideoSize videoSize = streamJson.videoSize;
        Map<String, Object> urlsJson = streamJson.urls;
        List<Url> urls = getUrls(urlsJson);
        return new Stream(display, isTranslated, slug, type, videoSize, urls);
    }

    private List<Url> getUrls(Map<String, Object> urlsJson) {
        Set<String> urlTypes = urlsJson.keySet();
        List<Url> urls = new ArrayList<Url>(urlTypes.size());
        for (String urlType : urlTypes) {
            @SuppressWarnings("unchecked")
            Map<String, String> urlProperties = (Map<String, String>) urlsJson.get(urlType);
            urls.add(getUrl(urlType, urlProperties));
        }
        return urls;
    }

    private Url getUrl(String urlType, Map<String, String> properties) {
        Url.TYPE type = new UrlTypeAdapter().fromJson(urlType);
        String display = properties.get("display");
        String tech = properties.get("tech");
        String url = properties.get("url");
        return new Url(type, display, tech, url);
    }

    private static final class StreamJson {

        String slug;

        String display;

        boolean isTranslated;

        Stream.TYPE type;

        VideoSize videoSize;

        Map<String, Object> urls;

    }

}
