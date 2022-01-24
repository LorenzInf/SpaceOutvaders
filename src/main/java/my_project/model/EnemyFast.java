package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyFast extends Enemy {
    public EnemyFast(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        speed += speed; //TODO ??!???!?
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[5],x,y);
    }
}
