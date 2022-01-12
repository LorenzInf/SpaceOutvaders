package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;

public abstract class Enemy extends GraphicalObject {
    private double x;
    private double y;
    private int hp;
    private int damage;
    private int speed;
    private boolean shield;
    private ViewController viewController;

    public Enemy(double x, double y, int hp, int damage, int speed, boolean shield, ViewController viewController){


        this.x = x;
        this.y = y;
        this.hp = 3;
        this.damage = damage;
        this.speed = speed;
        this.shield = shield;

    }
    public void shoot(){


    }
    //Jedes mal wenn er sich bewegt und kein Gegner unter ihm ist hat er eine x Prozent chance nach unten zu schießen (würde 0.5% oder so vorschlagen, muss man ausprobieren)

    @Override
    public void update(double dt){
        x = speed * dt;
        if(x >= 1900){
            x -= speed * dt;
        }
        if(x<=20) {
            x = speed * dt;
        }


    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
