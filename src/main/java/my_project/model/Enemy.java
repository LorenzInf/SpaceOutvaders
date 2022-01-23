package my_project.model;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import my_project.view.Game;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Enemy extends Game {
    //Sprites
    protected BufferedImage[] images = new BufferedImage[]{
            createImage("enemy_boss.png"), //0
            createImage("enemy_burst_fire.png"), //1
            createImage("enemy_normal.png"), //2
            createImage("enemy_shield.png"), //3
            createImage("enemy_charged_instant_shot"), //4
            createImage("enemy_fast.png"), //5
    };

    //other stuff
    protected ViewController viewController;
    protected ProgramController programController;
    protected int hp = 1; //1 oder 2
    protected int speed = 1; //in felder/sekunde
    protected double shootChance = 0.5;
    protected boolean instantShot = false;
    protected double count = 0;

    public Enemy(ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
    }

    /**
     * This should constantly be called in subclasses - When called there is a chance of {@code shootChance}% to shoot
     */
    public boolean tryToShoot(){
        int help = new Random().nextInt(100 + 1);
        if(shootChance >= help){
            Shoot s = new Shoot(viewController,x,y,3,8,100,255,255,255,0,0,0,true, programController);
            return true;
        }
        return false;
    }

    //Jedes mal wenn er sich bewegt und kein Gegner unter ihm ist hat er eine x Prozent chance nach unten zu schießen
    //(würde 0.5% oder so vorschlagen, muss man ausprobieren)
    @Override
    public void update(double dt){
        tryToShoot();
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
