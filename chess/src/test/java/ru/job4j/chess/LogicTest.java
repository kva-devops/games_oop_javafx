package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = OccupiedCellException.class)
    public void testMoveOccupiedCellTrue()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.E3);
    }

    @Test (expected = FigureNotFoundException.class)
    public void testFigureNotFoundExceptionTrue()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.E3);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testImpossibleMoveExceptionTrue()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.E4);
    }
}