package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import opérationSurFilm.Montage;
import tests.films.FilmNormal;
import tests.films.FilmNormal2;
import tests.films.IncrusterAttendu;

class TestIncruster {

	/*Avoir l'écran de film sous forme d'un string
	 * @param f film pour le quell on veut les images
	 * @return sb string contnant les images/les écrans
	 * */
	private static String toString(Film f){
        String sb = "";
        f.rembobiner();
        char[][] écran = new char[f.hauteur()][f.largeur()];
		while(f.suivante(écran)){
           sb += Films.toString(écran) + "\n";
        }
        return sb;
    }
	
	/*Test méthode répéter de la classe/Biblithéque Montage
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
	
	/*Test si le nouveau film est de même harteur et de largeur que le film attendu !
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
