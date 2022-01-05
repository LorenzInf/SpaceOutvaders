package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.view.*;

public class GraphicalWindow extends GraphicalObject {
    protected int buttonIndex;
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
        game = new Game(viewController);
        guide = new Guide(viewController);
        leaderboard = new Leaderboard(viewController);
        mainMenu = new MainMenu(viewController);
        options = new Options(viewController);
        viewController.draw(mainMenu,0);
        viewController.draw(options,1);
        viewController.draw(guide,2);
        viewController.draw(game,3);
        viewController.draw(leaderboard,4);
        buttonIndex = 1; //temp
    }

    public void switchScene(int index){
        viewController.showScene(index);
    }

    public int getButtonIndex(){
        return buttonIndex;
    }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    public void escape(){
        int index = viewController.getCurrentSceneIndex();
        switch (index) {
            case 0 -> System.exit(0);
            //case 3 -> /* todo*/
            default -> switchScene(0);
        }
    }
}

// sceneIndex 0 = MainMenu
// sceneIndex 1 = Options
// sceneIndex 2 = Guide
// sceneIndex 3 = Game
// sceneIndex 4 = Leaderboard