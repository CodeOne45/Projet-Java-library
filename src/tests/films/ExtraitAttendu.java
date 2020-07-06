package tests.films;

import film.Film;
import film.Films;

public class ExtraitAttendu implements Film {

	private int num = 0;
	private int numImage = 4;
	
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(num == numImage)
			return false;
		if(num == 2) {
			for(int i = 0; i < this.hauteur();i++) {
				for(int j = 0; j < this.largeur(); j++) {
					écran[i][j] = 'x';
				}
			}
		}
		else {
			Films.effacer(écran);
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
