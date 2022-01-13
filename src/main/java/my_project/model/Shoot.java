package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Shoot extends GraphicalObject {

    private double x,y,w,h,speed;
    private int shootR,shootG,shootB;

    public Shoot(double x, double y, double speed, int shootR, int shootG, int shootB){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.shootR = shootR;
        this.shootG = shootG;
        this.shootB = shootB;
        this.speed = speed;
    }

    public void draw(DrawTool drawtool){
        drawtool.setCurrentColor(shootR, shootG, shootB,255);
        drawtool.drawFilledRectangle(x,y,w,h);
    }

    @Override
    public void update(double dt){

    }
}
