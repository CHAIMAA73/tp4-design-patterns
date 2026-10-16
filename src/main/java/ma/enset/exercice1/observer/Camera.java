package ma.enset.exercice1.observer;

/**
 * ConcreteObserver.
 */
public class Camera implements Observer {
    @Override
    public void update(Observable observable) {
        if (observable instanceof Joueur j) {
            System.out.println("   Caméra : zoom sur " + j.getNom() + " (score = " + j.getScore() + ")");
        }
    }
}