package com.example.ben.duelgame.Models;

import com.example.ben.duelgame.Models.Actions.Action;

/**
 * Created by Ben on 15/11/2015.
 */
public class Player {

    public static final int DEFAULT_HEALTH = 3;

    public int health, ammo, energy;

    public Action currentAction = null;

    public String name;

    public Player(String name) {
        this.name = name;
        reset();
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void reset() {
        health = DEFAULT_HEALTH;
        ammo = 0;
        energy = 0;
        currentAction = null;
    }

}
