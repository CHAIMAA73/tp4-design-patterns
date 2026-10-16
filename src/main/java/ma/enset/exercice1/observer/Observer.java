package ma.enset.exercice1.observer;

/**
 * Observer : Joueur ne connaît que cette interface (couplage faible).
 */
public interface Observer {
    void update(Observable observable);
}