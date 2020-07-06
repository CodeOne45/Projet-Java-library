package op�rationSurFilm;

import film.Film;
import film.Films;

public class Montage {
		
	/**
	 * M�thode permettant de modifier un film en le repetant autant de fois qu'on le souhaite. 
	 * @param nbFois : le nombre de repetition � faire
	 * @param f : le film original � repeter
	 * @return : Return soit un film vide si nbFois < 0 soit le film r�p�t� 
	 */
	public static Film r�p�ter(int nbFois,Film f)  {
		assert(f != null ) : "Le film entr� est de r�f�rences null";
		f.rembobiner();
		if(nbFois > 0) {
			R�p�tition filmR�p = new R�p�tition(f,nbFois);
			return filmR�p;
		}
		return (Film) new FilmVide(f);
	}
	
	
	/**
	 * M�thode permettant d'optenir un extrait des images d'un film � partir de deux positions.
	 * @param f : le film � extraire
	 * @param numPImage : numero de la 1ere image � inclure
	 * @param numDImaga : numero de la derniere image � inclure
	 * @return : return soit film vide si  condition non v�rifi� ou l'extrait de film
	 */
	public static Film extraitFilm(Film f,int numPImage, int numDImaga) {
		assert(f != null ) : "Le film entr� est de r�f�rences null";
		f.rembobiner();
		int numPImg = (numPImage <= 0)? 0 : numPImage ;
		int numDImg = numDImaga;
		if((numPImg <= numDImg) && numDImg >= 0) {
			Extrait ef = new Extrait(f, numPImg , numDImg );
	        return ef;
		}
		return (Film) new FilmVide(f);
    }
	
	
	/**
	 * M�thode permettant de avoir un frame/cadre sur le simages de film 
	 * @param f : le film � encardrer
	 * @return : Le nouveau film avec des images encadr�
	 */
	public static Film encadrerFilm(Film f) {
		assert(f != null ) : "Le film entr� est de r�f�rences null";
		f.rembobiner();
        Frame fE = new  Frame(f);
        return fE;
    }
	
	
	/**
	 * M�thode permettant de coller les deux films l'un apr�s l'autre
	 * @param f1 : premi�re film 
	 * @param f2 : deuxi�me film � coller � la premi�re
	 * @return : Returne un nouveau film qui contient f1 et f2
	 */
	public static Film collerDeuxFilms(Film f1,Film f2) {
		assert(f1 != null && f2 != null) : "Les films entr�es ont des r�f�rences null";
		f1.rembobiner();
		f2.rembobiner();
		Coller fC = new  Coller(f1,f2);
        return fC;
    }
	
	
	/**
	 * M�thode permettant de modifier un film en incrustant un autre film dans un autre film � une position donn�. 
	 * @param f1 : le film recevrant l'incrustation
	 * @param f2 : le film devant �tre inscruter
	 * @param ligne : le num�ro de la ligne o� le film doit �tre incrust�
	 * @param collone : le num�ro de la colonne o� le film doit �tre incrust�
	 * @return : Returne soit film vide si les canditions ne sont pas valide soit le film incrust�.
	 */
	public static Film inscusterDeuxFilms(Film f1,Film f2,int ligne,int collone) {
		assert(f1 != null && f2 != null) : "Les films entr�es ont des r�f�rences null";
		f1.rembobiner();
		f2.rembobiner();
		int numPImage = (ligne < 0)? 0 : ligne;
		int numDImage = (collone < 0)? 0 : collone;
		if(numPImage <= f2.hauteur() && numDImage <= f2.largeur() ) {
			Incruster fI = new  Incruster(f1,f2,numPImage ,numDImage );
	        return fI;
		}
		return (Film) new FilmVide(f1);
    }
	
	/**
	 * D�terminer le nombre d'image d'un film (Visibilt� que dan sle package)
	 * @param f: film
	 * @return i: nb images
	 * */
	static int nbImages(Film f) {
		int i = 0;
		f.rembobiner();
		char[][] �cran = Films.getEcran(f);
		while(f.suivante(�cran)) {
			i++;
		}
		f.rembobiner();
		return i;
	}
	
	// Cette classe n'a pas vocation � �tre instanci�e car elle ne contient que
	// des m�thodes de classe (i.e. statiques).
	private Montage() {
	}
	
}
