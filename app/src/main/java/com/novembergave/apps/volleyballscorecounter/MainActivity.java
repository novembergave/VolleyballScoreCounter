package com.novembergave.apps.volleyballscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mAMissButton;
    Button mAOOBButton;
    Button mBMissButton;
    Button mBOOBButton;
    TextView mWinnerTV;
    TextView mAScoreTV;
    TextView mBScoreTV;
    int TeamAScore;
    int TeamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAScoreTV = (TextView) findViewById(R.id.team_a_score);
        mBScoreTV = (TextView) findViewById(R.id.team_b_score);
        mWinnerTV = (TextView) findViewById(R.id.winner_box);

        mAMissButton = (Button) findViewById(R.id.team_a_miss);
        mAOOBButton = (Button) findViewById(R.id.team_a_oob);
        mBMissButton = (Button) findViewById(R.id.team_b_miss);
        mBOOBButton = (Button) findViewById(R.id.team_b_oob);

        TeamAScore = 0;
        TeamBScore = 0;
    }

    public void aAddScore(View v) {
        TeamAScore++;
        displayForTeamA(TeamAScore);
        // Checks if the team has won and if so, disable the buttons
        if ((TeamAScore >= 25) && ((TeamAScore - TeamBScore) >= 2)) {
            String winnerText = getString(R.string.team) + " " +
                    getString(R.string.a) + " " + getString(R.string.wins);
            mWinnerTV.setText(winnerText);
            mWinnerTV.setVisibility(View.VISIBLE);
            mAMissButton.setEnabled(false);
            mAOOBButton.setEnabled(false);
            mBMissButton.setEnabled(false);
            mBOOBButton.setEnabled(false);
        }
    }

    public void bAddScore(View v) {
        TeamBScore++;
        displayForTeamB(TeamBScore);
        // Checks if the team has won and if so, disable the buttons
        if ((TeamBScore >= 25) && ((TeamBScore - TeamAScore) >= 2)) {
            String winnerText = getString(R.string.team) + " " +
                    getString(R.string.b) + " " + getString(R.string.wins);
            mWinnerTV.setText(winnerText);
            mWinnerTV.setVisibility(View.VISIBLE);
            mAMissButton.setEnabled(false);
            mAOOBButton.setEnabled(false);
            mBMissButton.setEnabled(false);
            mBOOBButton.setEnabled(false);
        }
    }

    public void reset(View v) {
        TeamAScore = 0;
        TeamBScore = 0;
        displayForTeamA(TeamAScore);
        displayForTeamB(TeamBScore);
        mWinnerTV.setVisibility(View.GONE);
        // Re-enable the buttons
        mAMissButton.setEnabled(true);
        mAOOBButton.setEnabled(true);
        mBMissButton.setEnabled(true);
        mBOOBButton.setEnabled(true);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        mAScoreTV.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        mBScoreTV.setText(String.valueOf(score));
    }

}
