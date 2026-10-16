package ma.enset.exercice1.decorator;

/**
 * ConcreteDecorator : ajoute une trace avant et après le traitement.
 */
public class DecorateurLog extends Decorateur {

    public DecorateurLog(Composant composant) {
        super(composant);
    }

    @Override
    public void traitement() {
        System.out.println("[Log] Avant traitement");
        super.traitement();
        System.out.println("[Log] Après traitement");
    }
}