package tec;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollecteFile implements Collecte{
    
    FileWriter f;
    PrintWriter p;
    int entres;
    int sortis;
    int arret;

    public CollecteFile(String filename) throws IOException{
        f = new FileWriter(filename);
        p = new PrintWriter(f);
        entres = 0;
        sortis = 0;
        arret = 0;
    }

    public CollecteFile() throws IOException{
        f = new FileWriter("log.txt");
        p = new PrintWriter(f);
        entres = 0;
        sortis = 0;
        arret = 0;
    }

    public void uneEntree(){
        entres ++;
    }

    public void uneSortie(){
        sortis ++;
    }

    public void changerArret(){
        arret++;
        p.println("Arret " + arret + " :");
        p.println(entres + " entrees");
        p.println(sortis + " sorties\n");
        p.flush();
        entres = 0;
        sortis = 0;  
    }
    
    public void terminerCollecte() throws IOException{
        f.close();
    }

}
