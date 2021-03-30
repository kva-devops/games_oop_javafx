package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Cell startPosition = Cell.C8;
        BishopBlack obj = new BishopBlack(startPosition);
        Cell rsl = obj.position();
        Assert.assertThat(rsl, is(startPosition));
    }

    @Test
    public void testCopy() {
        Cell startPosition = Cell.C8;
        Cell finishPosition = Cell.H3;
        BishopBlack objOrigin = new BishopBlack(startPosition);
        Figure objCopy = objOrigin.copy(finishPosition);
        Cell resultPosition = objCopy.position();
        Assert.assertThat(resultPosition, is(finishPosition));
    }

    @Test
    public void testWayC3E1() {
        Cell startPosition = Cell.C3;
        Cell finishPosition = Cell.E1;
        BishopBlack objOrigin = new BishopBlack(startPosition);
        Cell[] rsl = objOrigin.way(finishPosition);
        Cell[] exp = {Cell.D2, Cell.E1};
        Assert.assertThat(rsl, is(exp));
    }

    @Test
    public void testWayD4A1() {
        Cell startPosition = Cell.D4;
        Cell finishPosition = Cell.A1;
        BishopBlack objOrigin = new BishopBlack(startPosition);
        Cell[] rsl = objOrigin.way(finishPosition);
        Cell[] exp = {Cell.C3, Cell.B2, Cell.A1};
        Assert.assertThat(rsl, is(exp));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testIsNotDiagonalException() {
        Cell startPosition = Cell.D4;
        Cell finishPosition = Cell.A2;
        BishopBlack objOrigin = new BishopBlack(startPosition);
        objOrigin.way(finishPosition);
    }
}