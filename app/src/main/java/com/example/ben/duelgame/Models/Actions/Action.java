package com.example.ben.duelgame.Models.Actions;

import com.example.ben.duelgame.Models.Player;

/**
 * Created by Ben on 15/11/2015.
 */
public abstract class Action {

    public static final Action SHIELD = new Shield();
    public static final Action SHOOT = new Shoot();
    public static final Action LOAD = new Load();

    public abstract String pastTenseString();
    public abstract double speed();
    public abstract void perform(Player user, Player enemy);

    @Override
    public String toString() {
        return pastTenseString();
    }
}
