package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Shoot extends GraphicalObject {

    private final ViewController viewController;
    private final double speed;
    private final int r, g, b, borderR, borderG, borderB;
    private final boolean enemyShot;

    public Shoot(ViewController viewController, double x, double y, double width, double height, double speed, int r, int g, int b, int borderR, int borderG, int borderB, boolean enemyShot){
        this.viewController = viewController;
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
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r, g, b,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(borderR,borderB,borderG,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt){
        y += (enemyShot ? 1 : -1) * speed*dt;

        //wenn außerhalb des fensters, removeDrawable();
        if((0 - height) < y || y < (Window.HEIGHT + height)){
            viewController.removeDrawable(this);
        }
    }
}
