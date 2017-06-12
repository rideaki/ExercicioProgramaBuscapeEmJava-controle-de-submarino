package com.buscape.submarino.entity;

import static com.buscape.submarino.entity.enums.DIRECAO.LESTE;
import static com.buscape.submarino.entity.enums.DIRECAO.NORTE;
import static com.buscape.submarino.entity.enums.DIRECAO.OESTE;
import static com.buscape.submarino.entity.enums.DIRECAO.SUL;

import com.buscape.submarino.entity.enums.DIRECAO;
import com.buscape.submarino.entity.enums.ROTACAO;

/**
 * Classe utilizada para representar a posicao do Submarino
 * @author Reginaldo
 */
public class Posicao {

	private DIRECAO direcao;
    private int x;
    private int y;
    private int z;
    
    private final Direcoes<DIRECAO> direcoes = new Direcoes<DIRECAO>(new DIRECAO[]{LESTE, SUL, OESTE, NORTE});

    /**
     * Construtor
     * @param int x
     * @param int y
     * @param int z
     * @param DIRECAO direcao
     */
    public Posicao(int x, int y, int z, DIRECAO direcao) { 
        this.direcao = direcao;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Rotaciona o submarino de acordo com a rotacao: L(esquerda) ou R(direita).
     * @param ROTACAO rotacao
     */
    public void rotaciona(ROTACAO rotacao){
    	int indice = this.direcoes.indexOf(getDirecao());
    	switch (rotacao) {
    	case L:
    		setDirecao(direcoes.get(indice - 1));
    		break;
    	case R:
    		setDirecao(direcoes.get(indice + 1));
    		break;
    	}
    }

    /**
     * Movimenta o submarino em relacao a abcissa (x)
     * @param int deslocamento
     * @return Posicao posicao
     */
    public Posicao moveX(int deslocamento) {
    	this.x += deslocamento;
    	return this;
    }
    
    /**
     * Movimenta o submarino em relacao a ordenada (y)
     * @param int deslocamento
     * @return Posicao posicao
     */
    public Posicao moveY(int deslocamento) {
    	this.y += deslocamento;
    	return this;
    }
    
    /**
     * Movimenta o submarino em relacao a altura (z)
     * @param int deslocamento
     * @return Posicao posicao
     */
    public Posicao moveZ(int deslocamento) {
    	this.z += deslocamento;
    	return this;
    }
    
    /**
     * Getters e Setters
     */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public DIRECAO getDirecao() {
    	return this.direcao;
    }
    
    public void setDirecao(DIRECAO direcao){
    	this.direcao = direcao;
    }

}
