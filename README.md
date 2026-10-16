# TP Design Patterns

**Réalisé par :** Chaimaa Zandar — Cycle ingénieur GLSID, ENSET Mohammedia
**Encadrant :** Pr. Mohamed Youssfi
**Langage :** Java (projet Maven)

## Objectif

Identifier, pour chaque situation, le design pattern adapté, établir son diagramme
de classes puis l'implémenter en Java.

## Exercice 1

### 1.1 Figures — pattern Composite

**Situation :** une figure peut être un cercle, un rectangle ou un groupe de figures.

**Justification :** un groupe est lui-même une figure qui contient d'autres figures
(structure arborescente). Le pattern Composite permet de traiter de la même façon un
objet simple (feuille) et un ensemble d'objets (composite) : `dessiner()` ou `surface()`
s'appellent sur un groupe exactement comme sur un cercle.

| Rôle | Classe |
|---|---|
| Component | `Figure` |
| Leaf | `Cercle`, `Rectangle` |
| Composite | `Groupe` |

```mermaid
classDiagram
    class Figure {
        <<abstract>>
        #nom : String
        +dessiner(indentation : String)*
        +surface() double*
    }
    class Cercle {
        -rayon : double
        +dessiner(indentation : String)
        +surface() double
    }
    class Rectangle {
        -largeur : double
        -hauteur : double
        +dessiner(indentation : String)
        +surface() double
    }
    class Groupe {
        -figures : List~Figure~
        +ajouter(f : Figure)
        +supprimer(f : Figure)
        +dessiner(indentation : String)
        +surface() double
    }
    Figure <|-- Cercle
    Figure <|-- Rectangle
    Figure <|-- Groupe
    Groupe o--> "*" Figure : contient
```

**Résultat de l'exécution :**

![Composite](captures/composite.png)

### 1.2 Plugin — Template Method + Factory

**Situation :** une opération implémente le squelette d'un algorithme dont deux parties
sont variables ; le développeur implémente ces parties, et l'application cliente doit
instancier un plugin sans connaître sa classe concrète.

**Justification :**
- **Template Method** : `operation()` (déclarée `final`) fixe l'ordre des étapes et appelle
  les méthodes abstraites `partie1()` et `partie2()` que les sous-classes redéfinissent.
- **Factory** : `PluginFactory` crée l'instance à partir du *nom* de la classe (réflexion
  avec `Class.forName`). Le client ne manipule que le type abstrait `Plugin`.

| Rôle | Classe |
|---|---|
| AbstractClass | `Plugin` |
| ConcreteClass | `PluginImpl1`, `PluginImpl2` |
| Factory | `PluginFactory` |
| Client | `MainPlugin` |

```mermaid
classDiagram
    class Plugin {
        <<abstract>>
        +operation() final
        #partie1()*
        #partie2()*
    }
    class PluginImpl1 {
        #partie1()
        #partie2()
    }
    class PluginImpl2 {
        #partie1()
        #partie2()
    }
    class PluginFactory {
        +createPlugin(className : String)$ Plugin
    }
    class MainPlugin {
        +main(args)$
    }
    Plugin <|-- PluginImpl1
    Plugin <|-- PluginImpl2
    PluginFactory ..> Plugin : crée
    MainPlugin ..> PluginFactory : utilise
    MainPlugin ..> Plugin : utilise
```

**Résultat de l'exécution :**

![Plugin](captures/plugin.png)