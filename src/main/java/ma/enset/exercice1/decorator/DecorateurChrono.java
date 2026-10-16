package ma.enset.exercice1.decorator;

/**
 * ConcreteDecorator : mesure le temps d'exécution du traitement.
 */
public class DecorateurChrono extends Decorateur {

    public DecorateurChrono(Composant composant) {
        super(composant);
    }

    @Override
    public void traitement() {
        long debut = System.nanoTime();
        System.out.println("[Chrono] Démarrage du chronomètre");
        super.traitement();
        long duree = System.nanoTime() - debut;
        System.out.println("[Chrono] Durée = " + duree / 1000 + " µs");
    }
}