package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import film.Film;
import film.Films;
import op�rationSurFilm.Montage;
import tests.films.FilmNormal;
import tests.films.FrameAttendu;

class TestFrame {

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
	void testFilmEncadrer() {
		Film filmOriginal = new FilmNormal();
		Film filmAttendu = new FrameAttendu();
		filmOriginal = Montage.encadrerFilm(filmOriginal);
		
		String s1 = toString(filmAttendu);
		
		String s2 = toString(filmOriginal);
		
		assertEquals(s1,s2);
	}
	
	/*Test si le nouveau film est de m�me harteur et de largeur que le film attendu !
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
		
		//On projet le film pour aller jusqu'a la derni�re image
		
		filmOriginal = Montage.encadrerFilm(filmOriginal);
		String s1 = toString(filmOriginal);
		
		//On rebobine pour voir si on peut recomencer le film depuis le depuis
		
		filmOriginal.rembobiner();
		String s2 = toString(filmOriginal);
		
		//On compare s1 : (Film avant d'�tre rebobiner) et s2 : (Film Apr� avoir rebobiner).
		assertEquals(s1,s2);
	}
	
	

}
