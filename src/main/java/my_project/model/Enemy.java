package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ProgramController;
import my_project.view.Game;

import javax.swing.text.View;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Enemy extends Game {
    //Sprites
    protected BufferedImage[] images = new BufferedImage[]{
            load("enemy_boss.png"), //0
            load("enemy_burst_fire.png"), //1
            load("enemy_normal.png"), //2
            load("enemy_shield.png") //3
    };

    //other stuff
    protected ViewController viewController;
    protected ProgramController programController;
    protected int hp = 1; //1 oder 2
    protected int speed = 1; //in felder/sekunde
    protected double shootChance = 0.5;

    public Enemy(ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
    }


    /**
     * This should constantly be called in subclasses - Every second there is a chance of {@code shootChance}% to shoot
     * @param dt Time since last update
     */
    public void tryToShoot(double dt){
        double help = 0;
        help += dt;
        if(help >= 1){
            help = 0;
            int help2 = new Random().nextInt(100 + 1);
            if(shootChance >= help2){
                //shoot();
            }
        }
    }

    //Jedes mal wenn er sich bewegt und kein Gegner unter ihm ist hat er eine x Prozent chance nach unten zu schießen
    //(würde 0.5% oder so vorschlagen, muss man ausprobieren)
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
