package ma.enset.exercice1.decorator;

/**
 * ConcreteComponent : composant existant dont on ne modifie pas le code source.
 */
public class ComposantImpl implements Composant {
    @Override
    public void traitement() {
        System.out.println("   >> Traitement principal du composant");
    }
}