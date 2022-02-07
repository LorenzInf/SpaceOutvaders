package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyShield extends Enemy {

    public EnemyShield(ViewController viewController, ProgramController programController, boolean movingRight, int posX, int posY){
        super(viewController,programController,movingRight,posX,posY);
        hp = 2;
        x += 18;
        y += 19.5;
        width = 139;
        height = 136;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[3], x, y);
        if(hp > 1) drawTool.drawImage(images[6], x, y);
    }
}
