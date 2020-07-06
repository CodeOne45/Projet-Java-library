package opérationSurFilm;

import film.Film;
/**
 * La classe FilmVide implémente l'interface Film. 
 * Cette classe créer un film vide mais gardes l'hauteur et la largeur de film original.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */
public class FilmVide implements Film {
	private Film f;
	
	/**
	 * Construteur de class FilmVide
	 * @param fo : Film orignale 
	 */
	public FilmVide (Film fo) {
		this.f = fo;
	}

	public int hauteur() {
        
        return f.hauteur();
    }

    public int largeur() {
        
        return f.largeur();
    }

    
    public boolean suivante(char[][] écran) {
        return false;
    }

    public void rembobiner() {        
    }
}
