package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import op�rationSurFilm.Montage;
import tests.films.FilmNormal;
import tests.films.FilmNormal2;
import tests.films.IncrusterAttendu;

class TestIncruster {

	/*Avoir l'�cran de film sous forme d'un string
	 * @param f film pour le quell on veut les images
	 * @return sb string contnant les images/les �crans
	 * */
	private static String toString(Film f){
        String sb = "";
        f.rembobiner();
        char[][] �cran = new char[f.hauteur()][f.largeur()];
		while(f.suivante(�cran)){
           sb += Films.toString(�cran) + "\n";
        }
        return sb;
    }
	
	/*Test m�thode r�p�ter de la classe/Biblith�que Montage
	 *En comparant avec le film attendu. 
	 */
	@Test
	void testFilmInc() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		Film filmAttendu = new IncrusterAttendu(film1,film2,2,1);
		
		Film fInc = Montage.inscusterDeuxFilms(film1, film2, 2, 1);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(fInc);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de m�me harteur et de largeur que le film attendu !
	 * */
	@Test
	void testHauteurLargeur() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		Film filmAttendu = new IncrusterAttendu(film1,film2,2,2);
		film1.rembobiner();
		film2.rembobiner();
		Film fInc = Montage.inscusterDeuxFilms(film1, film2, 2, 2);
		
		assertEquals(filmAttendu.hauteur(),fInc.hauteur());
		assertEquals(filmAttendu.largeur(),fInc.largeur());
	}
	
	
}
