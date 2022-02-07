package my_project.view;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.model.Enemy;
import my_project.model.EnemyFast;
import my_project.model.Entity;
import my_project.model.Shot;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends GraphicalWindow {

    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.viewController = viewController;
        this.programController = programController;
        viewController.createScene();
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                createImage("src/main/resources/graphic/maingame_blank.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
}
