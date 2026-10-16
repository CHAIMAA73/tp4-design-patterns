package ma.enset.exercice1.plugin;

public class MainPlugin {
    public static void main(String[] args) {
        // Le client ne fait jamais "new PluginImpl1()" :
        // il ne connaît que la classe abstraite Plugin et la Factory.
        String[] classes = {
                "ma.enset.exercice1.plugin.PluginImpl1",
                "ma.enset.exercice1.plugin.PluginImpl2"
        };

        for (String className : classes) {
            System.out.println("=== Plugin chargé : " + className);
            Plugin plugin = PluginFactory.createPlugin(className);
            plugin.operation();
            System.out.println();
        }
    }
}