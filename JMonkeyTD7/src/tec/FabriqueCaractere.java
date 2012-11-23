/**
 * Here is the main package for our project.
 */
package tec;



public class FabriqueCaractere {

	public Calme getCalme() {
		return new Calme();
	}

	public Nerveux getNerveux() {
		return new Nerveux();
	}

	public Prudent getPrudent() {
		return new Prudent();
	}

	public Agoraphobe getAgoraphobe() {
		return new Agoraphobe();
	}

	public Poli getPoli() {
		return new Poli();
	}
}
