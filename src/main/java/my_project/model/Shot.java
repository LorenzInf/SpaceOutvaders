package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shot extends Entity {

    private final ViewController viewController;
    private final double speed;
    private final boolean enemyShot;
    private BufferedImage[] images;
    private ProgramController programController;

    public Shot(ViewController viewController, double x, double y, double speed, boolean enemyShot, ProgramController programController){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.enemyShot = enemyShot;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/laser_shot.png"),
        };
    }

    public void draw(DrawTool drawTool){
        // Funktioniert noch nicht
        drawTool.drawTransformedImage(images[0], programController.getPlayer().getX()+92.5, programController.getPlayer().getY()-55, 0 ,0.25);
    }

    @Override
    public void update(double dt){
        // Ist auch noch buggy
        //y += /*(enemyShot ? 1 : -1) + speed+*/ 10*dt;
        y -= 50*dt;

        //wenn außerhalb des fensters, removeDrawable();
        if(y < (0 - height) || y > (1080 + height)){
            System.out.println(Window.HEIGHT);
            viewController.removeDrawable(this);
        }
    }
}
