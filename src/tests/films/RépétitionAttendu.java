package tests.films;

import film.Film;

public class RépétitionAttendu implements Film {

	private int num = 0;
	private int numImage = 5;
	private int nbFois = 2;
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
				
		if (nbFois  == 0) {
			nbFois = 2;
			return false;
		}
			
		for(int i = 0; i < this.hauteur();i++) {
			for(int j = 0; j < this.largeur(); j++) {
				écran[i][j] = 'x';
			}
		}
		num++;
		if(num == numImage) {
			nbFois--;
			this.rembobiner(); //num = 0 et nbFois = 2//num = 0 et nbFois = 1//num = 0 et nbFois = 0
		}
		return true;
	}

	@Override
	public void rembobiner() {
		// TODO Auto-generated method stub
		num = 0;
	}

}
