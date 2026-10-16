package ma.enset.exercice2.framework;

/**
 * Context (pattern Strategy) : point d'entrée du framework.
 * Il ne dépend que des abstractions Filtre et Compresseur, ce qui permet de
 * changer dynamiquement l'implémentation à l'exécution via les setters.
 */
public class ImageProcessor {
    private Filtre filtre;
    private Compresseur compresseur;

    public ImageProcessor() {
    }

    public ImageProcessor(Filtre filtre, Compresseur compresseur) {
        this.filtre = filtre;
        this.compresseur = compresseur;
    }

    public int[] filter(int[] data) {
        if (filtre == null) {
            throw new IllegalStateException("Aucune implémentation de filtrage n'est définie");
        }
        return filtre.filter(data);
    }

    public int[] compresser(int[] data) {
        if (compresseur == null) {
            throw new IllegalStateException("Aucune implémentation de compression n'est définie");
        }
        return compresseur.compresser(data);
    }

    public void setFiltre(Filtre filtre) {
        this.filtre = filtre;
    }

    public void setCompresseur(Compresseur compresseur) {
        this.compresseur = compresseur;
    }

    public Filtre getFiltre() {
        return filtre;
    }

    public Compresseur getCompresseur() {
        return compresseur;
    }
}