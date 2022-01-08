package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Graph;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainMenu extends GraphicalWindow {

    private ProgramController programController;

    public MainMenu(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(load("/main_screen.png"), 0 ,0);
        switch(programController.getWindow().getButtonIndex()){
            case 1 -> drawTool.drawImage(load("main_screen_settings_selected.png"), 0 ,0);
            case 2 -> drawTool.drawImage(load("main_screen_play_selected.png"), 0 ,0);
            case 3 -> drawTool.drawImage(load("main_screen_leaderboard_selected.png"), 0 ,0);
            case 4 -> drawTool.drawImage(load("x_selected.png"), 0 ,0);
            case 5 -> drawTool.drawImage(load("main_screen_question_mark_selected.png"), 0 ,0);
        }
    }

    // Methode um Bilder zu malen, Parameter load -> Pfad des Bild
    private BufferedImage load (String name) {
        try {
            BufferedImage img = ImageIO.read((getClass().getResource("/graphic/" + name).openStream()));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
