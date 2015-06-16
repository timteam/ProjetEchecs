package model.observable;


import java.util.List;
import java.util.Observable;
import java.util.Observer;
import model.Couleur;
import model.Echiquier;


/**
 * @author francoise.perrin
 * 
 * Cette classe rend un Echiquier Observable
 * et en simplifie l'interface ( DP Proxy, Facade, Observer)
 *
 */
public class ChessGame extends Observable {
	
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

    @Override
    public synchronized int countObservers() {
        return super.countObservers(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
    }
        
        

}
