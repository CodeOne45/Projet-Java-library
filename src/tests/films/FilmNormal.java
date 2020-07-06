package tests.films;

import film.Film;

public class FilmNormal implements Film {

	private int num = 0;
	private int numImage = 5;
	@Override
	public int hauteur() {
		return 3;
	}

	@Override
	public int largeur() {
		return 3;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(num == numImage)
			return false;
		
		for(int i = 0; i < this.hauteur();i++) {
			for(int j = 0; j < this.largeur(); j++) {
				écran[i][j] = 'x';
			}
		}
		
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

}
