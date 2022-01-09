package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

public class MainMenu extends GraphicalWindow {

    private ProgramController programController;

    public MainMenu(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(load("main_screen.png"), 0 ,0);
        switch(programController.getWindow().getMainMenuIndex()){
            case 1 -> drawTool.drawImage(load("main_screen_settings_selected.png"), 0 ,0);
            case 2 -> drawTool.drawImage(load("main_screen_play_selected.png"), 0 ,0);
            case 3 -> drawTool.drawImage(load("main_screen_leaderboard_selected.png"), 0 ,0);
            case 4 -> drawTool.drawImage(load("main_screen_question_mark_selected.png"), 0 ,0);
            case 5 -> drawTool.drawImage(load("x_selected.png"), 0 ,0);
        }
    }
}
