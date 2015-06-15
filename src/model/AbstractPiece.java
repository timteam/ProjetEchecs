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
public abstract class AbstractPiece implements Pieces{

    private int x;
    private int y;
    private String name;
    private Couleur couleur;
    
    @Override
    public String toString() {
        return this.getName()+'_'+this.getX()+'_'+this.getY();
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
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
    
}
