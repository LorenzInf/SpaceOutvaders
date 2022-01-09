package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;

import javax.swing.text.View;

public class Player extends GraphicalObject {
    private int speed;
    private int hp;
    private boolean shield;
    private int buff;
    private ViewController viewController;

    public Player(int speed, int hp, boolean shield, int buff, ViewController viewController){
        this.speed = speed;
        this.hp = hp;
        this.shield = false;
        this.buff = ((int)(Math.random()*4));
    }

        public void shootMoreThanOneBullet(){

        }
        public void shoot(){

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
        if(buff == 1){

            speed = speed *2;

        }else if(buff == 2){

            hp = hp + hp/4;

        }else if(buff == 3){

            shield = true; //Muss ich mir noch was überlegen

        }else if(buff == 4){

            speed = speed/2;

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
