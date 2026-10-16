package ma.enset.exercice2.impl;

import ma.enset.exercice2.framework.Filtre;

/**
 * ConcreteStrategy : binarisation (noir/blanc) selon un seuil.
 * Pixel >= seuil -> 255 (blanc), sinon -> 0 (noir).
 */
public class FiltreSeuil implements Filtre {
    private final int seuil;

    public FiltreSeuil() {
        this(128);
    }

    public FiltreSeuil(String seuil) {
        this(Integer.parseInt(seuil));
    }

    public FiltreSeuil(int seuil) {
        this.seuil = seuil;
    }

    @Override
    public int[] filter(int[] data) {
        System.out.println("   [FiltreSeuil] binarisation avec seuil = " + seuil);
        int[] resultat = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            resultat[i] = data[i] >= seuil ? 255 : 0;
        }
        return resultat;
    }
}