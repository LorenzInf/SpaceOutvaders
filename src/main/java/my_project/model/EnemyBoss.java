package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyBoss extends Enemy {
    public EnemyBoss(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0],x,y);
    }
    @Override
    public void update(double dt){

    }

}
