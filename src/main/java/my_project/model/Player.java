package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ProgramController;
import my_project.view.Game;

import javax.swing.text.View;
import java.awt.image.BufferedImage;

public class Player extends Game {

    private BufferedImage Spaceship;
    private String name;
    private int speed;
    private int hp;
    private boolean shield;
    private int buff;
    private ViewController viewController;
    private ProgramController programController;
    private BufferedImage[] images;

    public Player(int speed, int hp, boolean shield, int buff, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.speed = speed;
        this.hp = hp;
        this.shield = false;
        this.buff = ((int)(Math.random()*4));
        images = new BufferedImage[]{
                load("Spaceship.png"), // 1
        };
        viewController.draw(this, 2);
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
        //hab die ganzen if's mal zu nem switch case gemacht - Lorenz
        switch(buff){
            case 1 -> speed *= 2; //Wir müssen uns noch überlegen wie speed funktioniert, wenn man sich in Feldern belegt
            case 2 -> hp += hp/4;
            case 3 -> shield = true; //TODO
            case 4 -> speed /= 2;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }
}
