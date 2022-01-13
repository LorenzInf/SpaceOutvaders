package my_project.control;

import my_project.Config;
import my_project.model.Player;
import KAGO_framework.control.ViewController;
import my_project.view.Game;
import my_project.view.Visual2DArray;

import java.awt.*;
import java.lang.reflect.Array;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Menu menu;
    private Player player;
    private GraphicalWindow window;
    private Visual2DArray array;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;

    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        array = new Visual2DArray<Game>(11, Config.WINDOW_HEIGHT / 175, 0 , 0, new Visual2DArray.VisualizationConfig(0,0, 175, 175, 0, true, false, false, null, Color.WHITE, new Color(0,0,0,0)));
        window = new GraphicalWindow(viewController, this);
        new InputManagerMainMenu(this, viewController);
        new InputManagerOptions(this, viewController, window.getOptions());
        new InputManagerGame(this, viewController);
        viewController.draw(array, 2);
        viewController.register(array);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public GraphicalWindow getWindow(){
        return window;
    }

}
