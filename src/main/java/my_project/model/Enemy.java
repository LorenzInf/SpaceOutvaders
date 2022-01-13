package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.view.Game;
import java.awt.image.BufferedImage;


public abstract class Enemy extends Game {
    //Sprites
    protected BufferedImage[] images = {
            load("enemy_boss.png"), //0
            load("enemy_burst_fire.png"), //1
            load("enemy_normal.png"), //2
            load("enemy_shield.png") //3
    };

    //Stuff
    protected int hp = 1; //1 oder 2
    protected int speed = 1; //in felder/sekunde
    protected double shootChance = 0.5;

    public void shoot(){

    }
    //Jedes mal wenn er sich bewegt und kein Gegner unter ihm ist hat er eine x Prozent chance nach unten zu schießen (würde 0.5% oder so vorschlagen, muss man ausprobieren)

    @Override
    public void update(double dt){

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
