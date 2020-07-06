package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import op�rationSurFilm.Montage;
import tests.films.CollerAttendu;
import tests.films.FilmNormal;
import tests.films.FilmNormal2;

class TestColler {

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
	
	/*Test m�thode encadrer film.
	 *On compare les deux string: celle attendu et celle g��rer par la biblioth�que montage 
	 * */
	@Test
	void testFilmColler() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		Film filmAttendu = new CollerAttendu(film1,film2);
		
		String s1 = toString(filmAttendu);
		
		film1.rembobiner();
		film2.rembobiner();
		
		Film FilmOp�ration = Montage.collerDeuxFilms(film1, film2);
		
		String s2 = toString(FilmOp�ration);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de m�me harteur et de largeur que le film attendu !*/ 
	@Test
	void testHauteurLargeur() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		Film filmAttendu = new CollerAttendu(film1,film2);
		Film FilmOp�ration = Montage.collerDeuxFilms(film1, film2);
		
		assertEquals(filmAttendu.hauteur(),FilmOp�ration.hauteur());
		assertEquals(filmAttendu.largeur(),FilmOp�ration.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film film1 = new FilmNormal();
		Film film2 = new FilmNormal2();
		
		//On projet le film pour aller jusqu'a la derni�re image
		

		Film FilmOp�ration = Montage.collerDeuxFilms(film1, film2);
		
		String s1 = toString(FilmOp�ration);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		FilmOp�ration.rembobiner();
		String s2 = toString(FilmOp�ration);
		
		//On compare s1 : (Film avant d'�tre rebobiner) et s2 : (Film Apr� avoir rebobiner).
		assertEquals(s1,s2);
	}
}
