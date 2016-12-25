
package info.metadude.java.library.brockman.models;

import java.util.List;

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
        return author != null ? author.equals(offer.author) : offer.author == null
                && (conference != null ? conference.equals(offer.conference) : offer.conference == null
                && (description != null ? description.equals(offer.description) : offer.description == null
                && (endsAt != null ? endsAt.equals(offer.endsAt) : offer.endsAt == null
                && (groups != null ? groups.equals(offer.groups) : offer.groups == null
                && (keywords != null ? keywords.equals(offer.keywords) : offer.keywords == null
                && (slug != null ? slug.equals(offer.slug) : offer.slug == null
                && (startsAt != null ? startsAt.equals(offer.startsAt) : offer.startsAt == null)))))));
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (conference != null ? conference.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (endsAt != null ? endsAt.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (startsAt != null ? startsAt.hashCode() : 0);
        return result;
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
