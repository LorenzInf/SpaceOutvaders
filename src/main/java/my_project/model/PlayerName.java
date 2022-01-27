package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.view.VisualList;

import java.awt.image.BufferedImage;


public class PlayerName extends Entity implements VisualList.AnimableList{

    private VisualList<PlayerName> playerNameList;
    private BufferedImage[] images;
    private PlayerName playername;



    public PlayerName(int x, int y,ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        viewController.draw(this, GraphicalWindow.ENTER_NAME_INDEX);
        playerNameList = new VisualList<>(173,175,x,y);
        this.x = x;
        this.y = y;
        //173,175 array ding
        //playerNameList.append();
        images = new BufferedImage[]{

        };

    }

    @Override
    public boolean tryToDelete() {
        return false;
    }
}
