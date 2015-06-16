/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author timotheetroncy
 */
public class Pion extends AbstractPiece implements Pions {

    public Pion(String name, Couleur couleur, Coord coord) {
        super(name, couleur, coord);
    }

    @Override
    public boolean specificMoveOk(int xFinal, int yFinal) {
        Couleur couleur = this.getCouleur();
        if (couleur == Couleur.BLANC) {
            if (getY() == 6) {
                return (xFinal == getX() && (getY() - yFinal) <=2 && (getY() - yFinal) > 0 );
            }
            return xFinal == getX() && getY() - yFinal == 1;
        } else {
            if (getY() == 1) {
                return (xFinal == getX() && (yFinal - getY()) <=2 && (yFinal - getY()) > 0);
            }
            return xFinal == getX() && yFinal - getY() == 1;
        }
    }

    @Override
    public Boolean isMoveDiagOk(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
