package my_project.model;
import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ProgramController;

import javax.swing.text.View;
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
    protected double shootChance = 5;
    protected boolean instantShot = false;
    protected double shootTimer = 0;
    protected double shootDelay;

    public Enemy(ViewController viewController, ProgramController programController){
        super(viewController, programController);
        shootDelay = 0.75;
        radius = 50;
        viewController.draw(this);
    }

    //TODO Make tryToShoot a working thing
    /**
     * When called there is a chance of {@code shootChance}% for the Enemy to shoot
     */
    public boolean tryToShoot(double chance){
        int help = new Random().nextInt(100 + 1);
        if(chance >= help){
            Shot s = new Shot(viewController, programController, x + 60, y + 60, 200, true);
            SoundController.playSound("shootPlayer");
            return true;
        }
        return false;
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

    @Override
    public void update(double dt){
        shootTimer += dt;
        if(shootTimer >= shootDelay) {
            tryToShoot(shootChance);
            shootTimer = 0;
        }
    }
}
