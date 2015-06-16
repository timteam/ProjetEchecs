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

    public static void main(String[] args) {
        Pieces maTour = new Tour("N_To1", Couleur.NOIR, new Coord(0, 0));
        boolean moveOK;
        moveOK = maTour.isMoveOk(0, 4);
        moveOK = maTour.isMoveOk(1, 1);
        moveOK = maTour.isMoveOk(4, 0);
        moveOK = maTour.isMoveOk(10, 0);
        moveOK = maTour.isMoveOk(0, 0);
        moveOK = maTour.isMoveOk(0, 10);
        moveOK = maTour.isMoveOk(2, 1);
        moveOK = maTour.isMoveOk(0, 4);
        moveOK = maTour.isMoveOk(0, 4);

        Pieces monCavalier = new Cavalier("N_Ca1", Couleur.NOIR, new Coord(1, 0));
        boolean moveOK2;
        moveOK2 = monCavalier.isMoveOk(0, 2);
        moveOK2 = monCavalier.isMoveOk(2, 2);
        moveOK2 = monCavalier.isMoveOk(2, 0);
        moveOK2 = monCavalier.isMoveOk(-1, -1);
        moveOK2 = monCavalier.isMoveOk(1, 0);
        moveOK2 = monCavalier.isMoveOk(1, 0);

    }

    @Override
    public Boolean isMoveOk(int xFinal, int yFinal) {
        return Coord.coordonnees_valides(xFinal, yFinal) && specificMoveOk(xFinal, yFinal);
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
        System.out.print(this.coord.x);
        System.out.print(this.coord.y);
        if (isMoveOk(xFinal, yFinal)) {
            this.coord.x = xFinal;
            this.coord.y = yFinal;
            //DEBUG
            System.out.print(this.coord.x);
            System.out.print(this.coord.y);
            return true;
        }else{
            return false;
        }

    }

    public abstract boolean specificMoveOk(int xFinal, int yFinal);

}
