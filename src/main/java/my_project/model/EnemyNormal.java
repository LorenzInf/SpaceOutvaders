package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import java.util.Random;

public class EnemyNormal extends Enemy {

    public EnemyNormal(ViewController viewController, ProgramController programController, boolean movingRight, int posX, int posY) {
        super(viewController, programController,movingRight,posX,posY);
        x += 27.5;
        y += 44;
        width = 120;
        height = 87;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[2], x, y);
    }
}