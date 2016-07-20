package com.example.ben.duelgame.Activities;

import android.bluetooth.BluetoothAdapter;

import com.example.ben.duelgame.R;

import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_main;
    }

    private boolean isBluetoothPaired() {
        return BluetoothAdapter.getDefaultAdapter().getBondedDevices().size() > 0;
    }

    @OnClick(R.id.single_player_button)
    public void onClickSinglePlayer() {
        SinglePlayerDuelActivity.startActivity(this);
    }

    @OnClick(R.id.join_button)
    public void onClickJoin() {
        if (isBluetoothPaired()) {
            MultiPlayerDuelActivity.startActivity(this, false);
        }
    }

    @OnClick(R.id.host_button)
    public void onClickHost() {
        if (isBluetoothPaired()) {
            MultiPlayerDuelActivity.startActivity(this, true);
        }
    }

    @OnClick(R.id.info_button)
    public void onClickInfo() {
        InfoActivity.startActivity(this);
    }
}
