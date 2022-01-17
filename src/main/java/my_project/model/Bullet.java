package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class Bullet extends GraphicalObject {

    private int r,g,b;

    public Bullet(double x, double y, int r, int g, int b, double radius){
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.radius = radius;
    }


    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,radius);
    }

    @Override
    public void update(double dt){

    }



    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
