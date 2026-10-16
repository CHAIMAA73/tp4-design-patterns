package ma.enset.exercice1.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite : un groupe contient des figures (simples ou d'autres groupes).
 */
public class Groupe extends Figure {
    private final List<Figure> figures = new ArrayList<>();

    public Groupe(String nom) {
        super(nom);
    }

    public void ajouter(Figure figure) {
        figures.add(figure);
    }

    public void supprimer(Figure figure) {
        figures.remove(figure);
    }

    public List<Figure> getFigures() {
        return figures;
    }

    @Override
    public void dessiner(String indentation) {
        System.out.println(indentation + "Groupe " + nom + " :");
        for (Figure f : figures) {
            f.dessiner(indentation + "    ");
        }
    }

    @Override
    public double surface() {
        double total = 0;
        for (Figure f : figures) {
            total += f.surface();
        }
        return total;
    }
}