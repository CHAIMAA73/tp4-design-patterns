package ma.enset.exercice1.plugin;

/**
 * ConcreteClass (Template Method) écrite par le développeur.
 */
public class PluginImpl2 extends Plugin {
    @Override
    protected void partie1() {
        System.out.println("   PluginImpl2 -> partie1");
    }

    @Override
    protected void partie2() {
        System.out.println("   PluginImpl2 -> partie2");
    }
}