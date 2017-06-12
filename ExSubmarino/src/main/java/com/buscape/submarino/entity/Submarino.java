package com.buscape.submarino.entity;

import static com.buscape.submarino.entity.enums.DIRECAO.NORTE;

import com.buscape.submarino.entity.enums.DIRECAO;
import com.buscape.submarino.entity.enums.MOVIMENTO;
import com.buscape.submarino.entity.enums.ROTACAO;

/**
 * Classe utilizada para representar o submarino
 * @author Reginaldo
 */
public class Submarino {

	private Posicao posicao;

	/**
	 * Construtor
	 */
	public Submarino() {
		this(0, 0, 0, NORTE);
	}

	/**
	 * Construtor
	 * @param int x
	 * @param int y
	 * @param int z
	 * @param DIRECAO direcaoInicial
	 */
	public Submarino(int x, int y, int z, DIRECAO direcaoInicial) {
		posicao = new Posicao(x, y, z, direcaoInicial);
	}

	/**
	 * Executa comandos como sequencia de caracteres: U(sobe),D(desce), M(move), 
	 * 	L(gira para esquerda) ou R(gira para direita).
	 * @param String comandos
	 */
	public void executaComandos(String comandos) {
		for (char comando : comandos.toCharArray()) {

			if (MOVIMENTO.contem(comando)) {
				move(MOVIMENTO.retornaMovimento(comando));
				continue;
			} else if (ROTACAO.contem(comando)) {
				rotaciona(ROTACAO.retornaRotacao(comando));
				continue;
			}

		}
	}

	/**
	 * Rotaciona o submarino para esquerda se rotacao igual a L, ou para direita se rotacao igual a R
	 * @param ROTACAO rotacao
	 */
	private void rotaciona(ROTACAO rotacao) {
		this.posicao.rotaciona(rotacao);
	}

	/**
	 * Movimenta o submarino de acordo com o comando de movimento.
	 * @param MOVIMENTO comando
	 */
	private void move(MOVIMENTO comando) {
		comando.executaMovimento(posicao);
	}

	/**
	 * Getter
	 * @return Posicao posicao
	 */
	public Posicao getPosicao() {
		return posicao;
	}
	
}
