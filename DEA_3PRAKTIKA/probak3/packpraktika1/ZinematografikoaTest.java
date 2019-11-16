package packpraktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZinematografikoaTest {
	
	Zinematografikoa aktore1, aktore2, peli1, peli2 = null;	

	@Before
	public void setUp() throws Exception {
		
		aktore1 = new Aktorea("Santa Clus");
		aktore2 = new Aktorea("Sr. Crack");
		peli1 = new Pelikula("Popiloluta");
		peli2 = new Pelikula("Rasengan OMG");	
		
	}

	@After
	public void tearDown() throws Exception {
		
		aktore1 = null;	
		aktore2 = null;	
		peli1 = null;	
		peli2 = null;			
		
	}
	
	@Test
	public void testInstantziaBerekoak() {
		
		//1. this Aktorea eta pZinemakoa Pelikula     ---> False
		assertFalse(aktore1.instantziaBerekoak(peli1));		
		
		 
		//2. this Pelikula eta pZinemakoa Aktorea		---> False
		assertFalse(peli1.instantziaBerekoak(aktore1));	
		
		
		//3. this Aktorea eta pZinemakoa Aktorea		---> True
		assertTrue(aktore1.instantziaBerekoak(aktore2));	
		
		//4. this Pelikula eta pZinemakoa Pelikula	---> True
		assertTrue(peli1.instantziaBerekoak(peli2));	
				
		
	}

}
