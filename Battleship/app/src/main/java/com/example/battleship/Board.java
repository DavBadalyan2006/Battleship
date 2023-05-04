package com.example.battleship;

public class Board {
    public static final int BOARD_SIZE = 10;
    public static final int EMPTY = 0;
    public static final int HIT = -1;
    public static final int MISS = -2;

    private int[][] board;

    public Board() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public int getCell(int x, int y) {
        return board[x][y];
    }

    public void setCell(int x, int y, int value) {
        board[x][y] = value;
    }

    public boolean canPlaceShip(Ship ship, int x, int y, boolean isHorizontal) {
        if (isHorizontal) {
            if (x + ship.getSize() > BOARD_SIZE) {
                return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                if (board[x + i][y] != EMPTY) {
                    return false;
                }
            }
        } else {
            if (y + ship.getSize() > BOARD_SIZE) {
                return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                if (board[x][y + i] != EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeShip(Ship ship, int x, int y, boolean isHorizontal) {
        if (canPlaceShip(ship, x, y, isHorizontal)) {
            if (isHorizontal) {
                for (int i = 0; i < ship.getSize(); i++) {
                    board[x + i][y] = ship.getShipID();
                }
            } else {
                for (int i = 0; i < ship.getSize(); i++) {
                    board[x][y + i] = ship.getShipID();
                }
            }
            return true;
        }
        return false;
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] >= EMPTY;
    }

    public void updateBoard(int x, int y) {
        if (board[x][y] > EMPTY) {
            board[x][y] = HIT;
        } else {
            board[x][y] = MISS;
        }
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] > EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
