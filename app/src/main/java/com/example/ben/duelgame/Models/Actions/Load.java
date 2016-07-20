package com.example.ben.duelgame.Models.Actions;

import com.example.ben.duelgame.Models.Player;

/**
 * Created by Ben on 15/11/2015.
 */
public class Load extends Action {

    @Override
    public String pastTenseString() {
        return "loaded";
    }

    @Override
    public double speed() {
        return 4.0;
    }

    @Override
    public void perform(Player user, Player enemy) {
        user.ammo++;
    }

}
