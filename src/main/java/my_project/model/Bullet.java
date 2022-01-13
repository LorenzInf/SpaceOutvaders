package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class Bullet extends GraphicalObject {

    private int radiusBu,buR,buG,buB;
    private double xBu,yBu;

    public Bullet(double xBu, double yBu, int buR, int buG, int buB, int radiusBu){
        this.xBu = xBu;
        this.yBu = yBu;
        this.buR = buR;
        this.buG = buG;
        this.buB = buB;
        this.radiusBu = radiusBu;
    }


    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(buR,buG,buB,255);
        drawTool.drawFilledCircle(xBu,yBu,radius);
    }
    @Override
    public void update(double dt){

    }



    public int getRadiusBu() {
        return radiusBu;
    }

    public double getxBu() {
        return xBu;
    }

    public void setxBu(double xBu) {
        this.xBu = xBu;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getyBu() {
        return yBu;
    }

    public void setyBu(double yBu) {
        this.yBu = yBu;
    }
}
