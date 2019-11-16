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
		aktore1 = new Aktorea("Santa Clus");		
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
		 
	 	
	 	
	 	3. Elementuen artean konexio bakarra (izen berdineko pelikula eta aktorea) (True)
	 	4. Elementuen artean konexio bakarra (izen ezberdinekoak) (True)
	 	5. Elementuen artean bi baino gehiagoko konexioa (izen berdineko pelikula eta aktorea) (True).
	 	6. Elementuen artean bi baino gehiagoko konexioa (izen ezberdinekoak) (True).
	 */
		
		
		
		// 1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo
	 	//    txertatu den aktore berria pelikularik ez izatea. (False)
		
		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo\r\n" + 
		 		"	 	//    txertatu den aktore berria pelikularik ez izatea. (False)*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Konektatuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		
		 
		 	//Aktoreak aktoreen zerrenda nagusira gehitzen
		 AktoreGuztiak.getNireAktoreak().gehituAktorea((Aktorea)aktore1);
		 
		 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Mitologia do submundo");
		 Zinematografikoa peli3 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Einsatz in 4 W nden");
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Nicholson, Sean ");
		 
		 
		 	//Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 gHau.grafoaInprimatu();
		 
		 	//Pelikula erlaziorik ez eukitzea, baina aktoreak bai
		 assertFalse(gHau.konektatuta(peli2, aktore2));
		 
		 
		 	//Aktorea erlaziorik ez eukitzea, baina pelikulak bai
		 assertFalse(gHau.konektatuta(aktore1, peli3));	 		 
		 
		 
		 
		//2. Bi elementuek konexioak izatea, baina elkarren artean konexiorik ez egotea (False)
			
		
		 
		 System.out.println("\t\t\t*******1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo\r\n" + 
		 		"	 	//    txertatu den aktore berria pelikularik ez izatea. (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Einsatz in 4 W nden");
		 
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Bouffard");		 
		 
		 
		 	//Bi elementuen artean konexiorik ez egotea
		 assertFalse(gHau.konektatuta(peli2, aktore2));	 
		 
		 
		 
		 //3. Elementuen artean konexio bakarra (izen berdineko pelikula eta aktorea) (True)
			
		
		 
		 System.out.println("\t\t\t*******1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo\r\n" + 
		 		"	 	//    txertatu den aktore berria pelikularik ez izatea. (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Sergio Ramos");
		 
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos");		 
		 
		 
		 	//Bi elementuen artean konexiorik ez egotea
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 
		 
		 
		//4. Elementuen artean konexio bakarra (izen ezberdinekoak) (True)
			
		 
		 
		 System.out.println("\t\t\t*******1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo\r\n" + 
		 		"	 	//    txertatu den aktore berria pelikularik ez izatea. (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Universal Ninjas");
		 
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Jonpor");		 
		 
		 
		 	//Bi elementuen artean konexiorik ez egotea
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 
		 
		 
		//5. Elementuen artean bi baino gehiagoko konexioa (izen berdineko pelikula eta aktorea) (True).
			
		 
		 
		 System.out.println("\t\t\t*******1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo\r\n" + 
		 		"	 	//    txertatu den aktore berria pelikularik ez izatea. (False)*******\n");
			 
		 	//Bilatu nahi dugun pelikula bilatzen
		 peli2 =  PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Sergio Ramos1");
		 
		 
		 	//Bilatu nahi dugun aktorea bilatzen
		 aktore2 =  AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Sergio Ramos1");		 
		 
		 
		 	//Bi elementuen artean konexiorik ez egotea
		 assertTrue(gHau.konektatuta(peli2, aktore2));	 
		 
		 
		 
		
		
		
		
		
		
		
	}

}
