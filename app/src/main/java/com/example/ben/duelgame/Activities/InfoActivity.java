package com.example.ben.duelgame.Activities;

import android.content.Intent;

import com.example.ben.duelgame.R;

public class InfoActivity extends BaseActivity {

    public static void startActivity(BaseActivity callerActivity) {
        Intent intent = new Intent(callerActivity, InfoActivity.class);
        callerActivity.startActivity(intent);
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_info;
    }

}
