package ma.enset.exercice1.observer;

public class MainObserver {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("Chaimaa");

        Couloir couloir = new Couloir();
        Camera camera = new Camera();
        Gardien gardien = new Gardien();

        joueur.subscribe(couloir);
        joueur.subscribe(camera);
        joueur.subscribe(gardien);

        System.out.println("=== Score -> 50");
        joueur.setScore(50);

        System.out.println("=== Score -> 120");
        joueur.setScore(120);

        System.out.println("=== La caméra se désabonne, score -> 200");
        joueur.unsubscribe(camera);
        joueur.setScore(200);
    }
}