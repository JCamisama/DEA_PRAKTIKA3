package packpraktika3;

import packpraktika1.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import packpraktika1.AktoreGuztiak;
import packpraktika1.IrakurketakEtaIdazketak;
import packpraktika1.PelikulaGuztiak;

public class GraphHashTest {

	GraphHash gHau;
	IrakurketakEtaIdazketak cHau;

	@Before
	public void setUp() throws Exception {
		
		cHau		= new IrakurketakEtaIdazketak();
	}

	@After
	public void tearDown() throws Exception {
		
		gHau.erreseteatuFrogetan();
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

}
