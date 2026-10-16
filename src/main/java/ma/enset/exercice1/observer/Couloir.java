package ma.enset.exercice1.observer;

/**
 * ConcreteObserver.
 */
public class Couloir implements Observer {
    @Override
    public void update(Observable observable) {
        if (observable instanceof Joueur j) {
            System.out.println("   Couloir : le score de " + j.getNom() + " est maintenant " + j.getScore());
        }
    }
}