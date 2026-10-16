package ma.enset.exercice1.observer;

/**
 * Subject (pattern Observer) : objet observé.
 */
public interface Observable {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}