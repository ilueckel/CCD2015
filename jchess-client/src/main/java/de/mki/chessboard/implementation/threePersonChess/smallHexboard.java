package de.mki.chessboard.implementation.threePersonChess;

import jchess.GUI;

import java.awt.*;
import java.util.List;

import static de.mki.chessboard.controller.GraphicsController.loadImage;

public class smallHexboard extends Hexboard {

    /**
     * default constructor for 600px x 600px hexagonal chessboard
     * @param list
     *
     */
    public smallHexboard(List list) {
        super(list);
        this.setWidth(600);
        this.setHeight(600);
        this.setHexHeight(46);
        this.setHexSize(new Point(27, 27));  //TODO: find fitting size.
        this.setOrigin(new Point(0, 0));     //TODO: find the actual origin point in the gui.
        this.setLayout(new Layout(Layout.pointy, getHexSize(), getOrigin()));
        this.setImage(loadImage("chessboard600x600.png"));
    }
}