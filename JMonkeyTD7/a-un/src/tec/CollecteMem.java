package tec;

import java.util.LinkedList;
import java.util.Iterator;

public class CollecteMem implements Collecte{
    Integer entres;
    Integer sortis;
    LinkedList<Integer> liste_entrees;
    LinkedList<Integer> liste_sorties;

    public CollecteMem(){
        entres = 0;
        sortis = 0;
        liste_entrees = new LinkedList<Integer>();
        liste_sorties = new LinkedList<Integer>();
    }

    public void uneEntree(){
        entres ++;
    }

    public void uneSortie(){
        sortis ++;
    }

    public void changerArret(){
        liste_entrees.add(entres);
        liste_sorties.add(sortis);
        entres = 0;
        sortis = 0;
    }

    public void terminerCollecte(){
        int nb_arret = liste_entrees.size();
        Iterator<Integer> it_entrees = liste_entrees.iterator();
        Iterator<Integer> it_sorties = liste_sorties.iterator();
        
        System.out.println("Collecte terminée. Voici l'historique des entrées/sorties\n");
        
        for(int arret = 1 ; arret <= nb_arret ; arret++) {
            System.out.println("Arrêt " + arret + " :");
            System.out.println((Integer)it_entrees.next() + " entrées");
            System.out.println((Integer)it_sorties.next() + " sorties\n");
        }
    }
}
