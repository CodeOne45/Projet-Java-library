package opérationSurFilm;

import film.Film;
import film.Films;

public class Montage {
		
	/**
	 * Méthode permettant de modifier un film en le repetant autant de fois qu'on le souhaite. 
	 * @param nbFois : le nombre de repetition à faire
	 * @param f : le film original à repeter
	 * @return : Return soit un film vide si nbFois < 0 soit le film répété 
	 */
	public static Film répéter(int nbFois,Film f)  {
		assert(f != null ) : "Le film entré est de réfèrences null";
		f.rembobiner();
		if(nbFois > 0) {
			Répétition filmRép = new Répétition(f,nbFois);
			return filmRép;
		}
		return (Film) new FilmVide(f);
	}
	
	
	/**
	 * Méthode permettant d'optenir un extrait des images d'un film à partir de deux positions.
	 * @param f : le film à extraire
	 * @param numPImage : numero de la 1ere image à inclure
	 * @param numDImaga : numero de la derniere image à inclure
	 * @return : return soit film vide si  condition non vérifié ou l'extrait de film
	 */
	public static Film extraitFilm(Film f,int numPImage, int numDImaga) {
		assert(f != null ) : "Le film entré est de réfèrences null";
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
	 * Méthode permettant de avoir un frame/cadre sur le simages de film 
	 * @param f : le film à encardrer
	 * @return : Le nouveau film avec des images encadré
	 */
	public static Film encadrerFilm(Film f) {
		assert(f != null ) : "Le film entré est de réfèrences null";
		f.rembobiner();
        Frame fE = new  Frame(f);
        return fE;
    }
	
	
	/**
	 * Méthode permettant de coller les deux films l'un aprés l'autre
	 * @param f1 : première film 
	 * @param f2 : deuxième film à coller à la première
	 * @return : Returne un nouveau film qui contient f1 et f2
	 */
	public static Film collerDeuxFilms(Film f1,Film f2) {
		assert(f1 != null && f2 != null) : "Les films entrées ont des réfèrences null";
		f1.rembobiner();
		f2.rembobiner();
		Coller fC = new  Coller(f1,f2);
        return fC;
    }
	
	
	/**
	 * Méthode permettant de modifier un film en incrustant un autre film dans un autre film à une position donné. 
	 * @param f1 : le film recevrant l'incrustation
	 * @param f2 : le film devant être inscruter
	 * @param ligne : le numéro de la ligne où le film doit être incrusté
	 * @param collone : le numéro de la colonne où le film doit être incrusté
	 * @return : Returne soit film vide si les canditions ne sont pas valide soit le film incrusté.
	 */
	public static Film inscusterDeuxFilms(Film f1,Film f2,int ligne,int collone) {
		assert(f1 != null && f2 != null) : "Les films entrées ont des réfèrences null";
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
	 * Déterminer le nombre d'image d'un film (Visibilté que dan sle package)
	 * @param f: film
	 * @return i: nb images
	 * */
	static int nbImages(Film f) {
		int i = 0;
		f.rembobiner();
		char[][] écran = Films.getEcran(f);
		while(f.suivante(écran)) {
			i++;
		}
		f.rembobiner();
		return i;
	}
	
	// Cette classe n'a pas vocation à être instanciée car elle ne contient que
	// des méthodes de classe (i.e. statiques).
	private Montage() {
	}
	
}
