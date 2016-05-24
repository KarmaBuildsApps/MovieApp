package myapp.tae.ac.uk.watchmovies.UI.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.R;
import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.People.KnownFor;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;

/**
 * Created by Karma on 21/05/16.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private final Context mContext;
    private List<PeopleResult> popularPeople;

    public PeopleAdapter(Context context) {
        this.mContext = context;
        popularPeople = new ArrayList<>();
    }

    public void setPopularPeople(List<PeopleResult> people) {
        if (people != null) {
            this.popularPeople = people;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_people, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PeopleResult aPeople = popularPeople.get(position);
        String knowForText;
        Glide.with(mContext)
                .load(Constants.POSTER_URL_BASE + aPeople.getProfilePath())
                .into(holder.mPeopleProfileImage);
        holder.mPeopleName.setText(aPeople.getName());
        knowForText = getKnowForTexts(aPeople.getKnownFor());
        holder.mKnowFor.setText(knowForText);
    }

    private String getKnowForTexts(List<KnownFor> knownFor) {
        String knowForText = "";
        for (int i = 0; i < knownFor.size(); i++) {
            knowForText += knownFor.get(i).getTitle();
            if (i != knownFor.size() - 1) {
                knowForText += " | ";
            }
        }
        return knowForText;
    }

    @Override
    public int getItemCount() {
        return popularPeople.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.peopleName)
        TextView mPeopleName;
        @Bind(R.id.peopleKnownFor)
        TextView mKnowFor;
        @Bind(R.id.peopleProfileImage)
        ImageView mPeopleProfileImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
