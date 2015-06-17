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
public class Roi extends AbstractPiece{

    public Roi(String name, Couleur couleur, Coord coord) {
        super(name, couleur, coord);
    }

    @Override
    public boolean specificMoveOk(int xFinal, int yFinal) {
        List<Coord> coords = getTargetCoords();
        return (coordIsInTargetCoords(coords, new Coord(xFinal, yFinal)));
    }
    
        private List<Coord> getTargetCoords(){
        List<Coord> coords = new ArrayList<Coord>();
        coords.add(new Coord (getX()+1,getY()+1));
        coords.add(new Coord (getX()+1,getY()-1));
        coords.add(new Coord (getX()-1,getY()+1));
        coords.add(new Coord (getX()-1,getY()-1));
        coords.add(new Coord (getX(),getY()+1));
        coords.add(new Coord (getX(),getY()-1));
        coords.add(new Coord (getX()+1,getY()));
        coords.add(new Coord (getX()-1,getY()));
        return coords;
    }
    private Boolean coordIsInTargetCoords(List<Coord> l, Coord c){
        for(Coord ce: l){
            if(ce.equals(c)){
                return true;
            }
        }
        return false;
    }
}
