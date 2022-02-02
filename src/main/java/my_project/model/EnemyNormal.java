package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import java.util.Random;

public class EnemyNormal extends Enemy {

    public EnemyNormal(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        radius = 50;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[2],x-22,y-15, 0 , 0.6);
    }
}