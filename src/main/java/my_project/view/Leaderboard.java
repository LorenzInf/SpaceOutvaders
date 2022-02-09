package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Leaderboard extends GraphicalWindow implements VisualList.AnimableList {

    private ProgramController programController;
    private BufferedImage[] images;
    //private final File userDataFile;

    public Leaderboard(ViewController viewController, ProgramController programController) {
        super();
        viewController.createScene();
        this.programController = programController;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/leaderboard.png")//0
        };
        //leaderboard = new File("src/database/Users.txt");
        //String usersString = getFileContent(userDataFile);
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.formatText("Alagard",0,30);
        drawTool.drawText(100,400,programController.getPlayerName().getList().getCurrent().getName() + "Score:" + programController.getPlayerName().getList().getCurrent());
        /*while(programController.getPlayerName().getList().getCurrent() != null){
            programController.getPlayerName().getList().toFirst();
            drawTool.drawText(100,400,programController.getPlayerName().getList().getCurrent().getName() + "Score:" + programController.getPlayerName().getList().getCurrent());

        }*/
    }




    @Override
    public boolean tryToDelete() {
        return false;
    }
}