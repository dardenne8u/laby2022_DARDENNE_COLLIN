# Projet Labyrinthe Ricochet
### S2 Qualité de développement - BUT INFO 1A - IUT Nancy-Charlemagne
### Hugo COLLIN, Gregory DARDENNE, S2B
###
### Description
Il s'agissait de réaliser un jeu dans lequel le 
joueur contrôle un personnage devant atteindre la 
sortie d'un labyrinthe.
Lorsqu'il se déplace, le personnage ne s'arrête que
lorsqu'il rencontre un obstacle (un mur).
###
### Difficultés rencontrées
####Les problèmes suivants ont été résolus :
* Dans la classe `MainLaby`, la boucle while ne s'arrêtait 
pas lorsque le joueur avait atteint la sortie.

* Dans la classe `Labyrinthe`, lancement de FichierIncorrectException 
alors que les nombres de lignes et colonnes étaient 
correctes (ligne 214).

###
### Choix de programmation
Nous avons d'abord programmé la classe `Position`,
puis les classes `Personnage` et `Sorties` permettant 
respectivement de créer des objets de type Personnage
et Sortie, et qui héritent de Position.

Puis nous avons codé la classe `Labyrinthe`, qui crée 
des objets de type Labyrinthe et qui possède
des attributs de type Personnage et Sortie ; ainsi que 
`ActionInconnueException` et `FichierIncorrectException`
qui sont des exceptions utilisées dans Labyrinthe et 
MainLaby.

Nous avons ensuite réalisé `MainLaby`, qui permet 
d'exécuter le jeu dans le terminal.

Enfin, nous avons programmé `LabyrintheTest` qui permet 
de vérifier que notre classe Labyrinthe fonctionne 
correctement.
###
### Lancement de l'application
1. Compiler les fichiers du répertoire src.
2. Lancer le fichier binaire de MainLaby avec la commande
`java MainLaby fichierLabyrinthe`, fichierLabyrinthe 
étant le chemin d'accès vers un fichier contenant un labyrinthe.

###
### Résumé des tests
#### Réussis :
* `test_charger_PasDeProbleme()` : 

####Echoués :
* 

###
### Couverture des tests et explications
Nous avons essayé de couvrir un maximum de cas dans nos tests.