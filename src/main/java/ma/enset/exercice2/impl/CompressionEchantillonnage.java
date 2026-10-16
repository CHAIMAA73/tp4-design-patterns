package ma.enset.exercice2.impl;

import ma.enset.exercice2.framework.Compresseur;

/**
 * ConcreteClass (Template Method) : compression avec perte,
 * on garde un pixel sur deux.
 */
public class CompressionEchantillonnage extends Compresseur {
    @Override
    protected int[] compresserDonnees(int[] data) {
        int[] resultat = new int[(data.length + 1) / 2];
        for (int i = 0; i < resultat.length; i++) {
            resultat[i] = data[i * 2];
        }
        return resultat;
    }
}