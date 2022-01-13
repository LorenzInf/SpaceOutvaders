package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.model.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends GraphicalWindow implements Visual2DArray.Animatable {

    private ProgramController programController;
    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                load("maingame_blank.png")
        };
        System.out.println(images);
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }

    @Override
    public void fadeIn() {
    }

    @Override
    public void fadeOut() {
    }
}
