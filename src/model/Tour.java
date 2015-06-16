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
public class Tour extends AbstractPiece{

    public Tour(String name, Couleur couleur, Coord coord) {
        super(name, couleur, coord);
    }
    @Override
    public boolean specificMoveOk(int xFinal, int yFinal) {
        return (getX() == xFinal || getY() == yFinal) && !(getX() == xFinal && getY() == yFinal);
    }
    
}
