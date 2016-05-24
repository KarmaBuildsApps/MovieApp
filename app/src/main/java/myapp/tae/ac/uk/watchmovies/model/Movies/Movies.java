
package myapp.tae.ac.uk.watchmovies.model.Movies;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable
{
    private Integer page;
    private List<MovieResult> movieResults = new ArrayList<MovieResult>();
    private Integer totalResults;
    private Integer totalPages;
    public final static Parcelable.Creator<Movies> CREATOR = new Creator<Movies>() {


        public Movies createFromParcel(Parcel in) {
            Movies instance = new Movies();
            instance.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.movieResults, (MovieResult.class.getClassLoader()));
            instance.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Movies[] newArray(int size) {
            return (new Movies[size]);
        }

    };

    /**
     * 
     * @return
     *     The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The movieResults
     */
    public List<MovieResult> getMovieResults() {
        return movieResults;
    }

    /**
     * 
     * @param movieResults
     *     The movieResults
     */
    public void setMovieResults(List<MovieResult> movieResults) {
        this.movieResults = movieResults;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * 
     * @param totalPages
     *     The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeList(movieResults);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
    }

    public int describeContents() {
        return  0;
    }

}
