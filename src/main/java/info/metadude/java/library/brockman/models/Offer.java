
package info.metadude.java.library.brockman.models;

import java.util.List;
import java.util.Objects;

public class Offer {

    public final String author;

    public final String conference;

    public final String description;

    public final String endsAt;

    public final List<Group> groups;

    public final String keywords;

    public final String slug;

    public final String startsAt;

    public Offer(String author,
                 String conference,
                 String description,
                 String endsAt,
                 List<Group> groups,
                 String keywords,
                 String slug,
                 String startsAt) {
        this.author = author;
        this.conference = conference;
        this.description = description;
        this.endsAt = endsAt;
        this.groups = groups;
        this.keywords = keywords;
        this.slug = slug;
        this.startsAt = startsAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Offer offer = (Offer) other;
        return Objects.equals(author, offer.author) &&
                Objects.equals(conference, offer.conference) &&
                Objects.equals(description, offer.description) &&
                Objects.equals(endsAt, offer.endsAt) &&
                Objects.equals(groups, offer.groups) &&
                Objects.equals(keywords, offer.keywords) &&
                Objects.equals(slug, offer.slug) &&
                Objects.equals(startsAt, offer.startsAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, conference, description, endsAt, groups, keywords, slug, startsAt);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "author='" + author + '\'' +
                ", conference='" + conference + '\'' +
                ", description='" + description + '\'' +
                ", endsAt='" + endsAt + '\'' +
                ", groups=" + groups +
                ", keywords='" + keywords + '\'' +
                ", slug='" + slug + '\'' +
                ", startsAt='" + startsAt + '\'' +
                '}';
    }

}
