package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import opérationSurFilm.FilmVide;
import opérationSurFilm.Montage;
import tests.films.ExtraitAttendu;
import tests.films.FilmNormal;

class TestExtrait {
	
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
	
	/*Test méthode film extrait.
	 *On compare les deux string: celle attendu et celle géérer par la bibliothèque montage 
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
	
	/*Test si le nouveau film est de même harteur et de largeur que le film attendu !
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
		
		//On projet le film pour aller jusqu'a la dernière image
		
		filmOriginal = Montage.extraitFilm(filmOriginal, 1, 1);
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'être rebobiner) et s2 : (Film Apré avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	/*Test film Vide.
	 *Film vide est retouner par la méthose ssi les parmétres sasie dans la méthode ne sont pas correcte
	 *Film vide possible ssi numéro de 1èr image a extraire est négative ou supérieure à dernière image a extraire. 
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
