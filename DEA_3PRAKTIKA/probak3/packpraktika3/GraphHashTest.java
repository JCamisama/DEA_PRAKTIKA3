package packpraktika3;

import packpraktika1.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class GraphHashTest {

	Zinematografikoa aktore1, aktore2, peli1, peli2 = null;	
	GraphHash gHau;
	IrakurketakEtaIdazketak cHau;
	ArrayList<Zinematografikoa> erlazioak;

	@Before
	public void setUp() throws Exception {
		
		cHau		= new IrakurketakEtaIdazketak();
		aktore1 = new Aktorea("Santa Claus");		
		peli1 = new Pelikula("Popiloluta");
		
	}

	@After
	public void tearDown() throws Exception {
		
		gHau.erreseteatuFrogetan();
		aktore1 = null;		
		peli1 = null;
		erlazioak = null;
			
	}

	@Test
	public void testGrafoaSortu() {
		
		/*Proba kasuak:
		 
	 	1. Aktorerik eta pelikularik ez.
	 	2. Aktoreen zerrenda beteta, pelikulena ez.
	 	3. Aktore bakarra eta Pelikula bakarra.
	 	4. Aktoreen zerrenda eta pelikulen zerrenda beteta.
	 */
		
		//1. Aktorerik eta pelikularik ez.
		
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Aktorerik eta pelikularik ez*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Fitxategi Hutsa.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		
		
		
		//2. Aktoreen zerrenda beteta, pelikulena ez.
		 
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******2. Aktoreen zerrenda beteta, pelikulena ez*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Fitxategi Hutsa.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 Aktorea aktore1 = new Aktorea("Jonport");
		 Aktorea aktore2 = new Aktorea("Ultoraman");
		 
		 	//Aktoreak aktoreen zerrenda nagusira gehitzen
		 AktoreGuztiak.getNireAktoreak().gehituAktorea(aktore1);
		 AktoreGuztiak.getNireAktoreak().gehituAktorea(aktore2);
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		 AktoreGuztiak.getNireAktoreak().erreseteatu();
		
		
		
		
		
		//3. Aktoreen zerrenda hutsa, pelikulena beteta.
		 
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******3. Aktoreen zerrenda hutsa, pelikulena beteta*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Fitxategi Hutsa.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 Pelikula peli1 = new Pelikula("Jonport, la pelicula");
		 Pelikula peli2 = new Pelikula("Jonport, el regreso");
		 
		 	//Pelikulak pelikulen zerrenda nagusira gehitzen
		 PelikulaGuztiak.getNirePelikulak().gehituPelikula(peli1);
		 PelikulaGuztiak.getNirePelikulak().gehituPelikula(peli2);
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		 AktoreGuztiak.getNireAktoreak().erreseteatu();
		 PelikulaGuztiak.getNirePelikulak().erreseteatu();
		
		
		
		
		
		//4. Aktore bakarra eta Pelikula bakarra.
		

		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******4. Aktore bakarra eta Pelikula bakarra*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/AktorePeliBakarra.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 

	
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		 AktoreGuztiak.getNireAktoreak().erreseteatu();
		 PelikulaGuztiak.getNirePelikulak().erreseteatu();
		 
		 
		 
		//5. Aktoreen eta Pelikulen zerrendak beteta.
		
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******5. Aktoreen eta Pelikulen zerrendak beteta*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Murriztuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 

	
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		 AktoreGuztiak.getNireAktoreak().erreseteatu();
		 PelikulaGuztiak.getNirePelikulak().erreseteatu();

		
	}
	
	@Test
	public void testKonektatuta() {
		
		
		/*Proba kasuak:
		 
	 	1. Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (False)
	 	2. Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (False)
	 	3. Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (False)
	 	4. Elementuak erlazioak dituzte, baina ez bien artean (False)
	 	5. Erlazio zuzena (aktorea pelikulan lan egin duenean (True)
	 	6. Aktoreen arteko erlazioa (pelikula berean lan egin dute) (True)
	 	7. Izen berdineko aktore eta pelikula baten artean erlazioa egotea (True)
	 	8. Izen ezberdineko bi elementuen artean erlazioa egotea (True)
	 	9. Bi elementuen artean erlazio bat baino gehiago egotea.
	 	10. Null elementuak sartzerakoan

	 */
		
		
		
		//1. Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (False)
		
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (False)*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Konektatuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		
		 
		 	//Aktoreak aktoreen zerrenda nagusira gehitzen
		 AktoreGuztiak.getNireAktoreak().gehituAktorea((Aktorea)aktore1); //Santa Claus aktorea gehitu da.
		 	//Aktorerik gabeko pelikula gehitzen
		 PelikulaGuztiak.getNirePelikulak().gehituPelikula(new Pelikula("Aktorerik Gabekoa"));
		 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Aktorerik Gabekoa");
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Santa Claus");
		 
		 
		 	//Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		
		 	//Santa Claus pelikularik ez dituela eta Aktorerik Gabekoa aktorerik ez
		 assertFalse(gHau.konektatuta(peli2, aktore2));
		 
	
		 //2. Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (False)
			
		
		
		 System.out.println("\t\t\t*******2. Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (False)*******\n");
		 System.out.println("\n\n\n\n");	 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Oceans 11"); //Waltz eta Pitt ditu.
		 assertEquals("Oceans 11", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Santa Claus"); //Pelikularik ez dauka.	 
		 assertEquals("Santa Claus", aktore2.getIzena());
		 
		
		 assertFalse(gHau.konektatuta(peli2, aktore2));	 
		 
		 
		
		 //3. Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (False)
			
		
		 
		 System.out.println("\t\t\t*******3. Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (False)*******\n");
		 System.out.println("\n\n\n\n");	
		 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Aktorerik Gabekoa");
		 assertEquals("Aktorerik Gabekoa", peli2.getIzena());
		 
		 	
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 
		 
		 assertFalse(gHau.konektatuta(peli2, aktore2));		 
		 System.out.println("\n\n\n\n");
		
	
		//4. Elementuak erlazioak dituzte, baina ez bien artean (False)
			
		 
		 
		 System.out.println("\t\t\t*******4. Elementuak erlazioak dituzte, baina ez bien artean (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Random Film");
		 assertEquals("Random Film", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");		 
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 	
		 assertFalse(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		 
		
		//5. Erlazio zuzena (aktorea pelikulan lan egin duenean (True).
			
		 
		 
		 System.out.println("\t\t\t*******5. Erlazio zuzena (aktorea pelikulan lan egin duenean (True)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Random Film");
		 assertEquals("Random Film", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Regular Guy");		 
		 assertEquals("Regular Guy", aktore2.getIzena());
		 
		 
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		 
		 
	
		 //6. Aktoreen arteko erlazioa (pelikula berean lan egin dute) (True)
			
		 
		 
		 System.out.println("\t\t\t*******6. Aktoreen arteko erlazioa (pelikula berean lan egin dute) (True)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 aktore1 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Waltz");		 
		 assertEquals("Waltz", aktore1.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");		 
		 assertEquals("Pitt", aktore2.getIzena());
		 
		
		 assertTrue(gHau.konektatuta(aktore1, aktore2));	 
		 System.out.println("\n\n\n\n");
		
		 
		 
		
		 //7. Izen berdineko aktore eta pelikula baten artean erlazioa egotea (True)
		 
		 System.out.println("\t\t\t*******7. Izen berdineko aktore eta pelikula baten artean erlazioa egotea (True)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Sergio Ramos");
		 assertEquals("Sergio Ramos", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos");		 
		 assertEquals("Sergio Ramos", aktore2.getIzena());
		 
		 
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		
		
		 
		 
		 
		 //8. Izen ezberdineko bi elementuen artean erlazioa egotea (True)
		 
		 System.out.println("\t\t\t*******8. Izen ezberdineko bi elementuen artean erlazioa egotea (True)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Troya");
		 assertEquals("Troya", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos");		 
		 assertEquals("Sergio Ramos", aktore2.getIzena());
		 
		 
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		 
		 
	
		 
		 //9. Bi elementuen artean erlazio bat baino gehiago egotea. (True)
		 
		 System.out.println("\t\t\t*******9. Bi elementuen artean erlazio bat baino gehiago egotea. (True)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Fight Club");
		 assertEquals("Fight Club", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Waltz");		 
		 assertEquals("Waltz", aktore2.getIzena());
		 
		 
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		 
		 //10. Null elementuak sartzerakoan. (False)
		 
		 System.out.println("\t\t\t*******10. Null elementuak sartzerakoan. (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  null;
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  null;		 
		
		 assertFalse(gHau.konektatuta(peli2, aktore2));	 
		 System.out.println("\n\n\n\n");
		 
		
	}

	
	@Test
	public void testErlazionatuta() {
		
		/*Proba kasuak:
		 
	 	1.  Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (Zerrenda hutsa)
	 	2.  Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (Zerrenda hutsa)
	 	3.  Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (Zerrenda hutsa)
	 	4.  Elementuak erlazioak dituzte, baina ez bien artean (Zerrenda hutsa)
	 	5.  Erlazio zuzena (aktorea pelikulan lan egin duenean (Zerrenda ez-hutsa)
	 	6.  Aktoreen arteko erlazioa (pelikula berean lan egin dute) (Zerrenda ez-hutsa)
	 	7.  Izen berdineko aktore eta pelikula baten artean erlazioa egotea (Zerrenda ez-hutsa)
	 	8.  Izen ezberdineko bi elementuen artean erlazioa egotea (Zerrenda ez-hutsa)
	 	9.  Bi elementuen artean bide bat baino gehiago egotea. (Guztiak Luzera berekoak)
	 	10. Bi elementuen artean bide bat baino gehiago egotea. (Luzera txikiena duen zerrenda)
	 	11. Bi elementuen arteko bide luzea. (Zerrenda ez-hutsa)
	 	12. Null elementuak sartzerakoan.   (Zerrenda hutsa)
	*/
		
		//1. Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (Zerrenda hutsa)
		
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (Zerrenda hutsa)*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Konektatuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 

		 	//Aktoreak aktoreen zerrenda nagusira gehitzen
		 AktoreGuztiak.getNireAktoreak().gehituAktorea((Aktorea)aktore1); //Santa Claus aktorea gehitu da.
		 	//Aktorerik gabeko pelikula gehitzen
		 PelikulaGuztiak.getNirePelikulak().gehituPelikula(new Pelikula("Aktorerik Gabekoa"));
		 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Aktorerik Gabekoa");
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Santa Claus");
		 
		 
		 	//Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		
		 	//Santa Claus pelikularik ez dituela eta Aktorerik Gabekoa aktorerik ez, 
		 												//zerrenda hutsa izango da (luzera = 0)
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 0);
		 
		 
		 
		 //2.  Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (Zerrenda hutsa)
			
		 System.out.println("\t\t\t*******2.  Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (Zerrenda hutsa)*******\n");
		 System.out.println("\n\n\n\n");	 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Oceans 11"); //Waltz eta Pitt ditu.
		 assertEquals("Oceans 11", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Santa Claus"); //Pelikularik ez dauka.	 
		 assertEquals("Santa Claus", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 0);
 
		
		
		 
		 //3.  Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (Zerrenda hutsa)
			
		
		 
		 System.out.println("\t\t\t*******3.  Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (Zerrenda hutsa)*******\n");
		 System.out.println("\n\n\n\n");	
		 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Aktorerik Gabekoa");
		 assertEquals("Aktorerik Gabekoa", peli2.getIzena());
		 
		 	
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 0);
		 	 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 //4.  Elementuak erlazioak dituzte, baina ez bien artean (Zerrenda hutsa)
			
		 System.out.println("\t\t\t*******4.  Elementuak erlazioak dituzte, baina ez bien artean (Zerrenda hutsa)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Random Film");
		 assertEquals("Random Film", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");		 
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 0);
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 //5.  Erlazio zuzena (aktorea pelikulan lan egin duenean (Zerrenda ez-hutsa)
			
		 System.out.println("\t\t\t*******5.  Erlazio zuzena (aktorea pelikulan lan egin duenean (Zerrenda ez-hutsa)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Random Film");
		 assertEquals("Random Film", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Regular Guy");		 
		 assertEquals("Regular Guy", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 2);
		 
		 
		 Iterator<Zinematografikoa> itr5 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr5.hasNext()){
			 
			 System.out.print("<"+itr5.next().getIzena()+">, ");
			 //<Random Film>, <Regular Guy>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 
		//6.  Aktoreen arteko erlazioa (pelikula berean lan egin dute) (Zerrenda ez-hutsa)
			
		 System.out.println("\t\t\t*******6.  Aktoreen arteko erlazioa (pelikula berean lan egin dute) (Zerrenda ez-hutsa)*******\n");
			 
			//Bilatu nahi dugun pelikula bilatzen
		 aktore1 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Ozzy");		 
		 assertEquals("Ozzy", aktore1.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos");		 
		 assertEquals("Sergio Ramos", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(aktore1, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 3);
		 
		 
		 Iterator<Zinematografikoa> itr6 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr6.hasNext()){
			 
			 System.out.print("<"+itr6.next().getIzena()+">, ");
			 //<Ozzy>, <Futbolocura>, <Sergio Ramos>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
	
		 
		//7.  Izen berdineko aktore eta pelikula baten artean erlazioa egotea (Zerrenda ez-hutsa)
			
		 System.out.println("\t\t\t*******7.  Izen berdineko aktore eta pelikula baten artean erlazioa egotea (Zerrenda ez-hutsa)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Sergio Ramos");
		 assertEquals("Sergio Ramos", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos");		 
		 assertEquals("Sergio Ramos", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 4);
		 
		 
		 Iterator<Zinematografikoa> itr7 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr7.hasNext()){
			 
			 System.out.print("<"+itr7.next().getIzena()+">, "); 
			 //<Sergio Ramos(pelikula)>, <Ozzy>, <Futbolocura>, <Sergio Ramos (aktorea)>
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		//8.  Izen ezberdineko bi elementuen artean erlazioa egotea (Zerrenda ez-hutsa)
			
		 System.out.println("\t\t\t*******8.  Izen ezberdineko bi elementuen artean erlazioa egotea (Zerrenda ez-hutsa)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Villains");
		 assertEquals("Villains", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Madrileko1");		 
		 assertEquals("Madrileko1", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(peli2, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 6);
		 
		 
		 Iterator<Zinematografikoa> itr8 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr8.hasNext()){
			 
			 System.out.print("<"+itr8.next().getIzena()+">, ");
			 //<Villains>, <Nicholson>, <Shining>, <Ozzy>, <Sergio Ramos>, <Madrileko1>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 
		 
		 //9.  Bi elementuen artean bide bat baino gehiago egotea. (Guztiak Luzera berekoak)
			
		 System.out.println("\t\t\t*******9.  Bi elementuen artean bide bat baino gehiago egotea. (Guztiak Luzera berekoak)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 aktore1 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Waltz");		 
		 assertEquals("Waltz", aktore1.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");		 
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(aktore1, aktore2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 3);
		 
		 
		 Iterator<Zinematografikoa> itr9 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr9.hasNext()){
			 
			 System.out.print("<"+itr9.next().getIzena()+">, ");
			 //<Waltz>, <Oceans 11>, <Pitt>,   edo   <Waltz>, <Bastards>, <Pitt>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 
		 
		//10. Bi elementuen artean bide bat baino gehiago egotea. (Luzera txikiena duen zerrenda)
			
		 System.out.println("\t\t\t*******10. Bi elementuen artean bide bat baino gehiago egotea. (Luzera txikiena duen zerrenda)*******\n");
			 
			//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Shining");
		 assertEquals("Shining", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");		 
		 assertEquals("Pitt", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(aktore2, peli2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 4);
		 
		 
		 Iterator<Zinematografikoa> itr10 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr10.hasNext()){
			 
			 System.out.print("<"+itr10.next().getIzena()+">, ");
			 //<Pitt>, <Fight Club>, <Sekundario 1>, <Shining>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 
		 //11. Bi elementuen arteko bide luzea. (Zerrenda ez-hutsa)
			
		 System.out.println("\t\t\t*******11. Bi elementuen arteko bide luzea. (Zerrenda ez-hutsa)*******\n");
			 
			//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Jonportena");
		 assertEquals("Jonportena", peli2.getIzena());
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Jonport");		 
		 assertEquals("Jonport", aktore2.getIzena());
		 
		 erlazioak = gHau.erlazionatuta(aktore2, peli2);
		 assertNotNull(erlazioak);
		 assertEquals(erlazioak.size(), 12);
		 
		 
		 Iterator<Zinematografikoa> itr11 = erlazioak.iterator();
		 System.out.print("Zerrenda: ");
		 
		 while (itr11.hasNext()){
			 
			 System.out.print("<"+itr11.next().getIzena()+">, ");
			 //<Jonport>, <Taxi stuff>, <Ricardo>, <Troya>, <Pitt>,
			 //   <Fight Club>, <Sekundario 1>, <Shining>, <Ozzy>, <Futbolocura>, <Sergio Ramos>, <Jonportena>,
		 }
		 
		 
		 System.out.println("\n\n\n\n");
		 
		 
		 
		 //12. Null elementuak sartzerakoan.   (null)
			
		 System.out.println("\t\t\t*******12. Null elementuak sartzerakoan.   (null)*******\n");
			 
		
		 peli2 =  null;
		 aktore2 =  null;		 
		
		 
		 erlazioak = gHau.erlazionatuta(aktore2, peli2);
		 assertNull(erlazioak);
		 
		 
		 
		 System.out.println("\n\n\n\n");
	
		
	}


	@Test
	
	public void testGragoaSortuExperimentala(){
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak)*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 gHau.erreseteatuFrogetan();
		
		
		
		
		
		
	}
	
	
	
	@Test
		
	public void testKonektatutaExperimentala(){

		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak): KONEKTATUTA*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		//Grafoa sortzen eta nodo kopurua zehazten
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 
		 //Elememtuen Arraya sortzen auzazko zenbakiekien lan egin ahal izateko
		 Zinematografikoa[] grafokoElemGuztiak = gHau.elementuenArrayaLortu();
		 
		 Random ausazkoak = new Random();
		 
		 //Behin eta berriro elementuak sartzeko erabiliko diren erakusleak
		 Zinematografikoa zine1  = null;
		 Zinematografikoa zine2  = null;
		 int 			  a		 = 0;
		 int			  b		 = 0;
		 int			  probak = 100;
		 
		 //Batez-besteko denbora, maximoa eta minimoa
		 double hartuta = 0.00;
		 double minimoa = 0.00;
		 double maximoa = 0.00;
		 double akumula = 0.00;
		 double batazbe = 0.00;
		 boolean erantz = false;
		 
		 for (int i = 0; i < probak; i++){
			 
			 //Auzazko zenbakiak hartzen
			 a = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
			 b = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
		
			 //Ausazko elementuak hartzen grafotik
			 zine1 = grafokoElemGuztiak[a];
			 zine2 = grafokoElemGuztiak[b];
			 
			 if( !zine1.equals(zine2) ){ //Aurrebaldintza: ez da elementu berbera sartuko metodoan
			 
				 //konektatuta metodoaren exekuzio denbora aztertzen
				 Stopwatch kronometroa = new Stopwatch();
				 System.out.print("\n"+i +". Konetatuta froga empirikoa: "+zine1.getIzena()+" eta "+zine2.getIzena()+
						 "konektatuta? ");
				 erantz = gHau.konektatuta(zine1, zine2);
				 hartuta = kronometroa.elapsedTime();
				 System.out.println(erantz);
				 System.out.println("\nTardatutako denbora: "+hartuta+" segundu.\n");
				 
				 if( hartuta > maximoa ){
					 
					 maximoa = hartuta;
				 }
				 
				 else if( hartuta < minimoa ){
					 
					 minimoa = hartuta;
				 }
				 
				 akumula = akumula + hartuta;	 
			 }
			 
			 else{
				 
				 System.out.println("\nElementu berbera ez da sartuko konektatuta metodoan.\n");
			 }
			 
		 }
		 
		 batazbe = akumula/probak;
		 System.out.println("\nBatezbesteko denbora: "+batazbe+" segundu.\n");
		 System.out.println("\nDenbora maximoa: "+maximoa+" segundu.\n");
		 System.out.println("\nDenbora minimoa: "+minimoa+" segundu.\n");
			
		 
		 gHau.erreseteatuFrogetan();
		

	}
		 
		 
		 
		 
		 
		 
	@Test
	
	public void testErlazionatutaExperimentala(){

		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak): ERLAZIONATUTA*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		//Grafoa sortzen eta nodo kopurua zehazten
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 
		 //Elememtuen Arraya sortzen auzazko zenbakiekien lan egin ahal izateko
		 Zinematografikoa[] grafokoElemGuztiak = gHau.elementuenArrayaLortu();
		 
		 Random ausazkoak = new Random();
		 
		 //Behin eta berriro elementuak sartzeko erabiliko diren erakusleak
		 Zinematografikoa zine1  = null;
		 Zinematografikoa zine2  = null;
		 int 			  a		 = 0;
		 int			  b		 = 0;
		 int			  probak = 5;
		 
		 //Batez-besteko denbora, maximoa eta minimoa
		 double hartuta = 0.00;
		 double minimoa = 0.00;
		 double maximoa = 0.00;
		 double akumula = 0.00;
		 double batazbe = 0.00;
		 
		 ArrayList<Zinematografikoa> erantz = null;
		 
		 for (int i = 0; i < probak; i++){
			 
			 //Auzazko zenbakiak hartzen
			 a = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
			 b = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
		
			 //Ausazko elementuak hartzen grafotik
			 zine1 = grafokoElemGuztiak[a];
			 zine2 = grafokoElemGuztiak[b];
			 
			 if( !zine1.equals(zine2) ){ //Aurrebaldintza: ez da elementu berbera sartuko metodoan
			 
				 //konektatuta metodoaren exekuzio denbora aztertzen
				 Stopwatch kronometroa = new Stopwatch();
				 System.out.println("\n"+i +". Erlazionatuta froga empirikoa: "+zine1.getIzena()+"-en eta "+zine2.getIzena()+
						 "-en arteko erlazioa:  ");
				 erantz = gHau.erlazionatuta(zine1, zine2);
				 hartuta = kronometroa.elapsedTime();
				 //System.out.println(erantz);
				 
				 //Zerrenda inprimatzen
				 Iterator<Zinematografikoa> itr = erantz.iterator();
				 System.out.print("Zerrenda: ");
				 
				 while (itr.hasNext()){
					 
					 System.out.print("<"+itr.next().getIzena()+">; ");
				 }
				 
				 System.out.println("\n\nTardatutako denbora: "+hartuta+" segundu.\n");
				 
				 if( hartuta > maximoa ){
					 
					 maximoa = hartuta;
				 }
				 
				 else if( hartuta < minimoa ){
					 
					 minimoa = hartuta;
				 }
				 
				 akumula = akumula + hartuta;	 
			 }
			 
			 else{
				 
				 System.out.println("\nElementu berbera ez da sartuko konektatuta metodoan.\n");
			 }
			 
		 }
		 
		 batazbe = akumula/probak;
		 System.out.println("\nBatezbesteko denbora: "+batazbe+" segundu.\n");
		 System.out.println("\nDenbora maximoa: "+maximoa+" segundu.\n");
		 System.out.println("\nDenbora minimoa: "+minimoa+" segundu.\n");
				
			 
			 gHau.erreseteatuFrogetan();
	
	}
	
	
	/****************************************batazBestekorako*********************************************/	
		
	
	@Test
		
		public void testBatazBestekoaPelikulak(){
			
			
			gHau = GraphHash.getNireGrafoa();
			AktoreGuztiak aktoreHau = AktoreGuztiak.getNireAktoreak();
			 
			 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak)*******\n");
			 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
			 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
			 cHau.fitxategiaIrakurri();
			 cHau.fitxategiaItxi();
			 
			 //Irakurritako aktore eta pelikula kopuruak adierazten
			 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
			 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
			 
			 
			 
			 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
			 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
			 System.out.println("\nGrafoaren Aktoreen pelikuleen bataz bestekoa: " + aktoreHau.batazbestekoPelikulak()+"\n\n\n\n");
			 //gHau.grafoaInprimatu();
			 
			 gHau.erreseteatuFrogetan();
		}
	
	
	
	
	
	
	

}