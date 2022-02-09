package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyFast extends Enemy {
    public EnemyFast(ViewController viewController, ProgramController programController, int posX, int posY) {
        super(viewController, programController,posX,posY);
        x += 20;
        y += 55;
        width = 135;
        height = 65;
        speed = 400 * (int) ((double) programController.getWaveController().getWave() / 20 + 1);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[5], x, y);
    }
}
