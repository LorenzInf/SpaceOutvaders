package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Leaderboard extends GraphicalWindow implements VisualList.AnimableList {

    private ProgramController programController;
    private BufferedImage[] images;

    public Leaderboard(ViewController viewController) {
        super();
        viewController.createScene();
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/leaderboard.png")//0
        };
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
    public void beFirst(){

    }


    @Override
    public boolean tryToDelete() {
        return false;
    }
}