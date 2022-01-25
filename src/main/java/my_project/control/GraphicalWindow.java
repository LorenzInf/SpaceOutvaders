package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.view.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GraphicalWindow extends GraphicalObject {
    protected int mainMenuIndex, optionsIndex;
    protected ViewController viewController;
    protected ProgramController programController;
    private Game game;
    private Guide guide;
    private Leaderboard leaderboard;
    private MainMenu mainMenu;
    private Options options;
    private StartScreen startScreen;

    public GraphicalWindow(){}

    public GraphicalWindow(ViewController viewController, ProgramController programController) {
        this.viewController = viewController;
        this.programController = programController;

        startScreen = new StartScreen(viewController, programController);
        game = new Game(viewController, programController);
        guide = new Guide(viewController);
        leaderboard = new Leaderboard(viewController);
        mainMenu = new MainMenu(viewController, programController);
        options = new Options(viewController, programController);


        mainMenuIndex = 2;
        optionsIndex = 3;

        viewController.draw(startScreen, 0);
        viewController.draw(mainMenu,1);
        viewController.draw(options,2);
        viewController.draw(game,3);
        viewController.draw(leaderboard,4);
        viewController.draw(guide,5);


    }

    /**
     * Switches the scene to the given index
     * @param index index of the scene to switch to
     */
    public void switchScene(int index){
        viewController.showScene(index);
        if(index == 3) {
            SoundController.stopSound("mainMenuTheme");
            SoundController.playSound("gameTheme1");
        }

    }

    public int getOptionsIndex() {
        return optionsIndex;
    }

    public void setOptionsIndex(int optionsIndex) {
        this.optionsIndex = optionsIndex;
    }

    public int getMainMenuIndex(){
        return mainMenuIndex;
    }

    public void setMainMenuIndex(int mainMenuIndex) {
        this.mainMenuIndex = mainMenuIndex;
    }

    public Options getOptions() {
        return options;
    }

    public Game getGame() {
        return game;
    }
}

// sceneIndex 0 = MainMenu
// sceneIndex 1 = Options
// sceneIndex 2 = Guide
// sceneIndex 3 = Game
// sceneIndex 4 = Leaderboard