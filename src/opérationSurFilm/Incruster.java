package op�rationSurFilm;

import film.Film;

/**
 * La classe Incruster impl�mente l'interface Film. 
 * Cette classe modifie un film en incrustant un autre film dans ce film � une position donn�e.
 * @author KUMAR Aman - ROBALO RODRIGUES Flavio
 */

public class Incruster implements Film {

	private Film f1;
	private Film f2;
	private int ligne,col;
	
	int hauteurEcranIncrustrer ;
	int largeurEcranIncrustrer ;	
	
	/**
	 * Constructeur de la class Incruster.
	 * @param fInt1 : le film devant �tre inscruter
	 * @param fInt2 : le film recevrant l'incrustation
	 * @param ligne : le num�ro de la ligne o� le film doit �tre incrust�
	 * @param col   : le num�ro de la colonne o� le film doit �tre incrust�
	 */
	public Incruster(Film fInt1, Film fInt2, int ligne, int col) {
		this.f1 = fInt1;
		this.f2 = fInt2;
		this.ligne = ligne;
		this.col = col;
		
		// D�terminer les position en fonction d'hauteur et largeur des deux films.
		
		if(f1.hauteur() - (f2.hauteur() - ligne)  > 0) {
			hauteurEcranIncrustrer =  f1.hauteur() - (f1.hauteur() - (f2.hauteur() - ligne));   
		}
		else {
			hauteurEcranIncrustrer = f1.hauteur() ; 
		}

		if(f1.largeur() - (f2.largeur() - col) > 0) {
			largeurEcranIncrustrer =  f1.largeur() - (f1.largeur() - (f2.largeur() - col)) ; 
		}
		else {
			largeurEcranIncrustrer = f1.largeur() ;
		}
		
	}
	
	@Override
	public int hauteur() {
		return f2.hauteur();
	}

	@Override
	public int largeur() {
		return f2.largeur();
	}

	@Override
	public boolean suivante(char[][] �cranFinal) {
		
		char[][] �cran1 = new char[f1.hauteur()][f1.largeur()];
		
		if(f2.suivante(�cranFinal) ) {
			if(f1.suivante(�cran1)) {
				int i = this.ligne;
				int j = this.col;
				
				for(int k = 0; k < hauteurEcranIncrustrer; k++) { 
					
					for(int l = 0; l < largeurEcranIncrustrer ;l++) {
						�cranFinal[i][j++] = �cran1[k][l]; 
					}
					i++;
					j = this.col;
				}
			}
			return true;			
		}
		
		return false;
	}

	@Override
	public void rembobiner() {
		f2.rembobiner();
		f1.rembobiner();
	}

}
