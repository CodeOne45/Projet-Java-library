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
	public boolean suivante(char[][] écran) {
		if(num == numImage)
			return false;
		for (int i = 0; i < hauteur(); i++) {
			écran[i][0] = '*';
			écran[i][(largeur()) - 1] = '*';  
		}
		for (int j = 0; j < largeur() ; j++) {
			écran[0][j] = '*';
			écran[(hauteur()) - 1][j]= '*';
		}
		for(int i = 1; i < this.hauteur() - 1;i++) {
			for(int j = 1; j < this.largeur() - 1; j++) {
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
