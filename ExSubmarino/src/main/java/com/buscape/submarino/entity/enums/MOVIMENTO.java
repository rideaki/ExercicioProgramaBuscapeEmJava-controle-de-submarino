package com.buscape.submarino.entity.enums;

import com.buscape.submarino.entity.Posicao;

/**
 * @author Reginaldo
 *
 */
public enum MOVIMENTO {
    U, D, M;    
    
    /**
     * Executa movimento de acordo com a posicaoOriginal e o movimento (this): U(sobe), D(desce) ou M(move na horizontal).
     * @param Posicao posicaoOriginal
     */
    public void executaMovimento(Posicao posicaoOriginal) {
    	switch (this) {
    	case U:
    		//se submarino ja esta na superficie nao pode subir
    		if (posicaoOriginal.getZ() < 0) {
    			posicaoOriginal.moveZ(1);
    		}
    		break;
    	case D:
    		posicaoOriginal.moveZ(-1);
    		break;
    		
    	case M:
    		posicaoOriginal.moveX(posicaoOriginal.getDirecao().getX()).
    		moveY(posicaoOriginal.getDirecao().getY());
    		
    	}
    }

    /**
     * Retorna <code>true</code> se contem comando, <code>false</code> caso contrario.
     * @param char comando
     * @return {@link Boolean}
     */
    public static boolean contem(char comando) {
    	MOVIMENTO movimento = retornaMovimento(comando);
    	return movimento != null;
    }
    
    /**
     * Retorna o movimento de acordo com o comando
     * @param char comando
     * @return MOVIMENTO movimento
     */
    public static MOVIMENTO retornaMovimento(char comando) {
    	try {
    		return valueOf(String.valueOf(comando));
    	} catch (IllegalArgumentException iae) {
    		return null;
    	}
    }

}
