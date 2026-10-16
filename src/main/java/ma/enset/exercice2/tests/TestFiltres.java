package ma.enset.exercice2.tests;

import ma.enset.exercice2.framework.Filtre;
import ma.enset.exercice2.impl.FiltreNegatif;
import ma.enset.exercice2.impl.FiltreSeuil;

import java.util.Arrays;

/**
 * Test du pattern Strategy : le même code client utilise des filtres différents.
 */
public class TestFiltres {
    public static void main(String[] args) {
        int[] image = {10, 10, 10, 200, 200, 90, 90, 90, 90, 255, 255, 30};
        System.out.println("Image d'origine : " + Arrays.toString(image));
        System.out.println();

        // La variable est de type Filtre (l'interface) : on peut y mettre n'importe quel filtre
        Filtre filtre = new FiltreNegatif();
        System.out.println("Résultat : " + Arrays.toString(filtre.filter(image)));
        System.out.println();

        // On change de stratégie : le code d'appel reste exactement le même
        filtre = new FiltreSeuil(100);
        System.out.println("Résultat : " + Arrays.toString(filtre.filter(image)));
    }
}