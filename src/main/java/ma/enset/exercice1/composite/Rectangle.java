package ma.enset.exercice1.composite;

/**
 * Leaf (pattern Composite).
 */
public class Rectangle extends Figure {
    private double largeur;
    private double hauteur;

    public Rectangle(String nom, double largeur, double hauteur) {
        super(nom);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(String indentation) {
        System.out.println(indentation + "Rectangle " + nom + " (" + largeur + " x " + hauteur + ")");
    }

    @Override
    public double surface() {
        return largeur * hauteur;
    }
}