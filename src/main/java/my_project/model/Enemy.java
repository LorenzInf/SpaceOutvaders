package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;

public class Enemy extends GraphicalObject {
    private ViewController viewController;
    private int damage;
    private int speed;

    public Enemy(ViewController viewController){

    }

    //Jedes mal wenn er sich bewegt und kein Gegner unter ihm ist hat er eine x Prozent chance nach unten zu schießen (würde 0.5% oder so vorschlagen, muss man ausprobieren)

    @Override
    public void update(double dt){

    }



}
