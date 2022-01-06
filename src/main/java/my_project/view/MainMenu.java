package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Graph;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainMenu extends GraphicalWindow {

    public MainMenu(ViewController viewController) {
        super();
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        try {
            BufferedImage mainScreen = ImageIO.read((getClass().getResource("/graphic/main_screen.png").openStream()));
            drawTool.drawImage(mainScreen, 0 , 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
