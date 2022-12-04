package org.example;

public class Tank {

    private Caterpillars caterpillars;
    private Enemy enemy;
    private Fire fire;
    private Engine engine;


    public Tank(Caterpillars caterpillars, Enemy enemy, Fire fire, Engine engine) {
        this.caterpillars = caterpillars;
        this.enemy = enemy;
        this.fire = fire;
        this.engine = engine;

    }

public void killEnemy(){
        enemy.enemyInSight();

        if (enemy.enemySpotted()){
            throw new IllegalStateException("Enemy spoted prepare to shot");
        }
        if(enemy.enemySpotted()){
            fire.shotOnTarget();
        }else{
            fire.stopShoting();
        }
        if ((fire.takeShot())){
            throw new IllegalStateException("Kill the enemy");
        }
}

    public void start() {


        if(engine.isRunning()) {
            throw new IllegalStateException("Engine already running");
        }
        if(caterpillars.broken()) {
            throw new IllegalStateException("Caterpillars are broken can't move");
        }

        engine.start();

        if(!engine.isRunning()) {
            throw new IllegalStateException("Started engine but isn't running");
        }
    }

    public boolean isRunning() {
        return engine.isRunning();
    }
}