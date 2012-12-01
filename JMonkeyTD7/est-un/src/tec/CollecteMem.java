package tec;

import java.util.LinkedList;

public class CollecteMem implements Collecte{
    int entres;
    int sortis;
    LinkedList<int> liste_entrees;
    LinkedList<int> liste_sorties;

    public CollecteMem(){
        entres = 0;
        sortis = 0;
        liste_entrees = new LinkedList<int>;
        liste_sorties = new LinkedList<int>;
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
        Iterator<int> it_entrees = liste_entrees.iterator();
        Iterator<int> it_sorties = liste_sorties.iterator();
        
        System.out.println("Collecte terminée. Voici l'historique des entrées/sorties\n");
        
        for(int arret = 1 ; arret <= nb_arret ; arret++) {
            System.out.println("Arrêt " + arret + " :");
            System.out.println((int)it_entrees.next() + " entrées");
            System.out.println((int)it_sorties.next() + " sorties\n");
        }
    }
}