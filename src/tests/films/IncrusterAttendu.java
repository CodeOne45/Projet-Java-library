package tests.films;

import film.Film;

public class IncrusterAttendu implements Film {

	private Film f1;
	private Film f2;
	private int ligne;
	private int collone;
	private int num;
	
	
	public IncrusterAttendu(Film f1, Film f2, int l, int c) {
		this.f1 = f1;
		this.f2 = f2;
		this.ligne = l ;
		this.collone = c;
		this.num  = 0;
	}

	@Override
	public int hauteur() {
		return f2.hauteur();
	}

	@Override
	public int largeur() {
		return f2.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(f2.suivante(écran)) {
			char[][] écran2 = new char[f1.hauteur()][f1.largeur()];
			int i = ligne;
			int j = collone;
			f1.suivante(écran2);
			for(int k = 0; k < f1.hauteur();k++) {
				for(int l = 0; l < f1.largeur();l++) {
					écran[i][j++] = écran2[k][l];
				}
				i++;
				j = collone;
			}
			num++;
			return true;
		}
		return false;
	}

	@Override
	public void rembobiner() {
		this.num  = 0;
		f2.rembobiner();
		f1.rembobiner();
	}

}
