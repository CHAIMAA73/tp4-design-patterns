package ma.enset.exercice2.framework;

import java.util.Arrays;

/**
 * AbstractClass (pattern Template Method).
 * compresser() définit le squelette de l'algorithme de compression ;
 * les sous-classes ne fournissent que le détail (compresserDonnees).
 */
public abstract class Compresseur {

    /** Le squelette : final pour que les sous-classes ne puissent pas changer l'ordre des étapes. */
    public final int[] compresser(int[] data) {
        verifier(data);
        int[] copie = preparer(data);
        int[] resultat = compresserDonnees(copie);
        afficherTaux(data, resultat);
        return resultat;
    }

    /** Étape commune : validation des données. */
    private void verifier(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Les données de l'image sont nulles");
        }
    }

    /** Étape commune (hook) : par défaut on travaille sur une copie pour ne pas modifier l'original. */
    protected int[] preparer(int[] data) {
        return Arrays.copyOf(data, data.length);
    }

    /** Étape variable : déléguée aux sous-classes. */
    protected abstract int[] compresserDonnees(int[] data);

    /** Étape commune : afficher le taux de compression. */
    private void afficherTaux(int[] avant, int[] apres) {
        if (avant.length == 0) return;
        double taux = 100.0 * (1 - (double) apres.length / avant.length);
        System.out.printf("   [Compresseur] %d -> %d éléments (gain %.1f %%)%n", avant.length, apres.length, taux);
    }
}