package com.boomzoned.projects.eplfixtures2017_18.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boomzoned.projects.eplfixtures2017_18.Models.FixtureItem;
import com.boomzoned.projects.eplfixtures2017_18.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by jeevan on 8/10/17.
 */


public class ClubFixtureListAdapter extends RecyclerView.Adapter<ClubFixtureListAdapter.ClubFixtureHolder> {

    private List<FixtureItem> mMatches;
    private Context mContext;

    public static class ClubFixtureHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private FixtureItem mMatch;
        private TextView mOppositionTeam;
        private TextView mDate;
        private TextView mHomeAway;
        private Context mContext;

        /**
         *
         * @param itemView      View of the item
         * @param mContext      Current context
         */
        public ClubFixtureHolder(View itemView,Context mContext) {
            super(itemView);
            this.mContext = mContext;

            mOppositionTeam = (TextView) itemView.findViewById(R.id.opp_team_txtview);
            mDate = (TextView) itemView.findViewById(R.id.match_date_txtview);
            mHomeAway = (TextView) itemView.findViewById(R.id.home_away_txtview);

//            itemView.setOnClickListener(this);
        }

        /**
         * @param view      Current view
         */
        @Override
        public void onClick(View view) {
            Log.d("RecyclerView","Click");
        }

        /**
         *
         * @param Match       model of the restaurant
         */
        public void bindFixture(FixtureItem Match){
            mMatch = Match;
            mOppositionTeam.setText(Match.getmOpposition());

            DateFormat df = new SimpleDateFormat("E, MMM dd yyyy");
            String matchDate = df.format(Match.getmDate());
            mDate.setText(matchDate);
            mHomeAway.setText(Match.getmHomeAway());
            if(Match.getmHomeAway().equalsIgnoreCase("Home")){
                mHomeAway.setTextColor(mContext.getResources().getColor(R.color.light_green));
            }
            else{
                mHomeAway.setTextColor(mContext.getResources().getColor(R.color.dark_red));
            }
        }
    }

    /**
     *
     * @param mMatches  list of restaurants
     * @param mContext      current context
     */
    public ClubFixtureListAdapter(List<FixtureItem> mMatches, Context mContext) {
        this.mMatches = mMatches;
        this.mContext = mContext;
    }

    /**
     *
     * @param parent        View group
     * @param viewType      Type of the view
     * @return
     */
    @Override
    public ClubFixtureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_fixtures_list_item,parent,false);
        return new ClubFixtureHolder(inflatedView,mContext);
    }

    /**
     *
     * @param holder        Restaurant holder
     * @param position      Restaurant's position
     */
    @Override
    public void onBindViewHolder(ClubFixtureHolder holder, int position) {
        FixtureItem Match = mMatches.get(position);
        holder.bindFixture(Match);
    }

    /**
     *
     * @return      Size of the restaurants
     */
    @Override
    public int getItemCount() {
        return mMatches.size();
    }

}
