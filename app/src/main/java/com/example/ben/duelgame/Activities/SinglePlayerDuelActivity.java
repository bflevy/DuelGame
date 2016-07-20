package com.example.ben.duelgame.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.ben.duelgame.Models.Actions.Action;

/**
 * Created by Ben on 18/10/2015.
 */
public class SinglePlayerDuelActivity extends DuelActivity {

    private int mTurns;

    public static void startActivity(BaseActivity callerActivity) {
        Intent intent = new Intent(callerActivity, SinglePlayerDuelActivity.class);
        callerActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTurns = 0;

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void performAction(Action action) {
        mPlayer.currentAction = action;
        mOpponent.currentAction = decideOpponentsAction();

        calculateResult();
    }

    @Override
    protected void restartGame() {
        super.restartGame();

        mTurns = 0;
    }

    @Override
    protected void startTurn() {
        super.startTurn();

        mTurns++;
    }

    private Action decideOpponentsAction() {
        if (mTurns == 1) {
            return Action.LOAD;
        }

        if (mPlayer.ammo == 0) {
            double denom =  Math.pow(2, mOpponent.ammo);
            double chanceOfLoading = 1 / denom;
            if (Math.random() < chanceOfLoading) {
                return Action.LOAD;
            } else {
                return Action.SHOOT;
            }
        } else {
            double rand = Math.random();
            if(rand > 0.5) {
                return Action.SHIELD;
            } else if( rand > 0.25 && mOpponent.ammo > 0) {
                return Action.SHOOT;
            } else {
                return Action.LOAD;
            }
        }
    }
}
