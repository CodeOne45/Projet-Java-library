package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import op�rationSurFilm.FilmVide;
import op�rationSurFilm.Montage;
import tests.films.ExtraitAttendu;
import tests.films.FilmNormal;

class TestExtrait {
	
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
	
	/*Test m�thode film extrait.
	 *On compare les deux string: celle attendu et celle g��rer par la biblioth�que montage 
	 * */
	@Test
	void testFilmExtrait() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new ExtraitAttendu();
		Film filmEx = Montage.extraitFilm(filmOriginal, 2, 4);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(filmEx);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de m�me harteur et de largeur que le film attendu !
	 * */
	@Test
	void testHauteurLargeur() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new ExtraitAttendu();
		filmOriginal = Montage.extraitFilm(filmOriginal, 2, 4);
		
		assertEquals(filmAttendu.hauteur(),filmOriginal.hauteur());
		assertEquals(filmAttendu.largeur(),filmOriginal.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film filmOriginal = new FilmNormal();
		
		//On projet le film pour aller jusqu'a la derni�re image
		
		filmOriginal = Montage.extraitFilm(filmOriginal, 1, 1);
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'�tre rebobiner) et s2 : (Film Apr� avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	/*Test film Vide.
	 *Film vide est retouner par la m�those ssi les parm�tres sasie dans la m�thode ne sont pas correcte
	 *Film vide possible ssi num�ro de 1�r image a extraire est n�gative ou sup�rieure � derni�re image a extraire. 
	 * */
	@Test
	void testFilmExtraitVide() {
		Film filmOriginal = new FilmNormal();
		Film filmV = new FilmVide(filmOriginal);
		filmOriginal = Montage.extraitFilm(filmOriginal, -2, 6);
		
		String s1 = toString(filmV);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}

}
