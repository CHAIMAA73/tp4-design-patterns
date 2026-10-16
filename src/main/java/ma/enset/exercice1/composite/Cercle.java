package ma.enset.exercice1.composite;

/**
 * Leaf (pattern Composite).
 */
public class Cercle extends Figure {
    private double rayon;

    public Cercle(String nom, double rayon) {
        super(nom);
        this.rayon = rayon;
    }

    @Override
    public void dessiner(String indentation) {
        System.out.println(indentation + "Cercle " + nom + " (rayon=" + rayon + ")");
    }

    @Override
    public double surface() {
        return Math.PI * rayon * rayon;
    }
}