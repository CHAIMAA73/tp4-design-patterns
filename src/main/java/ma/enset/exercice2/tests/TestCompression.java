package ma.enset.exercice2.tests;

import ma.enset.exercice2.framework.Compresseur;
import ma.enset.exercice2.impl.CompressionEchantillonnage;
import ma.enset.exercice2.impl.CompressionRLE;

import java.util.Arrays;

/**
 * Test du pattern Template Method : même squelette, détail différent.
 */
public class TestCompression {
    public static void main(String[] args) {
        int[] image = {10, 10, 10, 200, 200, 90, 90, 90, 90, 255, 255, 30};
        System.out.println("Image d'origine : " + Arrays.toString(image));
        System.out.println();

        System.out.println("=== Compression RLE");
        Compresseur compresseur = new CompressionRLE();
        System.out.println("Résultat : " + Arrays.toString(compresseur.compresser(image)));
        System.out.println();

        System.out.println("=== Compression par échantillonnage");
        compresseur = new CompressionEchantillonnage();
        System.out.println("Résultat : " + Arrays.toString(compresseur.compresser(image)));
    }
}