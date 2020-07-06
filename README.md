# Projet-Java-The-Tiler-Team
Projet Java : The-Tiler-Team - BPO Semestre 2 Période D - Utilisation Interface/classes/héritage

Une société de production cinématographique souhaite révolutionner la diffusion
des films qu’elle produit. Pour se faire ils ont décidé de réduire de façon considérable le
volume de données nécessaire à la diffusion d’un film. 

La société a pris la décision de réaliser ses films avec un nouveau logiciel de montage de film utilisant le format .txt.
La société de production nous demande de pouvoir faire une multitude de modification a ses films. 

Ainsi, pour ce projet nous avons eu à coder certains éléments afin de développer une bibliothèque.
Une bibliothèque qui doit permettre de combiner des films existants et d’y faire des opérations tels que :

- Répéter un film, il s’agit de rejouer les images du film un nombre de fois donné.

- Obtenir un extrait d’un film. Cet extrait doit être désigné par le numéro de la première et
de la dernière image. La première image du film est désignée par le numéro 0.

- Encadrer un film. Le film à encadrer doit être entouré d’étoiles “*” positionnées au bord
de l’écran. - Coller deux films, un film est joué puis un autre directement à la fin de celui-ci.

- D’incruster un film dans un film. Ce film est incrusté grâce au numéro de ligne et de
colonne qui s’incrustera directement dans le coin en haut à gauche du film devant être
incrusté, dans les images du film où il est incrusté.

Toutes ces opérations ont été développés dans une classe OpérationSurFilm qui implémente Film

Utiliser la bibliothèque OpérationSurFilm :

L’utilisation des différentes opérations sur les films se fait à travers la classe Montage.java
qui contient des méthodes static permettant ainsi de proposer les diverses opérations.
