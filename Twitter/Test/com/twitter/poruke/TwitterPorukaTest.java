package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka poruka;

	@Before
	public void setUp() throws Exception {

		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		poruka.setKorisnik("");
	}

	@Test
	public void testSetKorisnik() {
		poruka.setKorisnik("Mika");
		assertEquals("Mika", poruka.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}

	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Danas je suncan dan!");
		assertEquals("Danas je suncan dan!", poruka.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuza() {
		poruka.setPoruka("Danas je suncan dan! "
				+ "Danas je suncan dan! "
				+ "anas je suncan dan! "
				+ "Danas je suncan dan! "
				+ "Danas je suncan dan! "
				+ "Danas je suncan dan! "
				+ "Danas je suncan dan! "
				+ "Danas je suncan dan!");
	}

	@Test
	public void testToString() {
		poruka.setKorisnik("Mika");
		poruka.setPoruka("Danas je suncan dan!");
		assertEquals(
				"KORISNIK:" + "Mika" + " PORUKA:" + "Danas je suncan dan!",
				poruka.toString());
	}

}
