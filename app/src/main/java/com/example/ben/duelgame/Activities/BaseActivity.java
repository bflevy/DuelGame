package com.example.ben.duelgame.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by Ben on 15/10/2015.
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceId());
        ButterKnife.bind(this);
    }

    protected abstract int getContentResourceId();
}
