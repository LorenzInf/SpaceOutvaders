package my_project.control;

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

    public GraphicalWindow(){}

    public GraphicalWindow(ViewController viewController, ProgramController programController) {
        this.viewController = viewController;
        this.programController = programController;

        game = new Game(viewController, programController);
        guide = new Guide(viewController);
        leaderboard = new Leaderboard(viewController);
        mainMenu = new MainMenu(viewController, programController);
        options = new Options(viewController, programController);

        mainMenuIndex = 2;
        optionsIndex = 1;

        viewController.draw(mainMenu,0);
        viewController.draw(options,1);
        viewController.draw(game,2);
        viewController.draw(leaderboard,3);
        viewController.draw(guide,4);
    }

    /**
     * Switches the scene to the given index
     * @param index index of the scene to switch to
     */
    public void switchScene(int index){
        viewController.showScene(index);
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

    public Guide getGuide() {
        return guide;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}

// sceneIndex 0 = MainMenu
// sceneIndex 1 = Options
// sceneIndex 2 = Guide
// sceneIndex 3 = Game
// sceneIndex 4 = Leaderboard