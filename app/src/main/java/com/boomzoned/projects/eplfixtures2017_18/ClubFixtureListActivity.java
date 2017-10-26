package com.boomzoned.projects.eplfixtures2017_18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.boomzoned.projects.eplfixtures2017_18.Adapters.ClubFixtureListAdapter;
import com.boomzoned.projects.eplfixtures2017_18.Misc.SimpleDividerItemDecoration;
import com.boomzoned.projects.eplfixtures2017_18.Models.FixtureItem;
import com.boomzoned.projects.eplfixtures2017_18.Models.Fixtures;
import com.boomzoned.projects.eplfixtures2017_18.Models.Match;
import com.boomzoned.projects.eplfixtures2017_18.Models.Round;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ClubFixtureListActivity extends AppCompatActivity {

    public List<FixtureItem> mFixtures;
    private RecyclerView mRecyclerView;
    private TextView mFixtureTextView;
    private LinearLayoutManager mLinearLayoutManager;
    private ClubFixtureListAdapter mClubFixtureListAdapter;
    private Gson gson;
    private String mClub;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_fixture_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.fixturesRecyclerView);
        mFixtureTextView = (TextView) findViewById(R.id.fixtures_txtview);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mFixtures = new ArrayList<>();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mClubFixtureListAdapter = new ClubFixtureListAdapter(mFixtures,this);
        mRecyclerView.setAdapter(mClubFixtureListAdapter);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        Intent intent = getIntent();
        mClub = (String)intent.getExtras().get("club");
        mFixtureTextView.setText(mClub);

        MobileAds.initialize(getApplicationContext(), this.getResources().getString(R.string.admob_app_id));
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        /*
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i("Ads", "onAdClosed");
            }
        });*/

    }

    /**
     * On start method
     */
    @Override
    protected void onStart() {
        super.onStart();
        initiateJSONParse();
    }

    private void initiateJSONParse(){
        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setDateFormat("yyyy-MM-dd");
        gsonBuilder.setDateFormat("E, MMM dd yyyy");
        gson = gsonBuilder.create();

        String jsonString = null;
        try {
            InputStream is = this.getAssets().open("fixtures.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Fixtures fixtures = gson.fromJson(jsonString, Fixtures.class);
        List<Round> mRounds = fixtures.getmRounds();
        for (Round round: mRounds) {
            FixtureItem mFixtureItem = new FixtureItem();
            for (Match match : round.getmMatches()){
                if(match.getmTeam1().getmName().equalsIgnoreCase(mClub)){
                    mFixtureItem.setmOpposition(match.getmTeam2().getmName());
                    mFixtureItem.setmDate(match.getmDate());
                    mFixtureItem.setmHomeAway("Home");
                    break;
                }
                else if(match.getmTeam2().getmName().equalsIgnoreCase(mClub)){
                    mFixtureItem.setmOpposition(match.getmTeam1().getmName());
                    mFixtureItem.setmDate(match.getmDate());
                    mFixtureItem.setmHomeAway("Away");
                    break;
                }
            }
            mFixtures.add(mFixtureItem);
        }

        mClubFixtureListAdapter.notifyDataSetChanged();

    }
}
