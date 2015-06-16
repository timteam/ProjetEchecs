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
public abstract class AbstractPiece implements Pieces {

    private Coord coord;
    private String name;
    private Couleur couleur;

    @Override
    final public Boolean isMoveOk(int xFinal, int yFinal) {
        return Coord.coordonnees_valides(xFinal, yFinal) && specificMoveOk(xFinal, yFinal);
    }

    @Override
    final public Boolean isCaught() {
        this.coord.x = this.coord.y = -1;
        return true;
    }

    public AbstractPiece(String name, Couleur couleur, Coord coord) {
        this.coord = coord;
        this.name = name;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return this.getName() + '_' + this.getX() + '_' + this.getY();
    }

    @Override
    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getX() {
        return this.coord.x;
    }

    @Override
    public int getY() {
        return this.coord.y;
    }

    @Override
    public Boolean move(int xFinal, int yFinal) {
        if (isMoveOk(xFinal, yFinal)) {
            this.coord.x = xFinal;
            this.coord.y = yFinal;
            return true;
        } else {
            return false;
        }

    }

    public abstract boolean specificMoveOk(int xFinal, int yFinal);

}
