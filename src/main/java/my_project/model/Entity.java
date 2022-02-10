package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ProgramController;
import my_project.view.Visual2DArray;

public abstract class Entity extends GraphicalObject implements Visual2DArray.Animatable {

    protected final ViewController viewController;
    protected final ProgramController programController;

    public Entity(ViewController viewController, ProgramController programController){
        this.viewController = viewController;
        this.programController = programController;
    }

    @Override
    public void fadeIn() {

    }

    @Override
    public void fadeOut() {

    }
}
