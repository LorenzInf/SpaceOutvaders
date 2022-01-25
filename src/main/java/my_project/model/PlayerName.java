package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import my_project.view.VisualList;

public class PlayerName extends Entity implements VisualList.AnimableList{


    public PlayerName(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        viewController.draw(this,6);
    }

    @Override
    public boolean tryToDelete() {
        return false;
    }
}
