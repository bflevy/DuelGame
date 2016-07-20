package com.example.ben.duelgame.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.ben.duelgame.Models.Actions.Action;

/**
 * Created by Ben on 18/10/2015.
 */
public class MultiPlayerDuelActivity extends DuelActivity {

    protected static final Action DEFAULT_ACTION = Action.SHIELD;
    protected static final float TURN_TIME = 3.0f;

    private boolean mIsHost;
    protected float mTime = TURN_TIME;


    public static class Extras {
        public static final String IS_HOST = "is_host";
    }
    public static void startActivity(BaseActivity callerActivity, boolean isHost) {
        Intent intent = new Intent(callerActivity, MultiPlayerDuelActivity.class);
        intent.putExtra(Extras.IS_HOST, isHost);
        callerActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIsHost = getIntent().getBooleanExtra(Extras.IS_HOST, false);
    }

    @Override
    protected void performAction(Action action) {

        // if being counted counted down
        //  calculate action result, output, next turn

        // if not being counted down
        //  save action, disable buttons, send message to opponent
    }
}
