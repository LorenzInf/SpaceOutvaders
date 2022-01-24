package my_project.model;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import my_project.view.Entity;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Enemy extends Entity {
    //Sprites
    protected BufferedImage[] images = new BufferedImage[]{
            createImage("src/main/resources/graphic/enemy_boss.png"), //0
            createImage("src/main/resources/graphic/enemy_burst_fire.png"), //1
            createImage("src/main/resources/graphic/enemy_normal.png"), //2
            createImage("src/main/resources/graphic/enemy_shield.png"), //3
            createImage("src/main/resources/graphic/enemy_charged_instant_shot.png"), //4
            createImage("src/main/resources/graphic/enemy_fast.png"), //5
    };

    //other stuff
    protected int hp = 1; //1 oder 2
    protected int speed = 1; //in felder/sekunde
    protected double shootChance = 0.5;
    protected boolean instantShot = false;
    protected double count = 0;

    public Enemy(ViewController viewController, ProgramController programController){
        super(viewController, programController);
    }

    /**
     * This should constantly be called in subclasses - When called there is a chance of {@code shootChance}% to shoot
     */
    public boolean tryToShoot(){
        int help = new Random().nextInt(100 + 1);
        if(shootChance >= help){
            Shot s = new Shot(viewController,x,y,3,8,100,255,255,255,0,0,0,true, programController);
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
