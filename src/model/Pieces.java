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
interface Pieces {
    public Boolean capture();
    public Couleur getCouleur();
    public String getName();
    public int getX();
    public int getY();
    public Boolean isMoveOk(int xFinal, int yFinal);
    public Boolean move(int xFinal, int yFinal);
    
    
}
