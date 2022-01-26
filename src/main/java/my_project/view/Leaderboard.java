package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Leaderboard extends GraphicalWindow {

    private ProgramController programController;
    private BufferedImage[] images;
    public Leaderboard(ViewController viewController) {
        super();
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawFilledRectangle(0,0, Config.WINDOW_WIDTH,Config.WINDOW_HEIGHT);
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawRectangle(10,10,1900,1070);
    }
}