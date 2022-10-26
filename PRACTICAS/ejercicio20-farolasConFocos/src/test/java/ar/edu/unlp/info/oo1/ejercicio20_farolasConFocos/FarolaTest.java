package ar.edu.unlp.info.oo1.ejercicio20_farolasConFocos;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FarolaTest {
	 private Farola farolaUno;
	  private Farola farolaDos;
	  private Farola farolaTres;
	  private Farola farolaCuatro;
	  
	  

	  @BeforeEach
	  void setUp() throws Exception {
	    this.farolaUno = new Farola("fab",10);
	    this.farolaDos = new Farola("fab",1);
	    this.farolaTres = new Farola("fab",0);
	    this.farolaCuatro = new Farola("fab",0);


	  }

	  @Test
	  void testConstructor() {
	    assertFalse(farolaUno.isOn(), "La farolaUno no está apagada");
	    assertFalse(farolaUno.isOn(), "La farolaUno no está apagada");
	    assertTrue(farolaUno.getNeighbors().isEmpty(), "La farolaUno no debería tener vecinos");
	  }
	 
	  @Test
	  void testPairWithNeighbor() {
	    farolaUno.pairWithNeighbor(farolaDos);
	    assertTrue(farolaUno.getNeighbors().contains(farolaDos));
	    assertTrue(farolaDos.getNeighbors().contains(farolaUno));
	  }
	  
	  @Test
	  void testTurnOnAndOff() {
	    farolaUno.pairWithNeighbor(farolaDos);
	    farolaUno.turnOn();
	    assertEquals(9,farolaUno.getCantidadMaximaCiclos());
	    
	    assertTrue(farolaUno.isOn());
	    assertTrue(farolaDos.isOn());
	    
	    farolaUno.turnOff();
	    assertFalse(farolaUno.isOn());
	    assertFalse(farolaDos.isOn());

	    farolaDos.turnOn();
	    assertFalse(farolaUno.isOn());
	    assertFalse(farolaDos.isOn());
	    farolaDos.turnOff();
	    assertFalse(farolaUno.isOn());
	    assertFalse(farolaDos.isOn());
	    
	  }
	  
	  @Test
	  void testFocosVencidos() {
		    farolaUno.pairWithNeighbor(farolaDos);
		    farolaDos.pairWithNeighbor(farolaTres);
		    farolaTres.pairWithNeighbor(farolaCuatro);
		    
		    assertEquals(2,farolaUno.farolasConFocosVencidos().size());
		    assertTrue(farolaUno.farolasConFocosVencidos().contains(farolaCuatro));
		    assertTrue(farolaDos.farolasConFocosVencidos().contains(farolaTres));
		  
	  }
	}	