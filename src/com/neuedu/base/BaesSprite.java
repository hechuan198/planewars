package com.neuedu.base;

public abstract class BaesSprite {
    private int x;
    private int y;

    public BaesSprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BaesSprite() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
