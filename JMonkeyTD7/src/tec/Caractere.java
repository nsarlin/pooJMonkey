/**
 * Here is the main package for our project.
 */
package tec;

public abstract class Caractere {

    public static Caractere CALME = new Calme();
    public static Caractere NERVEUX = new Nerveux();
    public static Caractere PRUDENT = new Prudent();
    public static Caractere AGORAPHOBE = new Agoraphobe();
    public static Caractere POLI = new Poli();
    
    protected Bus b;
    protected PassagerAbstrait pa;

    public Caractere() {
	this.pa = null;
    }

    public abstract void choixChangerPlace(int arret);

    public void setPassagerAbstrait(PassagerAbstrait pa)
    {
	this.pa = pa;
    }

    public void setBus(Bus b)
    {
	this.b = b;
    }

}
