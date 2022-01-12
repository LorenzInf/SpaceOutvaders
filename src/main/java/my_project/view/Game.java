package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends GraphicalWindow {

    private ProgramController programController;
    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                load("maingame_blank.png"),
                load("Spaceship.png"), // 0
                // ToDo: Alle Bilder reinpacken
        };
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
        drawTool.drawTransformedImage(images[1], 666,700, 0 ,0.5);
    }
}
