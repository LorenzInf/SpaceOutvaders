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
        drawTool.drawImage(images[3],x,y);
    }
}
