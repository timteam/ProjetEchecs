package model.observable;


import java.util.List;
import java.util.Observable;
import model.Couleur;
import model.Echiquier;


/**
 * @author francoise.perrin
 * 
 * Cette classe rend un Echiquier Observable
 * et en simplifie l'interface ( DP Proxy, Facade, Observer)
 *
 */
public class ChessGame extends Observable{
	
	private final Echiquier echiquier;
	/**
	 * Cre une instance de la classe Echiquier
	 */
	public ChessGame() {
		super();
		this.echiquier = new Echiquier();
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = "";
		st += "\n" + echiquier.getMessage() + "\n";
		st = echiquier.toString();	
		return  st;
	}


	/**
	 * Permet de dplacer une pice connaissant ses coordonnes initiales vers ses
	 * coordonnes finales si le dplacement est "lgal". 
	 * Si dplacement OK, permet l'alternance des joueurs.
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return OK si dplacement OK
	 * si OK, permet l'alternance des joueurs
	 */
	public boolean move (int xInit, int yInit, int xFinal, int yFinal){
		boolean ret = false;
		if (!echiquier.isEchecEtMat()) {
			ret = echiquier.move(xInit, yInit, xFinal, yFinal);
		}
		if (ret){
			echiquier.switchJoueur();
		}
		this.setChanged();
		this.notifyObservers(new Object[]{xInit, yInit, xFinal, yFinal, ret});
		return ret;	
	}

	public boolean isEchecEtMat(){
		return echiquier.isEchecEtMat();
	}
	
	public String getMessage() {
		return echiquier.getMessage();
	}
	

	public Couleur getColorCurrentPlayer(){		
		return echiquier.getColorCurrentPlayer();		
	}	

}
