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
public class Cavalier extends AbstractPiece{

    public Cavalier(String name, Couleur couleur, Coord coord) {
        super(name, couleur, coord);
    }

    private List<Coord> getTargetCoords(){
        List<Coord> coords = new ArrayList<Coord>();
        coords.add(new Coord (getX()+2,getY()+1));
        coords.add(new Coord (getX()+2,getY()-1));
        coords.add(new Coord (getX()-2,getY()+1));
        coords.add(new Coord (getX()-2,getY()-1));
        coords.add(new Coord (getX()+1,getY()+2));
        coords.add(new Coord (getX()+1,getY()-2));
        coords.add(new Coord (getX()-1,getY()+2));
        coords.add(new Coord (getX()-1,getY()-2));
        return coords;
    }
    private Boolean coordIsInTargetCoords(List<Coord> l, Coord c){
        for(Coord ce: l){
            if(ce.isEqual(c)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean specificMoveOk(int xFinal, int yFinal) {
        List<Coord> coords = getTargetCoords();
        return (coordIsInTargetCoords(coords, new Coord(xFinal, yFinal)));
    }
}
