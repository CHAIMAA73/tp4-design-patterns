package ma.enset.exercice1.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject : à chaque changement du score, tous les observateurs sont notifiés.
 */
public class Joueur implements Observable {
    private final String nom;
    private int score;
    private final List<Observer> observers = new ArrayList<>();

    public Joueur(String nom) {
        this.nom = nom;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public void setScore(int score) {
        this.score = score;
        notifyObservers();   // chaque changement de score déclenche la notification
    }

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }
}