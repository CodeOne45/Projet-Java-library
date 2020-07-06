package opérationSurFilm;

import film.Film;

/**
 * La classe Frame implémente l'interface Film. 
 * Cette classe encadre un film avec des "*" sur les 4 coins de l'écran.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */

public class Frame implements Film{
	
	private Film f;
	private final int increaseScreen = 2;
	
	/**
	 * Constructeur de la class Frame
	 * @param fInt : Film à encadrer.
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
	public boolean suivante(char[][] ecranEncadré) {
		char[][] écran2 = new char[f.hauteur()][f.largeur()];
		if(this.f.suivante(écran2)) {
			// Encadrer l'écran
			for (int i = 0; i < hauteur(); i++) {
				ecranEncadré[i][0] = '*';
				ecranEncadré[i][(largeur()) - 1] = '*';  
			}
			for (int j = 0; j < largeur() ; j++) {
				ecranEncadré[0][j] = '*';
				ecranEncadré[(hauteur()) - 1][j]= '*';
			}
			
			// copier les images de film sur l'écran 
			for (int i = 1; i <= f.hauteur(); i++) {
				for (int j = 1; j <= f.largeur() ; j++) {
					ecranEncadré[i][j] = écran2[i-1][j-1];
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
