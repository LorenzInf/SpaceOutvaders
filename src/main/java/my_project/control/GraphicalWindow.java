package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.view.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GraphicalWindow extends GraphicalObject {
    protected int mainMenuIndex;
    protected int optionsIndex;
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
        viewController.draw(mainMenu,0);
        viewController.draw(options,1);
        viewController.draw(game,2);
        viewController.draw(leaderboard,3);
        viewController.draw(guide,4);
        mainMenuIndex = 0;
        optionsIndex = 0;
    }

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

    public void escape(){
        int index = viewController.getCurrentSceneIndex();
        switch (index) {
            case 0 -> System.exit(0);
            //case 3 -> /* todo*/
            default -> switchScene(0);
        }
    }

    // Methode um Bilder zu malen, Parameter load -> Pfad des Bild
    public BufferedImage load (String name) {
        try {
            BufferedImage img = ImageIO.read((getClass().getResource("/graphic/" + name).openStream()));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Options getOptions() {
        return options;
    }
}

// sceneIndex 0 = MainMenu
// sceneIndex 1 = Options
// sceneIndex 2 = Guide
// sceneIndex 3 = Game
// sceneIndex 4 = Leaderboard