package ma.enset.exercice2.impl;

import ma.enset.exercice2.framework.Filtre;

/**
 * ConcreteStrategy : négatif de l'image (pixels entre 0 et 255).
 * Chaque pixel devient 255 - pixel : le noir devient blanc et inversement.
 */
public class FiltreNegatif implements Filtre {
    @Override
    public int[] filter(int[] data) {
        System.out.println("   [FiltreNegatif] application du négatif");
        int[] resultat = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            resultat[i] = 255 - data[i];
        }
        return resultat;
    }
}