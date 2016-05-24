package myapp.tae.ac.uk.watchmovies.UI.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.R;
import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;

/**
 * Created by Karma on 21/05/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final Context mContext;
    private List<MovieResult> popularMovies;

    public MovieAdapter(Context context) {
        this.mContext = context;
        popularMovies = new ArrayList<>();
    }

    public void setPopularMovies(List<MovieResult> movies) {
        if (movies != null) {
            this.popularMovies = movies;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieResult movie = popularMovies.get(position);
        Glide.with(mContext).load(Constants.POSTER_URL_BASE + movie.getPosterPath())
                .into(holder.mPoster);
        holder.mTitle.setText(movie.getTitle());
//        holder.mGenre.setText(movie.getGenreIds());
        holder.mDate.setText(movie.getReleaseDate());
        holder.mLang.setText(movie.getOriginalLanguage());
        holder.mOverview.setText(movie.getOverview());
        holder.mRating.setRating((float) (movie.getVoteAverage() / 2));
    }

    @Override
    public int getItemCount() {
        return popularMovies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movieTitle)
        TextView mTitle;
        @Bind(R.id.movieGenre)
        TextView mGenre;
        @Bind(R.id.movieReleaseDate)
        TextView mDate;
        @Bind(R.id.movieLanguage)
        TextView mLang;
        @Bind(R.id.movieOverview)
        TextView mOverview;
        @Bind(R.id.movieRating)
        RatingBar mRating;
        @Bind(R.id.imageCover)
        ImageView mPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
