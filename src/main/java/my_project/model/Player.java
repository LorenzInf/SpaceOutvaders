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
    private int hp;
    private boolean shield;
    private int buff;
    private boolean extraLife;
    private final BufferedImage[] images;
    private double moveCooldown;
    private double shootCooldown;
    private int move;

    public Player(int arrayX, boolean extraLife, int speed, int hp, boolean shield, int buff, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.arrayX = arrayX;
        this.extraLife = false;
        this.speed = speed;
        this.hp = hp;
        this.shield = false;
        this.buff = ((int)(Math.random()*4));
        moveCooldown = 0;
        shootCooldown = 0;
        width = 100;
        height = 100;
        x = 865;
        y = 875;
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/Spaceship.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[0], x-32.5, y-70, 0 , 0.7);
    }

    /**
     *
     * @param dt
     * wenn buff 1 ist, wird die Geschwindigkeit das doppelte
     * wenn buff 2 ist, werden die hp um ein viertel erhöht
     * wenn buff 3 ist, wird shield true
     * wenn buff 4 ist, wird der player verlangsamt
     */
    @Override
    public void update(double dt){
        moveCooldown = Math.max(0, moveCooldown -dt);
        shootCooldown = Math.max(0, shootCooldown -dt);
        switch(buff){
            case 1 -> speed *= (int) Math.random()*3+1;
            case 2 -> hp += hp/4;
            case 3 -> shield = true; //TODO
            case 4 -> speed /= 2;
        }
        if(move == 0) x -= dt*300;
        if(move == 2) x += dt*300;
    }

    public int getArrayX() {
        return arrayX;
    }

    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }

    public double getMoveCooldown() {
        return moveCooldown;
    }

    public void setMoveCooldown(double moveCooldown) {
        this.moveCooldown = moveCooldown;
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
}

