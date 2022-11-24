package org.example;

public class Enemy {

    private boolean enemy;

    public boolean enemySpotted(){
        return enemy;
    }

    public void enemyInSight() {
        enemy = true;
    }

    public void noEnemy() {
        enemy = false;
    }

}