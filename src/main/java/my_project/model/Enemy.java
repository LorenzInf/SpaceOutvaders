package my_project.model;
import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
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
            createImage("src/main/resources/graphic/enemy_shield_shield.png") //6
    };

    //other stuff
    protected double enemyX;
    protected double enemyY;
    protected int hp;
    protected int speed;
    protected double shootChance;
    protected boolean instantShot;
    protected double shootTimer;
    protected double shootDelay;
    protected boolean movingRight;
    protected boolean movingDown;
    protected double previousY;
    protected boolean moving;
    protected double timer;

    public Enemy(ViewController viewController, ProgramController programController, boolean movingRight, int posX, int posY){
        super(viewController, programController);
        x = posX * 175;
        y = posY * 175;
        enemyX = x;
        enemyY = y;
        hp = 1;
        speed = 150;
        shootChance = 2.5;
        instantShot = false;
        shootTimer = 0;
        shootDelay = 0.25;
        movingDown = false;
        previousY = enemyY;
        timer = 5;
        this.movingRight = movingRight;
        viewController.draw(this);
    }

    /**
     * When called there is a chance of {@code shootChance}% for the Enemy to shoot
     */
    public boolean tryToShoot(double chance){
        if(timer <= 0) {
            int help = new Random().nextInt(100 + 1);
            if (chance >= help && y > 0) {
                new Shot(viewController, programController, enemyX , enemyY + 60, 500, true);
                SoundController.playSound("shootPlayer");
                return true;
            }
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
        if(moving) {
            timer -= dt;
        }
        if(timer <= 0) {
            double incr = speed * dt;
            if (movingRight && !movingDown) {
                x += incr;
                enemyX += incr;
                if (enemyX >= 1750) {
                    movingDown = true;
                    previousY = enemyY;
                }
            }
            if (!movingRight && !movingDown) {
                x -= incr;
                enemyX -= incr;
                if (enemyX <= 0) {
                    movingDown = true;
                    previousY = enemyY;
                }
            }
            if (movingDown) {
                y += incr;
                enemyY += incr;
                if (enemyY >= previousY + 175) {
                    movingDown = false;
                    movingRight = !movingRight;
                }
            }
        }
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }
}
