package com.buscape.submarino.entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subclasse de ArrayList. Utiliza generics para obrigar utilizacao de DIRECAO.
 * @author Reginaldo
 */
public class Direcoes<DIRECAO> extends ArrayList<DIRECAO> {
	private static final long serialVersionUID = 397066047217662903L;
	
	/**
	 * Construtor
	 * @param DIRECAO[] direcoes
	 */
	public Direcoes(DIRECAO[] direcoes) {
        super(Arrays.asList(direcoes));
    }

	/**
	 * Retorna a direcao de acordo com o indice da lista {LESTE, SUL, OESTE, NORTE}
	 * @param int indice
	 * @return DIRECAO direcao
	 */
	@Override
	public DIRECAO get(int indice) {
		//Lista de direcoes deve ser "circular". Rotacao para direita (R): NORTE para LESTE.
		if (indice == size()) {
			indice = 0;
		//Lista de direcoes deve ser "circular". Rotacao para esquerda (L): LESTE para NORTE.
		} else if (indice == -1) {
            indice = size() - 1;
        }

        return super.get(indice);
    }
}
