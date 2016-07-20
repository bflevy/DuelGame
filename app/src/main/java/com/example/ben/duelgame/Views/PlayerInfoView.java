package com.example.ben.duelgame.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ben.duelgame.Models.Player;
import com.example.ben.duelgame.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ben on 15/11/2015.
 */
public class PlayerInfoView extends LinearLayout {

    @Bind(R.id.player_header_text)
    TextView mHeaderText;

    @Bind(R.id.player_lives_text)
    TextView mLivesText;

    @Bind(R.id.player_ammo_text)
    TextView mAmmoText;

    public PlayerInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.player_info, this);

        ButterKnife.bind(this);
    }

    public void update(Player player) {
        mHeaderText.setText(player.name);
        mLivesText.setText(String.valueOf(player.health));
        mAmmoText.setText(String.valueOf(player.ammo));
    }
}
