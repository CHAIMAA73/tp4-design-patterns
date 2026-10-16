package ma.enset.exercice2.adapter;

/**
 * Adaptee (pattern Adapter) : ancienne implémentation dont la signature
 * n'est pas compatible avec l'interface Filtre du framework.
 * On considère qu'on ne peut pas modifier cette classe.
 */
public class ImplNonStandard {

    public int[] appliquerFiltre(String filterName, int[] data) {
        int[] resultat = new int[data.length];
        switch (filterName.toUpperCase()) {
            case "INVERSE" -> {
                for (int i = 0; i < data.length; i++) {
                    resultat[i] = data[data.length - 1 - i];
                }
            }
            case "MOYENNE" -> {
                for (int i = 0; i < data.length; i++) {
                    int gauche = data[Math.max(0, i - 1)];
                    int droite = data[Math.min(data.length - 1, i + 1)];
                    resultat[i] = (gauche + data[i] + droite) / 3;
                }
            }
            default -> System.arraycopy(data, 0, resultat, 0, data.length);
        }
        System.out.println("   [ImplNonStandard] filtre '" + filterName + "' appliqué");
        return resultat;
    }
}