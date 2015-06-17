/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author timotheetroncy
 */
public class Fou extends AbstractPiece{

    public Fou(String name, Couleur couleur, Coord coord) {
        super(name, couleur, coord);
    }

    @Override
    public boolean specificMoveOk(int xFinal, int yFinal) {
        List<Coord> coords = getTargetCoords();
        return coordIsInTargetCoords(coords, new Coord(xFinal, yFinal));
    }
    
    private List<Coord> getTargetCoords() {
        List<Coord> coords = new ArrayList<Coord>();
        Boolean GH = true, GB = true, DH = true, DB = true;
        
        for (int i=1; i<8; i++){
            if (DB){
              coords.add(new Coord(getX()+i,getY()+i));
            }
            if (DH){
               coords.add(new Coord(getX()+i,getY()-i)); 
            }
            if (GB){
                coords.add(new Coord(getX()-i,getY()+i));
            }
            if (GH){
              coords.add(new Coord(getX()-i,getY()-i));  
            }
            
        }
        return coords;
    }

    private Boolean coordIsInTargetCoords(List<Coord> l, Coord c) {
        for (Coord ce : l) {
            if (ce.equals(c)) {
                return true;
            }
        }
        return false;
    }
    
}
