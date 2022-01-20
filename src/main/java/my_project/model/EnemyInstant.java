package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyInstant extends Enemy {
    public EnemyInstant(ViewController viewController, ProgramController programController){
        super(viewController,programController);
        instantShot = true;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[4],x,y);
    }

    @Override
    public void update(double dt){

    }
}
