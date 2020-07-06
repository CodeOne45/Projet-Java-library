package tests.films;

import film.Film;

public class FilmNormal2 implements Film{

	private int num = 0;
	private int numImage = 5;
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(num == numImage)
			return false;
		
		for(int i = 0; i < this.hauteur();i++) {
			for(int j = 0; j < this.largeur(); j++) {
				écran[i][j] = 'a';
			}
		}
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		// TODO Auto-generated method stub
		num = 0;
	}

}
