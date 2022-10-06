package com.mydigitalschool.cardsgame.demo.cartes;


public abstract class Carte implements ICarte {

    private boolean visible = false;

    @Override
    public boolean isVisible() {
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
