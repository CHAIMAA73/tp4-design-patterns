package ma.enset.exercice2.app;

import ma.enset.exercice2.framework.Compresseur;
import ma.enset.exercice2.framework.Filtre;
import ma.enset.exercice2.framework.ImageProcessor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Application cliente du framework.
 * L'utilisateur saisit le nom complet des classes d'implémentation ;
 * elles sont instanciées dynamiquement par réflexion (Class.forName).
 * Syntaxe acceptée : "nom.de.la.Classe" ou "nom.de.la.Classe:parametre"
 * (le paramètre est passé à un constructeur qui prend un String).
 */
public class Application {

    private static final int[] IMAGE = {10, 10, 10, 200, 200, 90, 90, 90, 90, 255, 255, 30};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImageProcessor processor = new ImageProcessor();

        System.out.println("=== Framework de traitement d'images ===");
        System.out.println("Image : " + Arrays.toString(IMAGE));
        afficherAide();

        while (true) {
            System.out.println();
            System.out.println("1) Choisir le filtre   2) Choisir le compresseur");
            System.out.println("3) Filtrer l'image     4) Compresser l'image");
            System.out.println("5) Filtrer puis compresser   0) Quitter");
            System.out.print("Votre choix : ");
            if (!scanner.hasNextLine()) break;
            String choix = scanner.nextLine().trim();

            try {
                switch (choix) {
                    case "1" -> {
                        System.out.print("Classe du filtre : ");
                        processor.setFiltre(creer(scanner.nextLine().trim(), Filtre.class));
                        System.out.println("Filtre actif : " + processor.getFiltre().getClass().getSimpleName());
                    }
                    case "2" -> {
                        System.out.print("Classe du compresseur : ");
                        processor.setCompresseur(creer(scanner.nextLine().trim(), Compresseur.class));
                        System.out.println("Compresseur actif : " + processor.getCompresseur().getClass().getSimpleName());
                    }
                    case "3" -> System.out.println("Résultat : " + Arrays.toString(processor.filter(IMAGE)));
                    case "4" -> System.out.println("Résultat : " + Arrays.toString(processor.compresser(IMAGE)));
                    case "5" -> {
                        int[] filtree = processor.filter(IMAGE);
                        System.out.println("Après filtrage    : " + Arrays.toString(filtree));
                        System.out.println("Après compression : " + Arrays.toString(processor.compresser(filtree)));
                    }
                    case "0" -> {
                        System.out.println("Au revoir !");
                        return;
                    }
                    default -> System.out.println("Choix invalide");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Erreur : classe introuvable -> " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    /**
     * Instanciation dynamique d'une implémentation à partir de son nom de classe.
     * Vérifie aussi que la classe est bien du type attendu (Filtre ou Compresseur).
     */
    static <T> T creer(String saisie, Class<T> type) throws Exception {
        String[] parties = saisie.split(":", 2);
        Class<?> c = Class.forName(parties[0]);
        if (!type.isAssignableFrom(c)) {
            throw new IllegalArgumentException(c.getName() + " n'est pas un(e) " + type.getSimpleName());
        }
        Object instance = parties.length == 2
                ? c.getConstructor(String.class).newInstance(parties[1])
                : c.getDeclaredConstructor().newInstance();
        return type.cast(instance);
    }

    private static void afficherAide() {
        System.out.println("Implémentations disponibles :");
        System.out.println("  Filtres      : ma.enset.exercice2.impl.FiltreNegatif");
        System.out.println("                 ma.enset.exercice2.impl.FiltreSeuil   (ex. ...FiltreSeuil:100)");
        System.out.println("                 ma.enset.exercice2.adapter.ImplNonStandardAdapter (ex. ...:INVERSE ou :MOYENNE)");
        System.out.println("  Compresseurs : ma.enset.exercice2.impl.CompressionRLE");
        System.out.println("                 ma.enset.exercice2.impl.CompressionEchantillonnage");
    }
}
