package controler.controlerLocal;


import model.Coord;
import model.observable.ChessGame;
import controler.AbstractChessGameControler;


/**
 * @author francoise.perrin
 * 
 * Ce controleur ne fait quasi rien � part
 * transformer les coordonn�es venant de la vue sous forme de Coord
 * en 2 int
 *
 */
public class ChessGameControler extends AbstractChessGameControler {
	
	
	public ChessGameControler(ChessGame chessGame) {
		super(chessGame);
	}
	
	public boolean move(Coord initCoord, Coord finalCoord) {
		return chessGame.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);		
	}
	

	

}
