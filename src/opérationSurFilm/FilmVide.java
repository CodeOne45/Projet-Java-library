package op�rationSurFilm;

import film.Film;
/**
 * La classe FilmVide impl�mente l'interface Film. 
 * Cette classe cr�er un film vide mais gardes l'hauteur et la largeur de film original.
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

    
    public boolean suivante(char[][] �cran) {
        return false;
    }

    public void rembobiner() {        
    }
}
