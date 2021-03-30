package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - this.position.getX();
        int deltaY = dest.getY() - this.position.getY();
        for (int i = 0; i < size; i++) {
            if (deltaX < 0 && deltaY > 0) {
                steps[i] = Cell.findBy(dest.getX() - deltaX - 1 - i,
                        dest.getY() - deltaY + 1 + i);
            } else if (deltaX < 0 && deltaY < 0) {
                steps[i] = Cell.findBy(dest.getX() - deltaX - 1 - i,
                        dest.getY() - deltaY - 1 - i);
            } else if (deltaX > 0 && deltaY > 0) {
                steps[i] = Cell.findBy(dest.getX() - deltaX + 1 + i,
                        dest.getY() - deltaY + 1 + i);
            } else if (deltaX > 0 && deltaY < 0) {
                steps[i] = Cell.findBy(dest.getX() - deltaX + 1 + i,
                        dest.getY() - deltaY - 1 - i);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
