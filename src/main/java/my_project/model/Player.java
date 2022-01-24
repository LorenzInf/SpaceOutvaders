package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class Player extends Entity {

    private int arrayX;
    private String name;
    private int speed;
    private int hp;
    private boolean shield;
    private int buff;
    private final BufferedImage[] images;


    public Player(int arrayX, int speed, int hp, boolean shield, int buff, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.arrayX = arrayX;
        this.speed = speed;
        this.hp = hp;
        this.shield = false;
        this.buff = ((int)(Math.random()*4));
        viewController.draw(this, 2);
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/Spaceship.png"), // 0
                createImage("src/main/resources/graphic/laser_shot.png"), // 1
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[0], x, y, 0 , 0.53);
        drawTool.drawTransformedImage(images[1], -2000, y, 0 , 2);
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

    //https://www.microsoft.com/en-us/software-download/windows11

    public int getArrayX() {
        return arrayX;
    }

    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }
}
