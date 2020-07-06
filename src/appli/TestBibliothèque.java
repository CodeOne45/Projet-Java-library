package appli;

import java.io.FileNotFoundException;


import film.Film;
import film.Films;
import op�rationSurFilm.Montage;



class Exemple implements Film{
	private int num = 0;
	private int numImage = 5;
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		if(num == numImage)
			return false;
		
		for(int i = 0; i < this.hauteur();i++) {
			for(int j = 0; j < this.largeur(); j++) {
				�cran[i][j] = 'x';
			}
		}
		
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		// TODO Auto-generated method stub
		num = 0;
	}
	
}


class Exemple2 implements Film{
	private int num = 0;
	private int numImage = 2;
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		if(num == numImage)
			return false;
		
		for(int i = 0; i < this.hauteur();i++) {
			for(int j = 0; j < this.largeur(); j++) {
				�cran[i][j] = 'a';
			}
		}
		
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		// TODO Auto-generated method stub
		num = 0;
	}
	
}

public class TestBiblioth�que {
	
	public static void main(String[] args) {
		
		Film filmTest = new Exemple();
		Film filmTest2 = new Exemple2();
		
		filmTest = Montage.r�p�ter(2, filmTest);
		
		filmTest2 = Montage.encadrerFilm(filmTest2);
		
		
		try {
			Films.sauvegarder(Montage.r�p�ter(0, filmTest2), "Test.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'Test.txt' n'a pas pu �tre cr�e");
		}
	}
	
	
	

}
