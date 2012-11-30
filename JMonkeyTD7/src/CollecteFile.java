import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollecteFile implements Collecte{
    
    FileWriter f;
    PrintWriter p;

    public CollecteFile(String filename) throws IOException{
        f = new FileWriter(filename);
	p = new PrintWriter(f);
    }

    public CollecteFile() throws IOException{
        f = new FileWriter("log.txt");
	p = new PrintWriter(f);
    }

    public void uneEntree(){
    }

    public void uneSortie(){
    }

    public void changerArret(){
    }
    
    public void terminerCollecte(){
	f.close();
    }
	
}