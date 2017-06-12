package com.buscape.submarino.entity.enums;

/**
 * 
 * @author Reginaldo
 *
 */
public enum DIRECAO {
	LESTE(1, 0), SUL(0, -1), NORTE(0, 1), OESTE(-1, 0);

    private int x;
    private int y;
	
    DIRECAO(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
}