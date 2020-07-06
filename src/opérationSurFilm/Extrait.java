package op�rationSurFilm;

import film.Film;
/**
 * La classe Extrait impl�mente l'interface Film. <br>
 * Cette classe permet d'extraire une partie d'un film d�sign� par les num�ros de la
 * premieres et dernieres images � inclure du film. <br>
 * La 1ere image d'un film porte le num�ro 0. <br>
 * 	_ Si le num de la 1ere images � extraire est negatif, l'extrait d�marre 
 * 		alors au d�but du film original soit � la position 0.
 * 	_ Si le num de la derniere images � extraire est superireur au nombre d'image 
 * 		total du film, l'extrait va alors s'arreter � la fin du film original.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */

public class Extrait implements Film {
	
	// -1 car la position peut commencer par 0
	private int numFrame = -1;
	/**
	 * Numero du 1er image � inclure
	 */
	private int numDebut;
	/**
	 * Numero du dernier image � inclure
	 */
	private int numFin;
	
	// Films � extraire
	private Film filmOriginal;
	
	/**
	 * Constructeur de la class ModifExtraire
	 * @param film : le film � extraire
	 * @param numD : numero de la 1ere image � inclure
	 * @param numF : numero de la derniere image � inclure
	 */
	public Extrait(Film film, int numD, int numF) {
		filmOriginal = film;
		this.numDebut = numD;
		this.numFin = numF;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		do {
			++numFrame;
			if(!filmOriginal.suivante(�cran))
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
