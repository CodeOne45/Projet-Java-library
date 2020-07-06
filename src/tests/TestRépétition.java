package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import op�rationSurFilm.FilmVide;
import op�rationSurFilm.Montage;
import tests.films.ExtraitAttendu;
import tests.films.FilmNormal;
import tests.films.R�p�titionAttendu;

public class TestR�p�tition {
		
	/*Avoir l'�cran de film sous forme d'un string
	 * @param f film pour le quell on veut les images
	 * @return sb string contnant les images/les �crans
	 * */
	private static String toString(Film f){
        String sb = "";
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
	void testFilmR�p() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new R�p�titionAttendu();
		filmOriginal = Montage.r�p�ter(2, filmOriginal);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de m�me harteur et de largeur que le film attendu !
	 * */
	@Test
	void testHauteurLargeur() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new ExtraitAttendu();
		filmOriginal = Montage.r�p�ter(2, filmOriginal);;
		
		assertEquals(filmAttendu.hauteur(),filmOriginal.hauteur());
		assertEquals(filmAttendu.largeur(),filmOriginal.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film filmOriginal = new FilmNormal();
		
		//On projet le film pour aller jusqu'a la derni�re image
		
		filmOriginal = Montage.r�p�ter(2, filmOriginal);;
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'�tre rebobiner) et s2 : (Film Apr� avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	/*Test en cas de r�p�tition n�gative ou sup � nombre d'image de film
	 *On returne donc une film vide!
	 */
	@Test
	void testFilmR�pVide() {
		Film filmOriginal = new FilmNormal();
		Film filmV = new FilmVide(filmOriginal);
		filmOriginal = Montage.r�p�ter(-1, filmOriginal);
		
		String s1 = toString(filmV);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}

}

