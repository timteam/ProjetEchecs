/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import model.Coord;
import model.Couleur;
import model.Echiquier;
import model.observable.ChessGame;
import tools.ChessImageProvider;

/**
 *
 * @author timotheetroncy
 */
public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener {

    private final JLayeredPane layeredPane;
    private final JPanel chessBoard;
    private ChessGameControlers controler;
    private HashMap<JPanel, Coord> cases;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    private int beforeX;
    private int beforeY;

    public ChessGameGUI(String jeu_d_echec, ChessGameControlers chessGameControler, Dimension dim) {

        cases = new HashMap();
        Dimension boardSize = dim;
        controler = chessGameControler;
        //  Use a Layered Pane for this this application
        this.setTitle(jeu_d_echec);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane 
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            cases.put(square, new Coord(i % 8, i / 8));

            int row = (i / 8) % 2;
            if (row == 0) {
                square.setBackground(i % 2 == 0 ? Color.black : Color.white);
            } else {
                square.setBackground(i % 2 == 0 ? Color.white : Color.black);
            }
        }
        initPieces();
    }

    private void initPieces() {
        String file;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (ChessImageProvider.isCoordOK(x, y)) {
                    file = ChessImageProvider.getImageFile(ChessImageProvider.getType(x, y), ChessImageProvider.getCouleur(x, y));
                    JLabel piece = new JLabel(new ImageIcon(file));
                    JPanel panel = (JPanel) chessBoard.getComponent(x *8 + y);
                    panel.add(piece);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) {
            return;
        }

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        beforeX = e.getX();
        beforeY = e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (chessPiece == null) {
            return;
        }

        JPanel panelDebut = (JPanel) chessBoard.findComponentAt(beforeX, beforeY);
        Coord coordDebut = cases.get(panelDebut);

        JPanel panelFin = (JPanel) chessBoard.findComponentAt(e.getX(), e.getY());
        Coord coordFin = cases.get(panelFin);

        System.out.println(coordDebut);
        System.out.println(coordFin);
        chessPiece.setVisible(false);
        
        Boolean moveOK = controler.move(coordDebut, coordFin);
        
        if (moveOK) {
                Container parent = (Container) panelFin;
                parent.add(chessPiece);
            
        } else {
                Container parent = (Container) panelDebut;
                parent.add(chessPiece);
            
        }

        chessPiece.setVisible(true);
    }

@Override
        public void mouseEntered(MouseEvent e) {

    }

    @Override
        public void mouseExited(MouseEvent e) {

    }

    @Override
        public void mouseDragged(MouseEvent e) {
        if (chessPiece == null) {
            return;
        }
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    @Override
        public void mouseMoved(MouseEvent e) {

    }

}
