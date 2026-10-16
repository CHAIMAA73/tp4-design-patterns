package ma.enset.exercice2.adapter;

import ma.enset.exercice2.framework.Filtre;

/**
 * Adapter (version objet, par composition) : rend ImplNonStandard
 * utilisable par le framework comme n'importe quel Filtre.
 */
public class ImplNonStandardAdapter implements Filtre {
    private final ImplNonStandard implNonStandard = new ImplNonStandard();
    private final String filterName;

    public ImplNonStandardAdapter() {
        this("MOYENNE");
    }

    public ImplNonStandardAdapter(String filterName) {
        this.filterName = filterName;
    }

    @Override
    public int[] filter(int[] data) {
        // Traduction de l'appel : filter(data) -> appliquerFiltre(filterName, data)
        return implNonStandard.appliquerFiltre(filterName, data);
    }
}