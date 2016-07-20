package com.example.ben.duelgame.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.duelgame.Models.Actions.Action;
import com.example.ben.duelgame.Models.Player;
import com.example.ben.duelgame.R;
import com.example.ben.duelgame.Views.PlayerInfoView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Ben on 18/10/2015.
 */
public abstract class DuelActivity extends BaseActivity {

    @Bind(R.id.duel_load_button)
    View mLoadButton;
    @Bind(R.id.duel_shield_button)
    View mShieldButton;
    @Bind(R.id.duel_shoot_button)
    View mShootButton;

    @Bind(R.id.duel_event_text)
    protected TextView mEventText;
    @Bind(R.id.duel_player_info_top)
    PlayerInfoView mTopPlayerInfo;
    @Bind(R.id.duel_player_info_bottom)
    PlayerInfoView mBottomPlayerInfo;

    protected Player mPlayer, mOpponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayer = new Player("Player 1");
        mOpponent = new Player("Player 2");

        restartGame();
        updateView();
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_duel;
    }

    protected void startTurn() {
        mShootButton.setClickable(mPlayer.ammo > 0);
    }

    protected void calculateResult() {

        Action playersAction = mPlayer.currentAction;
        Action opponentsAction = mOpponent.currentAction;

        playersAction.perform(mPlayer, mOpponent);
        opponentsAction.perform(mOpponent, mPlayer);

        if (mOpponent.isDead() && mPlayer.isDead()) {
            Toast.makeText(this, "Tie game", Toast.LENGTH_SHORT).show();
            restartGame();
        } else if (mOpponent.isDead()) {
            Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show();
            restartGame();
        } else if (mPlayer.isDead()) {
            Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show();
            restartGame();
        } else {
            startTurn();
        }

        updateView();

        mEventText.setText("You " + playersAction + "\nYou opponent " + opponentsAction);
    }

    protected void updateView() {
        mBottomPlayerInfo.update(mPlayer);
        mTopPlayerInfo.update(mOpponent);
    }

    protected void restartGame() {
        mPlayer.reset();
        mOpponent.reset();

        startTurn();
    }

    protected abstract void performAction(Action action);

    @OnClick(R.id.duel_load_button)
    public void onClickLoad() {
        performAction(Action.LOAD);
    }

    @OnClick(R.id.duel_shield_button)
    public void onClickShield() {
        performAction(Action.SHIELD);
    }

    @OnClick(R.id.duel_shoot_button)
    public void onClickShoot() {
        performAction(Action.SHOOT);
    }
}