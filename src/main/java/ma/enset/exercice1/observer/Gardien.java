package ma.enset.exercice1.observer;

/**
 * ConcreteObserver.
 */
public class Gardien implements Observer {
    @Override
    public void update(Observable observable) {
        if (observable instanceof Joueur j) {
            String reaction = j.getScore() >= 100 ? "augmente la difficulté du niveau" : "reste en patrouille";
            System.out.println("   Gardien : " + reaction + " (score = " + j.getScore() + ")");
        }
    }
}