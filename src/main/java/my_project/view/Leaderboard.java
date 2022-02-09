package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class Leaderboard extends GraphicalWindow implements VisualList.AnimableList {

    private ProgramController programController;
    private BufferedImage[] images;

    public Leaderboard(ViewController viewController, ProgramController programController) {
        super();
        viewController.createScene();
        this.programController = programController;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/leaderboard.png")//0
        };
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0, 0);
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.formatText("Alagard", 0, 30);
        VisualList<EnterName> list = programController.getPlayerName().getList();
        list.toFirst();
        int i = 0;
        while (list.getCurrent() != null) {
            drawTool.drawText(100, 400 + (40 * i), programController.getPlayerName().getList().getCurrent().getName() + " Score: " + programController.getPlayerName().getList().getCurrent().getScore());
            list.next();
            i++;
        }
    }




    @Override
    public boolean tryToDelete() {
        return false;
    }
}