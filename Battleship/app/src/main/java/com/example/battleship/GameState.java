package com.example.battleship;

public class GameState {
    private Board playerBoard;
    private Board opponentBoard;
    private boolean isPlayerTurn;

    public GameState() {
        playerBoard = new Board();
        opponentBoard = new Board();
        isPlayerTurn = true; // Assuming the player starts the game
    }

    public boolean isHit(int x, int y) {
        return opponentBoard.getCell(x, y) > 0;
    }

    public void makeMove(int x, int y) {
        if (opponentBoard.isValidMove(x, y)) {
            // Update the board
            opponentBoard.updateBoard(x, y);

            // Check if it's a hit or a miss
            if (isHit(x, y)) {
                // Handle a hit
                opponentBoard.setCell(x, y, Board.HIT);
            } else {
                // Handle a miss
                opponentBoard.setCell(x, y, Board.MISS);
            }

            // Switch turns
            isPlayerTurn = !isPlayerTurn;
        }
    }

    public boolean hasWon() {
        return opponentBoard.allShipsSunk();
    }

    // Other methods, such as placing ships, etc.
}
