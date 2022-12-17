package org.example;
//only for check32
public class Caterpillars {
    private boolean caterpillars;


    public boolean isEfficient() {
        return caterpillars;
    }

    public boolean efficient() {
        return caterpillars = true;
    }

    public boolean broken() {
        return caterpillars = false;

    }
    public boolean repair(){
        return caterpillars = true;
    }
}