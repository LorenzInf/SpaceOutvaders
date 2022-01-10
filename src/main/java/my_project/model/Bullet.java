package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class Bullet extends GraphicalObject {

    private int radius;
    private double x,y;

    public Bullet(double x, double y){
        this.x = x;
        this.y = y;
        radius = 50;

    }

    public void draw(DrawTool drawTool){
        drawTool.drawFilledCircle(x,y,radius);
    }
    @Override
    public void update(double dt){

    }



}
