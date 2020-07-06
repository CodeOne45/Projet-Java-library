package opérationSurFilm;

import film.Film;
/**
 * La classe Répétition implémente l'interface Film. 
 * Cette classe modifie un film en le repetant autant de fois qu'on le souhaite.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */
public class Répétition implements Film  {
	
	/* nbRep : Le nombre de répétition du film */
	private int nbRep;
	
	/* cptRep : Compte le nombre de répétition effectué */
	private int cmptRép;
	
	/* Film "originl" à repeter */
	private Film f;
	
	/**
	 * Constructeur
	 * @param fInt : le film à repeter
	 * @param nbfois : le nombre de repetition à faire
	 */	
	public Répétition(Film fInt,int nbfois) {
		this.nbRep = nbfois;
		this.f = fInt;
		this.cmptRép = 0;
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
	public boolean suivante(char[][] écran) {
		
		if(!f.suivante(écran)) {
			++this.cmptRép;
			// Si le nb de répétition est atteint --> return false. 
			if(this.cmptRép == this.nbRep)
				return false;
			// Sinon on rebobine le film.
			f.rembobiner();
			return f.suivante(écran);
		}
		return true;
	}
	
	@Override
	public void rembobiner() {
		f.rembobiner();
		this.cmptRép = 0;
	}
	
}
