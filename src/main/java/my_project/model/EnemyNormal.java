package my_project.model;

import KAGO_framework.view.DrawTool;

import java.util.Random;

public class EnemyNormal extends Enemy {
    public EnemyNormal(int x, int y){
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[2],x,y);
    }

    @Override
    public void update(double dt){
        tryToShoot(dt);
    }
}
