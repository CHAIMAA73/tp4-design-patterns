package ma.enset.exercice1.decorator;

/**
 * Decorator abstrait : implémente Composant ET contient une référence vers un Composant.
 */
public abstract class Decorateur implements Composant {
    protected final Composant composant;

    protected Decorateur(Composant composant) {
        this.composant = composant;
    }

    @Override
    public void traitement() {
        composant.traitement();
    }
}