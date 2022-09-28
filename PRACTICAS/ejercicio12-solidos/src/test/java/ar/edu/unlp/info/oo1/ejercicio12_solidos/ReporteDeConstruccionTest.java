package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeConstruccionTest {
	
	ReporteDeConstruccion reporteConMaterial;
	ReporteDeConstruccion reporteSinMaterial;
	Pieza cilindro;
	Pieza cilindro2;
	Pieza prisma;
	Pieza esfera;

	@BeforeEach
	void setUp() throws Exception {
		this.reporteConMaterial =  new ReporteDeConstruccion();
		this.reporteSinMaterial =  new ReporteDeConstruccion();
		this.cilindro = new Cilindro("Hierro", "Rojo", 2,2);
		this.cilindro2 = new Cilindro("Hierro", "Verde", 2,2);
		this.prisma = new PrismaRectangular ("Hierro", "Rojo",2,2,2);
		this.esfera = new Esfera ("Madera","Rojo",2);
		this.reporteConMaterial.agregarPieza(cilindro);
		this.reporteConMaterial.agregarPieza(cilindro2);
		this.reporteConMaterial.agregarPieza(esfera);
		this.reporteConMaterial.agregarPieza(prisma);
	}

	@Test
	void testGetVolumenDeMaterial() {
		assertEquals(58,Math.round(this.reporteConMaterial.getVolumenDeMaterial("Hierro")));
		assertEquals(0,this.reporteSinMaterial.getVolumenDeMaterial("Madera"));
	}
	
	@Test
	void testGetSuperficieDeMaterial() {
		assertEquals(125,Math.round(this.reporteConMaterial.getSuperficieDeColor("Rojo")));
		assertEquals(0,this.reporteSinMaterial.getSuperficieDeColor("Verde"));

	}

}
