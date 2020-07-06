package op�rationSurFilm;

import film.Film;

/**
 * La classe Frame impl�mente l'interface Film. 
 * Cette classe encadre un film avec des "*" sur les 4 coins de l'�cran.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */

public class Frame implements Film{
	
	private Film f;
	private final int increaseScreen = 2;
	
	/**
	 * Constructeur de la class Frame
	 * @param fInt : Film � encadrer.
	 */
	public Frame(Film fInt) {
		this.f = fInt;
	}
	
	@Override
	public int hauteur() {
		return f.hauteur() + increaseScreen;
	}

	@Override
	public int largeur() {
		return f.largeur() + increaseScreen;
	}

	@Override
	public boolean suivante(char[][] ecranEncadr�) {
		char[][] �cran2 = new char[f.hauteur()][f.largeur()];
		if(this.f.suivante(�cran2)) {
			// Encadrer l'�cran
			for (int i = 0; i < hauteur(); i++) {
				ecranEncadr�[i][0] = '*';
				ecranEncadr�[i][(largeur()) - 1] = '*';  
			}
			for (int j = 0; j < largeur() ; j++) {
				ecranEncadr�[0][j] = '*';
				ecranEncadr�[(hauteur()) - 1][j]= '*';
			}
			
			// copier les images de film sur l'�cran 
			for (int i = 1; i <= f.hauteur(); i++) {
				for (int j = 1; j <= f.largeur() ; j++) {
					ecranEncadr�[i][j] = �cran2[i-1][j-1];
				} 
			}	
			
			return true;
		}
		return false;
	}
	
	@Override
	public void rembobiner() {
		f.rembobiner();
	}
}
