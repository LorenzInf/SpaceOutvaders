package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyFast extends Enemy {
    public EnemyFast(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[5],x - 115,y - 100,0,0.35);
    }
}
