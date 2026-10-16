package ma.enset.exercice1.composite;

/**
 * Component (pattern Composite) : abstraction commune aux figures simples et aux groupes.
 */
public abstract class Figure {
    protected String nom;

    public Figure(String nom) {
        this.nom = nom;
    }

    public abstract void dessiner(String indentation);

    public abstract double surface();
}