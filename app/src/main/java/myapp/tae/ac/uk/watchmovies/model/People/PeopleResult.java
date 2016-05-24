
package myapp.tae.ac.uk.watchmovies.model.People;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import android.os.Parcel;
import android.os.Parcelable;

public class PeopleResult implements Parcelable {
    private String profilePath;
    private Boolean adult;
    private Integer id;
    private List<KnownFor> knownFor = new ArrayList<KnownFor>();
    private String name;
    private Double popularity;
    public final static Creator<PeopleResult> CREATOR = new Creator<PeopleResult>() {


        public PeopleResult createFromParcel(Parcel in) {
            PeopleResult instance = new PeopleResult();
            instance.profilePath = ((String) in.readValue((String.class.getClassLoader())));
            instance.adult = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.knownFor, (KnownFor.class.getClassLoader()));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.popularity = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public PeopleResult[] newArray(int size) {
            return (new PeopleResult[size]);
        }

    };

    /**
     * @return The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    /**
     * @return The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     * @param adult The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The knownFor
     */
    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    /**
     * @param knownFor The known_for
     */
    public void setKnownFor(List<KnownFor> knownFor) {
        this.knownFor = knownFor;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     * @param popularity The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(profilePath);
        dest.writeValue(adult);
        dest.writeValue(id);
        dest.writeList(knownFor);
        dest.writeValue(name);
        dest.writeValue(popularity);
    }

    public int describeContents() {
        return 0;
    }

}
