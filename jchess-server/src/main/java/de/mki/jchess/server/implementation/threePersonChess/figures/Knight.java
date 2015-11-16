package de.mki.jchess.server.implementation.threePersonChess.figures;

import de.mki.jchess.server.implementation.threePersonChess.Hexagon;
import de.mki.jchess.server.implementation.twoPersonChess.Square;
import de.mki.jchess.server.model.Chessboard;
import de.mki.jchess.server.model.Client;
import de.mki.jchess.server.model.Figure;

import java.util.List;

/**
 * Created by Igor on 12.11.2015.
 */
public class Knight extends Figure<Hexagon> {
    public Knight(String id, Client client) {
        super(client);
        setId(id);
        setName("Knight");
    }

    @Override
    public List<Hexagon> getPossibleMovements(Chessboard chessboard) {
        return null;
    }

    @Override
    public List<Hexagon> getPossibleSpecialMovements(Chessboard chessboard) {
        return null;
    }

}
