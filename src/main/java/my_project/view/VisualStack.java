package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;

public class VisualStack<T extends GraphicalObject & VisualStack.Animated> extends GraphicalObject{

    public interface Animated {

        void comeIn();
        void goOut();
    }

    private Stack<T> stack;
    private ViewController viewController;
    private int counter;

    public VisualStack(ViewController viewController){
        counter = 1;
        stack = new Stack<>();
        this.viewController = viewController;
    }

    /**
     * Die Methode pushInVisual() ist ziemlich ähnlich zu der Methode push() von der Datenstruktur Stack.
     * Es wird geprüft, ob das Objekt, welches hinzugefügt werden soll (@param contentType) null ist, wenn nicht, dann wird es:
     * in den Stack getan,
     * Methode comeIn() aufgerufen, die optional was machen kann,
     * x-Koordinate in abhängigkeit von counter gesetzt
     * gezeichnet + der counter um 1 erhöht
     */
    public void pushInVisual(T contentType) {
        if (contentType != null) {
            stack.push(contentType);
            contentType.comeIn();
// Eigentlich sollte der counter + setX() in der Ball Klasse/ die //Klasse die das implementiert
            contentType.setX(counter * (contentType.getRadius()*2));
            viewController.draw(contentType);
            counter++;
        }
    }

    /**
     * Die Methode popVisual ist ähnlich zu pop() in Stack.
     * Es wird erst geprüft, ob stack leer ist, wenn ja, dann passiert nichts, sonst:
     * wird goOut() aufgerufen
     * wird die "oberste" Zeichnung entfernt,
     * wird das oberste Objekt von Stack entfernt
     * und der counter -1 gerechnet
     */
    public void popVisual(){
        if(!stack.isEmpty()){
            stack.top().goOut();
            viewController.removeDrawable(stack.top());
            stack.pop();
            counter--;
        }
    }
}

