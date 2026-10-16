package ma.enset.exercice1.composite;

public class MainComposite {
    public static void main(String[] args) {
        Groupe racine = new Groupe("G1");
        racine.ajouter(new Cercle("C1", 2));
        racine.ajouter(new Rectangle("R1", 3, 4));

        Groupe sousGroupe = new Groupe("G2");
        sousGroupe.ajouter(new Cercle("C2", 1));
        sousGroupe.ajouter(new Rectangle("R2", 5, 2));
        racine.ajouter(sousGroupe);

        racine.dessiner("");
        System.out.printf("Surface totale = %.2f%n", racine.surface());
    }
}