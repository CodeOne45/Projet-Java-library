package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import opérationSurFilm.Montage;
import tests.films.CollerAttendu;
import tests.films.FilmNormal;
import tests.films.FilmNormal2;

class TestColler {

	/*Avoir l'écran de film sous forme d'un string
	 * @param f film pour le quell on veut les images
	 * @return sb string contnant les images/les écrans
	 * */
	private static String toString(Film f){
        String sb = "";
        char[][] écran = new char[f.hauteur()][f.largeur()];
		while(f.suivante(écran)){
           sb += Films.toString(écran) + "\n";
        }
        return sb;
    }
	
	/*Test méthode encadrer film.
	 *On compare les deux string: celle attendu et celle géérer par la bibliothèque montage 
	 * */
	@Test
	void testFilmColler() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		Film filmAttendu = new CollerAttendu(film1,film2);
		
		String s1 = toString(filmAttendu);
		
		film1.rembobiner();
		film2.rembobiner();
		
		Film FilmOpération = Montage.collerDeuxFilms(film1, film2);
		
		String s2 = toString(FilmOpération);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de même harteur et de largeur que le film attendu !*/ 
	@Test
	void testHauteurLargeur() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		Film filmAttendu = new CollerAttendu(film1,film2);
		Film FilmOpération = Montage.collerDeuxFilms(film1, film2);
		
		assertEquals(filmAttendu.hauteur(),FilmOpération.hauteur());
		assertEquals(filmAttendu.largeur(),FilmOpération.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		//On projet le film pour aller jusqu'a la dernière image
		

		Film FilmOpération = Montage.collerDeuxFilms(film1, film2);
		
		String s1 = toString(FilmOpération);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		FilmOpération.rembobiner();
		String s2 = toString(FilmOpération);
		
		//On compare s1 : (Film avant d'être rebobiner) et s2 : (Film Apré avoir rebobiner).
		assertEquals(s1,s2);
	}
}
