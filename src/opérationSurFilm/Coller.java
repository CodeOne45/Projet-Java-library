package op�rationSurFilm;

import film.Film;

/**
 * La classe Coller impl�mente l'interface Film. 
 * Cette classe colle deux films l'un suite � l'autre.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */
public class Coller implements Film {
	
	// Les deux films � coller.
	private Film f1,f2;
	private int cmptEqual;
	
	/**
	 * Constructeur de la class Coller.
	 * @param fInt1 : premi�re film.
	 * @param fInt2 : deuxi�me film � coller � la premi�re.
	 */
	public Coller(Film fInt1, Film fInt2) {
		this.f1 = fInt1;
		this.f2 = fInt2;
		cmptEqual = 2;
	}

	@Override
	public int hauteur() {
		if((f1.hauteur() - f2.hauteur()) < 0 )
			return f2.hauteur();
		return f1.hauteur();
	}

	@Override
	public int largeur() {
		if((f1.largeur() - f2.largeur()) < 0 )
			return f2.largeur();
		return f1.largeur();
	}

	@Override
	public boolean suivante(char[][] �cranFilm) {
		if (f1.equals(f2)) {
			if( this.cmptEqual != 0) {
				if (!f1.suivante(�cranFilm)) {
					this.rembobiner();
					this.cmptEqual --;
					return f1.suivante(�cranFilm);
				}
				else {
					return true;
				}
			}
			else {
				return false;
			}
		}
		else {
			if(!f1.suivante(�cranFilm)) {
				//Si il n'y a plus d'image dans f1 on �crit sur l'�cran avec les images de f2
				if(!f2.suivante(�cranFilm)) {
					return false;
				}
			}
		}

		return true;
		
	}

	@Override
	public void rembobiner() {
		f1.rembobiner();
		f2.rembobiner();
	}

}
