package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class MainMenu extends GraphicalWindow {

    private ProgramController programController;
    private BufferedImage[] images;

    public MainMenu(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        viewController.createScene();
        images = new BufferedImage[]{
                load("main_screen.png"), //0
                load("main_screen_settings_selected.png"), //1
                load("main_screen_play_selected.png"), //2
                load("main_screen_leaderboard_selected.png"), //3
                load("main_screen_question_mark_selected.png"), //4
                load("x_selected.png") //5
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[0], 0 ,0);
        switch(programController.getWindow().getMainMenuIndex()){
            case 1 -> drawTool.drawImage(images[1], 0 ,0);
            case 2 -> drawTool.drawImage(images[2], 0 ,0);
            case 3 -> drawTool.drawImage(images[3], 0 ,0);
            case 4 -> drawTool.drawImage(images[4], 0 ,0);
            case 5 -> drawTool.drawImage(images[5], 0 ,0);
        }
    }
}
