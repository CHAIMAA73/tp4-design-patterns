package ma.enset.exercice1.plugin;

/**
 * Factory : le client demande un Plugin sans connaître sa classe d'implémentation.
 * Le nom de la classe vient de l'extérieur (fichier de config, saisie, ...) et
 * l'objet est créé par réflexion (instanciation dynamique).
 */
public class PluginFactory {

    public static Plugin createPlugin(String className) {
        try {
            Class<?> c = Class.forName(className);
            return (Plugin) c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Impossible de créer le plugin : " + className, e);
        }
    }
}