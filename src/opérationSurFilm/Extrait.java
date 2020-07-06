package opérationSurFilm;

import film.Film;
/**
 * La classe Extrait implémente l'interface Film. <br>
 * Cette classe permet d'extraire une partie d'un film désigné par les numéros de la
 * premieres et dernieres images à inclure du film. <br>
 * La 1ere image d'un film porte le numéro 0. <br>
 * 	_ Si le num de la 1ere images à extraire est negatif, l'extrait démarre 
 * 		alors au début du film original soit à la position 0.
 * 	_ Si le num de la derniere images à extraire est superireur au nombre d'image 
 * 		total du film, l'extrait va alors s'arreter à la fin du film original.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */

public class Extrait implements Film {
	
	// -1 car la position peut commencer par 0
	private int numFrame = -1;
	/**
	 * Numero du 1er image à inclure
	 */
	private int numDebut;
	/**
	 * Numero du dernier image à inclure
	 */
	private int numFin;
	
	// Films à extraire
	private Film filmOriginal;
	
	/**
	 * Constructeur de la class ModifExtraire
	 * @param film : le film à extraire
	 * @param numD : numero de la 1ere image à inclure
	 * @param numF : numero de la derniere image à inclure
	 */
	public Extrait(Film film, int numD, int numF) {
		filmOriginal = film;
		this.numDebut = numD;
		this.numFin = numF;
	}

	@Override
	public boolean suivante(char[][] écran) {
		do {
			++numFrame;
			if(!filmOriginal.suivante(écran))
				return false;
		} while(numFrame < numDebut);
		return (numFrame > numFin)? false : true;
	}

	@Override
	public void rembobiner() {
		filmOriginal.rembobiner();
		this.numFrame = -1;
	}

	@Override
	public int hauteur() {
		return this.filmOriginal.hauteur();
	}

	@Override
	public int largeur() {
		return this.filmOriginal.largeur();
	}

}
