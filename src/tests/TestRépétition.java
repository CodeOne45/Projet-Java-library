package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import opérationSurFilm.FilmVide;
import opérationSurFilm.Montage;
import tests.films.ExtraitAttendu;
import tests.films.FilmNormal;
import tests.films.RépétitionAttendu;

public class TestRépétition {
		
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
	
	/*Test méthode répéter de la classe/Biblithéque Montage
	 *En comparant avec le film attendu. 
	 */
	@Test
	void testFilmRép() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new RépétitionAttendu();
		filmOriginal = Montage.répéter(2, filmOriginal);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de même harteur et de largeur que le film attendu !
	 * */
	@Test
	void testHauteurLargeur() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new ExtraitAttendu();
		filmOriginal = Montage.répéter(2, filmOriginal);;
		
		assertEquals(filmAttendu.hauteur(),filmOriginal.hauteur());
		assertEquals(filmAttendu.largeur(),filmOriginal.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film filmOriginal = new FilmNormal();
		
		//On projet le film pour aller jusqu'a la dernière image
		
		filmOriginal = Montage.répéter(2, filmOriginal);;
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'être rebobiner) et s2 : (Film Apré avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	/*Test en cas de répétition négative ou sup à nombre d'image de film
	 *On returne donc une film vide!
	 */
	@Test
	void testFilmRépVide() {
		Film filmOriginal = new FilmNormal();
		Film filmV = new FilmVide(filmOriginal);
		filmOriginal = Montage.répéter(-1, filmOriginal);
		
		String s1 = toString(filmV);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}

}

