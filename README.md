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
* Dans MainLaby.java, la boucle while ne s'arrêtait 
pas lorsque le joueur avait atteint la sortie.

* Dans Labyrinthe.java, lancement de FichierIncorrectException 
alors que les nombres de lignes et colonnes étaient 
correctes (ligne 214).

###
### Choix de programmation

###
### Lancement de l'application
1. Compiler les fichiers du répertoire src.
2. Lancer le fichier binaire de MainLaby avec la commande
`java MainLaby fichierLabyrinthe`, fichierLabyrinthe 
étant le chemin d'accès vers un fichier contenant un labyrinthe.

###
### Résumé des tests
#### Réussis :
*

####Echoués :
*

###
### Couverture des tests et explications