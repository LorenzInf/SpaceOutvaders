package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class Player extends Entity {

    private int speed;
    private boolean shield;
    private final BufferedImage[] images;

    private boolean healBoost;
    private boolean extraLife;
    private boolean piercing;
    private boolean rapidFire;
    private boolean speedBoost;
    private boolean isShieldBubble;

    private double healTimer;
    private double rapidTimer;
    private double shieldTimer;
    private double speedTimer;
    private double pierceTimer;
    private double shootCooldown;
    private double iCooldown;

    private int move;

    public Player(ViewController viewController, ProgramController programController){
        super(viewController, programController);
        extraLife = false;
        piercing = false;
        shield = false;
        rapidFire = false;
        healBoost = false;
        speedBoost = false;
        isShieldBubble = false;
        speed = 400;

        healTimer = 2;
        pierceTimer = 5;
        shieldTimer = 5;
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
                createImage("src/main/resources/graphic/Spaceship.png"),
                createImage("src/main/resources/graphic/Spaceship_hurt.png"),
                createImage("src/main/resources/graphic/buffs/shield_bubble.png"),
                createImage("src/main/resources/graphic/buffs/speed_spaceship.png"),
                createImage("src/main/resources/graphic/buffs/heal_spaceship.png")
        };
    }

    /** Based on the Buff, draws different models of the Player
     * @param drawTool drawTool
     */
    @Override
    public void draw(DrawTool drawTool){
        if(iCooldown == 0) drawTool.drawImage(images[0], x, y);
        else drawTool.drawImage(images[1], x, y);
        if(isShieldBubble){
            drawTool.drawImage(images[2], programController.getPlayer().getX()-30, programController.getPlayer().getY()-10);
        }
        if(speedBoost){
            drawTool.drawImage(images[3], x, y);
        }
        if(healBoost){
            drawTool.drawImage(images[4], x, y);
        }
    }

    /**
     * Runs a Timer, when a certain Buff gets used, which cancels, if the Timers runs out. For every Buff (except HealthExtra), a Timer
     * @param dt dt
     */
    @Override
    public void update(double dt){
        if(x < 0) x = 0;
        if(x > Config.WINDOW_WIDTH - width) x = Config.WINDOW_WIDTH - width;
        iCooldown = Math.max(iCooldown - dt, 0);
        shootCooldown = Math.max(0, shootCooldown -dt);
        if(move == 0) x -= dt*speed;
        if(move == 2) x += dt*speed;
        if(shield){
            setShieldBubble(true);
            shieldTimer = Math.max (shieldTimer - dt, 0);
            if(shieldTimer == 0){
                setShield(false);
                setShieldBubble(false);
                shieldTimer = 5;
            }
        }
        if(rapidFire){
            rapidTimer = Math.max (rapidTimer - dt, 0);
            if(rapidTimer == 0){
                setRapidFire(false);
                rapidTimer = 5;
            }
        }
        if(speedBoost){
            speedTimer = Math.max (speedTimer - dt, 0);
            setSpeed(900);
            if(speedTimer == 0){
                setSpeedBoost(false);
                setSpeed(400);
                speedTimer = 5;
            }
        }
        if(piercing){
            pierceTimer = Math.max (pierceTimer - dt, 0);
            if(pierceTimer == 0){
                piercing = false;
                pierceTimer = 5;
            }
        }
        if(healBoost){
            healTimer = Math.max (healTimer - dt, 0);
            if(healTimer == 0){
                healBoost = false;
                healTimer = 5;
            }
        }
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

    public void setiCooldown(double iCooldown) {
        this.iCooldown = iCooldown;
    }

    public void setShieldBubble(boolean shieldBubble) {
        isShieldBubble = shieldBubble;
    }

    public void setHealBoost(boolean healBoost) {
        this.healBoost = healBoost;
    }
}

