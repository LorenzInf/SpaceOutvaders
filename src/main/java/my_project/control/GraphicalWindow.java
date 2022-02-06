package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.Sound;
import my_project.view.*;

public class GraphicalWindow extends GraphicalObject {
    public static int START_SCREEN_INDEX = 0, MAIN_MENU_INDEX = 1, OPTIONS_INDEX = 2, GAME_INDEX = 3, LEADERBOARD_INDEX = 4, GUIDE_INDEX = 5, ENTER_NAME_INDEX = 6;
    protected int mainMenuIndex, optionsIndex;
    protected ViewController viewController;
    protected ProgramController programController;
    private Game game;
    private Guide guide;
    private Leaderboard leaderboard;
    private MainMenu mainMenu;
    private Options options;
    private StartScreen startScreen;
    private EnterName enterName;
    private FadeIn fadeIn;

    public GraphicalWindow(){}

    public GraphicalWindow(ViewController viewController, ProgramController programController) {
        this.viewController = viewController;
        this.programController = programController;

        startScreen = new StartScreen(viewController);
        game = new Game(viewController, programController);
        guide = new Guide(viewController);
        leaderboard = new Leaderboard(viewController);
        mainMenu = new MainMenu(viewController, programController);
        options = new Options(viewController, programController);
        enterName = new EnterName(viewController,programController);
        fadeIn = new FadeIn(viewController);

        mainMenuIndex = 2;
        optionsIndex = 3;

        viewController.draw(startScreen, START_SCREEN_INDEX);
        viewController.draw(mainMenu, MAIN_MENU_INDEX);
        viewController.draw(options, OPTIONS_INDEX);
        viewController.draw(game, GAME_INDEX);
        viewController.draw(leaderboard, LEADERBOARD_INDEX);
        viewController.draw(guide, GUIDE_INDEX);
        viewController.draw(enterName, ENTER_NAME_INDEX);
    }

    /**
     * Switches the scene to the given index
     * @param index index of the scene to switch to
     */
    public void switchScene(int index){
        if(index == 3) {
            SoundController.stopSound("mainMenuTheme");
            SoundController.playSound("gameTheme1");
            fadeIn.fadeIn(0,4,index);
        }
        if(index == 6){
            SoundController.stopSound("gameTheme1");
            SoundController.playSound("gameover");
            fadeIn.fadeIn(0,4,index);
        }
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
}

// sceneIndex 0 = MainMenu
// sceneIndex 1 = Options
// sceneIndex 2 = Guide
// sceneIndex 3 = Game
// sceneIndex 4 = Leaderboard
// sceneIndex 5 = guide
// sceneIndex 6 = enterName