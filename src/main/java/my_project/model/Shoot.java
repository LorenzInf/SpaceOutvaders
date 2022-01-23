package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shoot extends GraphicalObject {

    private final ViewController viewController;
    private final double speed;
    private final int r, g, b, borderR, borderG, borderB;
    private final boolean enemyShot;
    private BufferedImage[] images;
    private ProgramController programController;

    public Shoot(ViewController viewController, double x, double y, double width, double height, double speed, int r, int g, int b, int borderR, int borderG, int borderB, boolean enemyShot, ProgramController programController){
        // Muss umgeschrieben werden, ob man jetzt Kago zeichnet oder eben ein Bild nutzt
        this.viewController = viewController;
        this.programController = programController;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.r = r;
        this.g = g;
        this.b = b;
        this.borderR = borderR;
        this.borderG = borderG;
        this.borderB = borderB;
        this.enemyShot = enemyShot;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/laser_shot.png"),
        };
    }

    public void draw(DrawTool drawTool){
        // Funktioniert noch nicht
        drawTool.drawTransformedImage(images[0], programController.getPlayer().getX(), programController.getPlayer().getY()-25, 0 ,0.3);
    }

    @Override
    public void update(double dt){
        // Ist auch noch buggy
        y += (enemyShot ? 1 : -1) * speed*dt;

        //wenn außerhalb des fensters, removeDrawable();
        if((0 - height) < y || y < (Window.HEIGHT + height)){
            viewController.removeDrawable(this);
        }
    }
}
