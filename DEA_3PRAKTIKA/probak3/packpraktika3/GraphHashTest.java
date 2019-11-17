package packpraktika3;

import packpraktika1.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class GraphHashTest {

	Zinematografikoa aktore1, aktore2, peli1, peli2 = null;	
	GraphHash gHau;
	IrakurketakEtaIdazketak cHau;

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
		 
		
		//5. Elementuen artean bi baino gehiagoko konexioa (izen berdineko pelikula eta aktorea) (True).
			
		 
		 
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
		 
		 
		/* 9. Bi elementuen artean erlazio bat baino gehiago egotea.
		 	10. Null elementuak sartzerakoan*/
		 
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

}
