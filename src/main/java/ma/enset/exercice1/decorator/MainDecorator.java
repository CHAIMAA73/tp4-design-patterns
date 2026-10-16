package ma.enset.exercice1.decorator;

public class MainDecorator {
    public static void main(String[] args) {
        System.out.println("=== 1) Composant seul (sans décorateur)");
        Composant c1 = new ComposantImpl();
        c1.traitement();

        System.out.println();
        System.out.println("=== 2) Composant décoré par Log");
        Composant c2 = new DecorateurLog(new ComposantImpl());
        c2.traitement();

        System.out.println();
        System.out.println("=== 3) Composant décoré par Log puis par Chrono");
        Composant c3 = new DecorateurChrono(new DecorateurLog(new ComposantImpl()));
        c3.traitement();
    }
}