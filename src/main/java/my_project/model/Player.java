package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private int arrayX;
    private int speed;
    private boolean shield;
    private int buff;
    private final BufferedImage[] images;

    private boolean extraLife;
    private boolean piercing;
    private boolean rapidFire;
    private boolean speedBoost;

    private double rapidTimer;
    private double shieldTimer;
    private double speedTimer;
    private double shootCooldown;

    private int move;

    public Player(int arrayX, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.arrayX = arrayX;
        extraLife = false;
        piercing = false;
        shield = false;
        rapidFire = false;
        speedBoost = false;
        speed = 400;
        shieldTimer = 10;
        rapidTimer = 5;
        speedTimer = 5;
        shootCooldown = 0;
        x = 865 + 28;
        y = 875 + 12;
        width = 119;
        height = 151;
        move = 1;
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/Spaceship.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[0], x, y);
    }

    @Override
    public void update(double dt){
        shootCooldown = Math.max(0, shootCooldown -dt);
        if(move == 0) x -= dt*speed;
        if(move == 2) x += dt*speed;
        if(shield){
            shieldTimer = Math.max (shieldTimer - dt, 0);
            if(shieldTimer == 0){
                setShield(false);
            }
        }
        if(rapidFire){
            rapidTimer = Math.max (rapidTimer - dt, 0);
            if(rapidTimer == 0){
                setRapidFire(false);
            }
        }
        if(speedBoost){
            speedTimer = Math.max (speedTimer - dt, 0);
            setSpeed(900);
            if(speedTimer == 0){
                setSpeed(300);
            }
        }
    }

    public int getArrayX() {
        return arrayX;
    }

    public void setMove(int move){
        this.move = move;
    }

    public double getShootCooldown() {
        return shootCooldown;
    }

    public void setShootCooldown(double shootCooldown) {
        this.shootCooldown = shootCooldown;
    }

    public void setExtraLife(boolean extraLife) {
        this.extraLife = extraLife;
    }

    public boolean isExtraLife() {
        return extraLife;
    }

    public boolean isPiercing() {
        return piercing;
    }

    public void setPiercing(boolean piercing) {
        this.piercing = piercing;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public boolean isRapidFire() {
        return rapidFire;
    }

    public void setRapidFire(boolean rapidFire) {
        this.rapidFire = rapidFire;
    }

    public void setSpeedBoost(boolean speedBoost) {
        this.speedBoost = speedBoost;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

