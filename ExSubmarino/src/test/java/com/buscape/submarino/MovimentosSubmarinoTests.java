package com.buscape.submarino;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.buscape.submarino.entity.Posicao;
import com.buscape.submarino.entity.Submarino;
import com.buscape.submarino.entity.enums.DIRECAO;

public class MovimentosSubmarinoTests {

	private Submarino submarino;

	@Before
	public void setUp() throws Exception {
		submarino = new Submarino();
	}

	@Test
	public void testePropostoPeloEnunciado() throws Exception {
		submarino.executaComandos("LMRDDMMUU");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(-1))));
		assertThat(position, hasProperty("y", is(equalTo(2))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}
	
	@Test
	public void testePropostoPeloEnunciado2() throws Exception {
		submarino.executaComandos("RMMLMMMDDLL");
		submarino.imprimePosicaoNaSaida();
		
		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(2))));
		assertThat(position, hasProperty("y", is(equalTo(3))));
		assertThat(position, hasProperty("z", is(equalTo(-2))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.SUL)));
	}
	
	@Test
	public void naoPodeUltrapassarSuperficie() throws Exception {
		submarino.executaComandos("UUUUDDUUUUU");
		submarino.imprimePosicaoNaSaida();
		
		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}
	
	@Test
	public void pontoOriginalLeste() throws Exception {
		submarino.executaComandos("UUUUR");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.LESTE)));
	}

	@Test
	public void pontoOriginalSul() throws Exception {
		submarino.executaComandos("DULL");
		submarino.imprimePosicaoNaSaida();
		
		Posicao position = submarino.getPosicao();
		
		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.SUL)));
	}
	
	@Test
	public void pontoOriginalNorte() throws Exception {
		submarino.executaComandos("RRRR");
		submarino.imprimePosicaoNaSaida();
		
		Posicao position = submarino.getPosicao();
		
		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}
	
	@Test
	public void pontoOriginalOeste() throws Exception {
		submarino.executaComandos("DDDLUUU");
		submarino.imprimePosicaoNaSaida();
		
		Posicao position = submarino.getPosicao();
		
		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.OESTE)));
	}
	
	@Test
	public void naoMoveComComandosInvalidos() throws Exception {
		submarino.executaComandos("ATPC");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}

	@Test
	public void desce2EContinuaAoNorte() {
		submarino.executaComandos("DD");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(-2))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}

	@Test
	public void desce5EContinuaAoNorte() {
		submarino.executaComandos("DDDDD");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(-5))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}

	@Test
	public void movimento2NaSuperficieAoNorte() {
		submarino.executaComandos("MM");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(2))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}
	
	@Test
	public void movimento5NaSuperficieAoNorte() {
		submarino.executaComandos("MMMMM");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(5))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}

	@Test
	public void movimento5NaSuperficieAOeste() {
		submarino.executaComandos("LMMMMM");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(-5))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.OESTE)));
	}
	
	@Test
	public void movimento5NaSuperficieALeste() {
		submarino.executaComandos("RMMMMM");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(5))));
		assertThat(position, hasProperty("y", is(equalTo(0))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.LESTE)));
	}
	
	@Test
	public void movimento5NaSuperficieASul() {
		submarino.executaComandos("RRMMMMM");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(0))));
		assertThat(position, hasProperty("y", is(equalTo(-5))));
		assertThat(position, hasProperty("z", is(equalTo(0))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.SUL)));
	}

	@Test
	public void sequenciaDeMovimentos() {
		submarino.executaComandos("DRMDMLMMDMDDLRLR");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();
		
		assertThat(position, hasProperty("x", is(equalTo(2))));
		assertThat(position, hasProperty("y", is(equalTo(3))));
		assertThat(position, hasProperty("z", is(equalTo(-5))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.NORTE)));
	}
	
	@Test
	public void sequenciaDeMovimentos2() {
		submarino.executaComandos("LMMRDLDLMLMLULUDDRDRD");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(-1))));
		assertThat(position, hasProperty("y", is(equalTo(-1))));
		assertThat(position, hasProperty("z", is(equalTo(-4))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.LESTE)));
	}

	@Test
	public void sequenciaDeMovimentos3() {
		submarino.executaComandos("LMDMDMDMRDLDLMLMLULUDDRDRD");
		submarino.imprimePosicaoNaSaida();

		Posicao position = submarino.getPosicao();

		assertThat(position, hasProperty("x", is(equalTo(-3))));
		assertThat(position, hasProperty("y", is(equalTo(-1))));
		assertThat(position, hasProperty("z", is(equalTo(-7))));
		assertThat(position, hasProperty("direcao", is(DIRECAO.LESTE)));
	}
}
