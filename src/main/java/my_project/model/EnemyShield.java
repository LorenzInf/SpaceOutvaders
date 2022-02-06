package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyShield extends Enemy {
    public EnemyShield(ViewController viewController, ProgramController programController){
        super(viewController,programController);
        hp = 2;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[3],x - 180,y - 170,0,0.2);
        if(hp > 1) drawTool.drawTransformedImage(images[6],x - 180,y - 170,0,0.2);
    }

    @Override
    public void update(double dt){

    }
}
