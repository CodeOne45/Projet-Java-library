package tests.films;

import film.Film;

public class FrameAttendu implements Film {

	private int num = 0;
	private int numImage = 5;

	@Override
	public int hauteur() {
		return 5;
	}

	@Override
	public int largeur() {
		return 5;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		if(num == numImage)
			return false;
		for (int i = 0; i < hauteur(); i++) {
			�cran[i][0] = '*';
			�cran[i][(largeur()) - 1] = '*';  
		}
		for (int j = 0; j < largeur() ; j++) {
			�cran[0][j] = '*';
			�cran[(hauteur()) - 1][j]= '*';
		}
		for(int i = 1; i < this.hauteur() - 1;i++) {
			for(int j = 1; j < this.largeur() - 1; j++) {
				�cran[i][j] = 'x';
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
