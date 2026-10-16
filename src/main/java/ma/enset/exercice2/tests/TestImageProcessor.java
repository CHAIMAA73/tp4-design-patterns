package ma.enset.exercice2.tests;

import ma.enset.exercice2.adapter.ImplNonStandardAdapter;
import ma.enset.exercice2.framework.ImageProcessor;
import ma.enset.exercice2.impl.CompressionEchantillonnage;
import ma.enset.exercice2.impl.CompressionRLE;
import ma.enset.exercice2.impl.FiltreNegatif;
import ma.enset.exercice2.impl.FiltreSeuil;

import java.util.Arrays;

/**
 * Test du framework complet : on change dynamiquement les implémentations
 * pendant l'exécution, sur le même objet ImageProcessor.
 */
public class TestImageProcessor {

    private static final int[] IMAGE = {10, 10, 10, 200, 200, 90, 90, 90, 90, 255, 255, 30};

    public static void main(String[] args) {
        System.out.println("Image d'origine : " + Arrays.toString(IMAGE));

        // Configuration initiale
        ImageProcessor processor = new ImageProcessor(new FiltreNegatif(), new CompressionRLE());
        traiter("1) FiltreNegatif + CompressionRLE", processor);

        // Changement dynamique du filtre : on utilise l'ancienne implémentation via l'adaptateur
        processor.setFiltre(new ImplNonStandardAdapter("INVERSE"));
        traiter("2) ImplNonStandard (INVERSE) + CompressionRLE", processor);

        // Changement dynamique du filtre ET du compresseur
        processor.setFiltre(new FiltreSeuil(100));
        processor.setCompresseur(new CompressionEchantillonnage());
        traiter("3) FiltreSeuil(100) + CompressionEchantillonnage", processor);
    }

    /** Filtre puis compresse l'image avec la configuration actuelle du processor. */
    private static void traiter(String titre, ImageProcessor processor) {
        System.out.println();
        System.out.println("=== " + titre);
        int[] filtree = processor.filter(IMAGE);
        System.out.println("Après filtrage    : " + Arrays.toString(filtree));
        int[] compressee = processor.compresser(filtree);
        System.out.println("Après compression : " + Arrays.toString(compressee));
    }
}
