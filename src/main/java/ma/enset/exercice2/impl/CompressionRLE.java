package ma.enset.exercice2.impl;

import ma.enset.exercice2.framework.Compresseur;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteClass (Template Method) : Run-Length Encoding (sans perte).
 * [5,5,5,7,7] -> [3,5, 2,7]  (nombre d'occurrences, valeur)
 */
public class CompressionRLE extends Compresseur {
    @Override
    protected int[] compresserDonnees(int[] data) {
        List<Integer> sortie = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int valeur = data[i];
            int compteur = 1;
            while (i + compteur < data.length && data[i + compteur] == valeur) {
                compteur++;
            }
            sortie.add(compteur);
            sortie.add(valeur);
            i += compteur;
        }
        return sortie.stream().mapToInt(Integer::intValue).toArray();
    }
}