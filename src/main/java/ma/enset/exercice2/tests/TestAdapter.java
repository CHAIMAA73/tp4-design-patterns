package ma.enset.exercice2.tests;

import ma.enset.exercice2.adapter.ImplNonStandardAdapter;
import ma.enset.exercice2.framework.Filtre;

import java.util.Arrays;

/**
 * Test du pattern Adapter : l'ancienne implémentation est utilisée
 * à travers l'interface Filtre, comme n'importe quel autre filtre.
 */
public class TestAdapter {
    public static void main(String[] args) {
        int[] image = {10, 10, 10, 200, 200, 90, 90, 90, 90, 255, 255, 30};
        System.out.println("Image d'origine : " + Arrays.toString(image));
        System.out.println();

        // Le code client ne voit qu'un Filtre : il ne sait pas qu'il y a une ancienne classe derrière
        Filtre filtre = new ImplNonStandardAdapter("INVERSE");
        System.out.println("Résultat : " + Arrays.toString(filtre.filter(image)));
        System.out.println();

        filtre = new ImplNonStandardAdapter("MOYENNE");
        System.out.println("Résultat : " + Arrays.toString(filtre.filter(image)));
    }
}