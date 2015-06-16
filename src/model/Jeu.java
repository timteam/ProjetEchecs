/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.ChessPieceFactory;

/**
 *
 * @author timotheetroncy
 */
public class Jeu {

    private List<Pieces> pieces;
    private Couleur couleur;

    public Jeu(Couleur couleur) {
        this.pieces = ChessPieceFactory.newPieces(couleur);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        String string = "";
        for (Pieces p : pieces) {
            string += p.getName() + "_" + p.getX() + "_" + p.getY() + " - ";
        }
        return string;
    }

    private Pieces findPiece(Coord coord) throws Exception {
        for (Pieces p : pieces) {
            if (p.getX() == coord.x && p.getY() == coord.y) {
                return p;
            }
        }
        throw new Exception("Pas de pièce aux coordonnées x = " + coord.x + "y = " + coord.y);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Couleur getPieceCouleur(int x, int y) {
        try {
            Pieces p = findPiece(new Coord(x, y));
            return p.getCouleur();
        } catch (Exception e) {
            return null;
        }
    }

    public String getPieceName(int x, int y) {
        try {
            return findPiece(new Coord(x, y)).getName();
        } catch (Exception e) {
            return null;
        }

    }

    public String getPieceType(int x, int y) {
        try {
            return findPiece(new Coord(x, y)).getClass().getSimpleName();
        } catch (Exception e) {
            return null;
        }

    }

    public Boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        try {
            return findPiece(new Coord(xInit, yInit)).isMoveOk(xFinal, yFinal);
        } catch (Exception e) {
            return null;
        }

    }

    public Boolean isPieceHere(int x, int y) {
        try {
            Pieces p = findPiece(new Coord(x, y));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean Move(int xInit, int yInit, int xFinal, int yFinal) {
        if (!isPieceHere(xInit, yInit)) {
            return false;
        }
        try {
            Pieces p = findPiece(new Coord(xInit, yInit));
            return p.move(xFinal, yFinal);
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {

        Jeu jeu1 = new Jeu(Couleur.NOIR);
        Jeu jeu2 = new Jeu(Couleur.BLANC);
        System.out.println(jeu1);
        System.out.println(jeu2);
    }

//    public Boolean isPieceToCatchHere(int x, int y) {
//
//    }
//
//    public Boolean isPieceToMoveHere(int x, int y) {
//        
//    }

    public Boolean capture(int xCatch, int yCatch) {
        try {
            Pieces p = findPiece(new Coord(xCatch, yCatch));
            p.isCaught();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
