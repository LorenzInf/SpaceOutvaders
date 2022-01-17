package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Shoot extends GraphicalObject {

    private double speed;
    private int shootR,shootG,shootB;

    public Shoot(double x, double y, double width, double height, double speed, int shootR, int shootG, int shootB){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shootR = shootR;
        this.shootG = shootG;
        this.shootB = shootB;
        this.speed = speed;
    }

    public void draw(DrawTool drawtool){
        drawtool.setCurrentColor(shootR, shootG, shootB,255);
        drawtool.drawFilledRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt){

    }
}
