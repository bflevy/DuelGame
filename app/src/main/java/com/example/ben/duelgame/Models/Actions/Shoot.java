package com.example.ben.duelgame.Models.Actions;

import com.example.ben.duelgame.Models.Player;

/**
 * Created by Ben on 15/11/2015.
 */
public class Shoot extends Action {

    @Override
    public String pastTenseString() {
        return "shot";
    }

    @Override
    public double speed() {
        return 5.0;
    }

    @Override
    public void perform(Player user, Player enemy) {
        if (user.ammo > 0) {
            user.ammo--;

            if (enemy.currentAction != Action.SHIELD) {
                enemy.health--;
            }
        }
    }

}
