

public class CollecteMem implements Collecte{
    int entres;
    int sortis;
    int arret;
    int log[];

    public CollecteMem(){
    	entres = 0;
	sortis = 0;
	arret = 0;
	log = new int[256];
    }

    public void uneEntree(){
	entres ++;
    }

    public void uneSortie(){
	sortis ++;
    }

    public void changerArret(){
	log[arret*3] = entres;
	log[arret*3+1] = sortis;
	log[arret*3+2] = arret;
	entres = 0;
	sortis = 0;
	arret ++;
    }

    public void terminerCollecte(){
	System.out.println("Collecte terminée. Voici l'historique des entrées/sorties :");
	for(int i = 0; i < arret+1; i++){
	    System.out.print(log[i*3]);
	    System.out.print("-");
	    System.out.print(log[i*3+1]);
	    System.out.print("-");
	    System.out.println(log[i*3+2]);
	}	    
    }
}