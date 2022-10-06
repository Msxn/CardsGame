package com.mydigitalschool.cardsgame.demo.cartes;

public abstract class Carte implements ICarte {

    //TODO javadoc

    private boolean visible = false;

    @Override
    public boolean isVisible() {
        // TODO Auto-generated method stub
        return visible;
    }

    @Override
    public void retourner() {
        this.visible = !this.visible;

    }

    public void cacher() {
        this.visible = false;
    }

    public void montrer() {
        this.visible = true;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
