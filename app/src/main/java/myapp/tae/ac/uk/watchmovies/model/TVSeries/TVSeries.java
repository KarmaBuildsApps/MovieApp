
package myapp.tae.ac.uk.watchmovies.model.TVSeries;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
public class TVSeries implements Parcelable
{

    private Integer page;
    private List<TVResult> TVResults = new ArrayList<TVResult>();
    private Integer totalResults;
    private Integer totalPages;
    public final static Parcelable.Creator<TVSeries> CREATOR = new Creator<TVSeries>() {


        public TVSeries createFromParcel(Parcel in) {
            TVSeries instance = new TVSeries();
            instance.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.TVResults, (TVResult.class.getClassLoader()));
            instance.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public TVSeries[] newArray(int size) {
            return (new TVSeries[size]);
        }

    }
    ;

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
     *     The TVResults
     */
    public List<TVResult> getTVResults() {
        return TVResults;
    }

    /**
     * 
     * @param TVResults
     *     The TVResults
     */
    public void setTVResults(List<TVResult> TVResults) {
        this.TVResults = TVResults;
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
        dest.writeList(TVResults);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
    }

    public int describeContents() {
        return  0;
    }

}
