package ma.enset.exercice1.plugin;

/**
 * AbstractClass (pattern Template Method).
 * operation() est le squelette de l'algorithme : elle est final pour qu'on ne puisse pas
 * changer l'ordre des étapes ; partie1() et partie2() sont les parties variables.
 */
public abstract class Plugin {

    public final void operation() {
        System.out.println("[Plugin] Début de l'algorithme");
        partie1();
        System.out.println("[Plugin] Étape commune entre partie1 et partie2");
        partie2();
        System.out.println("[Plugin] Fin de l'algorithme");
    }

    protected abstract void partie1();

    protected abstract void partie2();
}