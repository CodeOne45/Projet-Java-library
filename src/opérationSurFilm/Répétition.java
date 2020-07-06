package op�rationSurFilm;

import film.Film;
/**
 * La classe R�p�tition impl�mente l'interface Film. 
 * Cette classe modifie un film en le repetant autant de fois qu'on le souhaite.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */
public class R�p�tition implements Film  {
	
	/* nbRep : Le nombre de r�p�tition du film */
	private int nbRep;
	
	/* cptRep : Compte le nombre de r�p�tition effectu� */
	private int cmptR�p;
	
	/* Film "originl" � repeter */
	private Film f;
	
	/**
	 * Constructeur
	 * @param fInt : le film � repeter
	 * @param nbfois : le nombre de repetition � faire
	 */	
	public R�p�tition(Film fInt,int nbfois) {
		this.nbRep = nbfois;
		this.f = fInt;
		this.cmptR�p = 0;
	}
	
	@Override
	public int hauteur() {
		return f.hauteur();
	}

	@Override
	public int largeur() {
		return f.largeur();
	}

	@Override
	public boolean suivante(char[][] �cran) {
		
		if(!f.suivante(�cran)) {
			++this.cmptR�p;
			// Si le nb de r�p�tition est atteint --> return false. 
			if(this.cmptR�p == this.nbRep)
				return false;
			// Sinon on rebobine le film.
			f.rembobiner();
			return f.suivante(�cran);
		}
		return true;
	}
	
	@Override
	public void rembobiner() {
		f.rembobiner();
		this.cmptR�p = 0;
	}
	
}
