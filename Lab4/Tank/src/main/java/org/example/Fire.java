package org.example;

public class Fire {
    private boolean fire;

    public boolean takeShot(){
        return fire;
    }

    public void shotOnTarget(){
        fire = true;
    }

    public void stopShoting(){
        fire = false;
    }

}