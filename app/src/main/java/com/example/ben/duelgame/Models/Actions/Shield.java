package com.example.ben.duelgame.Models.Actions;

import com.example.ben.duelgame.Models.Player;

/**
 * Created by Ben on 15/11/2015.
 */
public class Shield extends Action {

    @Override
    public String pastTenseString() {
        return "shielded";
    }

    @Override
    public double speed() {
        return 1.0;
    }

    @Override
    public void perform(Player user, Player enemy) {
    }

}
