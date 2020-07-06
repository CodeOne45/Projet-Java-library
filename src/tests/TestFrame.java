package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import opérationSurFilm.Montage;
import tests.films.FilmNormal;
import tests.films.FrameAttendu;

class TestFrame {

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
	void testFilmEncadrer() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new FrameAttendu();
		filmOriginal = Montage.encadrerFilm(filmOriginal);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de même harteur et de largeur que le film attendu !
	 */
	@Test
	void testHauteurLargeur() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new FrameAttendu();
		filmOriginal = Montage.encadrerFilm(filmOriginal);
		
		assertEquals(filmAttendu.hauteur(),filmOriginal.hauteur());
		assertEquals(filmAttendu.largeur(),filmOriginal.largeur());
	}
	
	/*Test rebobiner
	 * */
	@Test
	void testRebobiner() {
		Film filmOriginal = new FilmNormal();
		
		//On projet le film pour aller jusqu'a la dernière image
		
		filmOriginal = Montage.encadrerFilm(filmOriginal);
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'être rebobiner) et s2 : (Film Apré avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	

}
