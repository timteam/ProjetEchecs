/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Array;
import java.util.List;
import model.observable.ChessGame;

/**
 *
 * @author timotheetroncy
 */
public class Echiquier {

    private Jeu jeuBlanc;
    private Jeu jeuNoir;
    private Jeu jeuCourant;
    private String message;

    public Echiquier() {
        this.jeuBlanc = new Jeu(Couleur.BLANC);
        this.jeuNoir = new Jeu(Couleur.NOIR);
        this.jeuCourant = jeuBlanc;
    }

    public boolean isEchecEtMat() {
        return false;
    }

    
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {

        if (!pieceDuJeuCourant(xInit, yInit)){
            return false;
        }
        if (someoneOnThePath(xInit, yInit, xFinal, yFinal) && isNotCavalier(xInit, yInit)) {
            return false;
        }
        if (isFriend(xFinal, yFinal)) {
            return false;
        }
        
        if (jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal)) {
            if (!isEmpty(xFinal, yFinal)) {
                //c'est un ennemi
                    //on le mange
                    getJeuAdverse().capture(xFinal, yFinal);
                }
            if (jeuCourant.Move(xInit, yInit, xFinal, yFinal))return true;
            
        }
        return false;

    }

    public void switchJoueur() {
        if (this.jeuCourant.getCouleur() == Couleur.BLANC) {
            this.jeuCourant = jeuNoir;
        } else {
            this.jeuCourant = jeuBlanc;
        }
    }
    public Jeu getJeuAdverse(){
        if (this.jeuCourant.getCouleur() == Couleur.BLANC) {
            return jeuNoir;
        }
        return jeuBlanc;
    }

    public Couleur getColorCurrentPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMessage() {
        return this.message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String string = "\t  0 \t  1 \t  2 \t  3 \t  4 \t  5 \t  6 \t  7\n";

        for (int y = 0; y < 8; y++) {
            string += y + "    \t";
            for (int x = 0; x < 8; x++) {

                if (jeuBlanc.isPieceHere(x, y)) {
                    string += jeuBlanc.getPieceName(x, y) + "\t";
                } else if (jeuNoir.isPieceHere(x, y)) {
                    string += jeuNoir.getPieceName(x, y) + "\t";
                } else {
                    string += "  X  \t";
                }
            }
            string += "\n";
        }

        return string;
    }

    public static void main(String[] args) {
        Echiquier ech = new Echiquier();
        System.out.println(ech);
        if (ech.move(1, 7, 0, 5)) {
            System.out.println("\nmouvement OK");
        } else {
            System.out.println("\nmouvement impossible");
        }
        System.out.println(ech);
    }

    private Boolean isEmpty(int xFinal, int yFinal) {
        if(jeuNoir.isPieceHere(xFinal, yFinal) || jeuBlanc.isPieceHere(xFinal, yFinal))return false;
        return true;
    }

    private Boolean isFriend(int xFinal, int yFinal) {
        return jeuCourant.isPieceHere(xFinal, yFinal);
    }

    private Boolean someoneOnThePath(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    private Boolean isNotCavalier(int xInit, int yInit) {
        if(jeuCourant.getPieceType(xInit, yInit) == "Cavalier"){
            return false;
        }
        return true;
    }

    private boolean pieceDuJeuCourant(int xInit, int yInit) {
        return jeuCourant.isPieceHere(xInit, yInit);
    }
}
