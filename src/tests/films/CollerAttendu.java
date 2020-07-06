package tests.films;

import film.Film;

public class CollerAttendu implements Film {

	private Film f;
    private Film f2;

    public CollerAttendu(Film f, Film f2){
        this.f = f;
        this.f2 = f2;
    }

    @Override
    public int hauteur() {
        return Math.max(f.hauteur(), f2.hauteur());
    }

    @Override
    public int largeur() {
        return Math.max(f.largeur(), f2.largeur());
    }

    @Override
    public boolean suivante(char[][] �cran) {
        if(f.suivante(�cran)) {
            return true;
        }
        if(f2.suivante(�cran))
            return true;
        return false;
    }

    @Override
    public void rembobiner() {
    }

}
