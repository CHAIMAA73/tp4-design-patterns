package ma.enset.exercice2.framework;

/**
 * Strategy : contrat de l'opération de filtrage.
 * L'utilisateur du framework peut écrire ses propres implémentations
 * (ouvert à l'extension) sans modifier le framework (fermé à la modification).
 */
public interface Filtre {
    int[] filter(int[] data);
}