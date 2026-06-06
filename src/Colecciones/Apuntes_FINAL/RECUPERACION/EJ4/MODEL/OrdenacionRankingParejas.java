package Colecciones.Apuntes_FINAL.RECUPERACION.EJ4.MODEL;

import Colecciones.Apuntes_FINAL.RECUPERACION.EJ4.REPOSITORY.RepoJuego;

import java.util.Comparator;

public class OrdenacionRankingParejas implements Comparator<Pareja> {

    //atributo xd
    private RepoJuego repo;

    //constructor

    public OrdenacionRankingParejas(RepoJuego repo) {
        this.repo = repo;
    }

    @Override
    public int compare(Pareja p1, Pareja p2) {
        return Integer.compare(repo.contadorVictorias(p2), repo.contadorVictorias(p1)); //está descendente
    }
}
