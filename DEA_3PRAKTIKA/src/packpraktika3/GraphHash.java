package packpraktika3;
import packpraktika1.*;
import packpraktika2.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import java.util.Iterator;
import java.util.HashSet;


public class GraphHash {
	
	private HashMap<Zinematografikoa, ArrayList<Zinematografikoa>> grafoa;
	private static GraphHash nireGrafoa;
	
	private GraphHash(){
		
		this.grafoa = new HashMap<Zinematografikoa, ArrayList<Zinematografikoa>>(); 
	}
	
	
	public static synchronized GraphHash getNireGrafoa(){
		
		if (GraphHash.nireGrafoa == null){
			
			GraphHash.nireGrafoa = new GraphHash();
		}
		
		return GraphHash.nireGrafoa;
	}

	public void grafoaSortu(AktoreGuztiak lAktoreak, PelikulaGuztiak lPelikulak){
	//Aurre-baldintza:	---
	/*Post-baldinta:	aktoreen zerrendatik grafoa sortzen du adabegiak aktoreen 
	   		izenak eta pelikulen izenburuak dira */
	//Kostua: O(n+m)
		
		/*Proba kasuak:
		 
		 	1. Aktorerik eta pelikularik ez.
		 	2. Aktoreen zerrenda beteta, pelikulena ez.
		 	4. Aktore bakarra eta Pelikula bakarra.
		 	3. Aktoreen zerrenda eta pelikulen zerrenda beteta.
		 */
		
		
		lAktoreak.grafoaOsatu();
		lPelikulak.grafoaOsatu();
	}
	
	public void gehitu(Zinematografikoa pGiltza, ArrayList<Zinematografikoa> pZerrenda){
		
		this.grafoa.put(pGiltza, pZerrenda);
			
	}
	
	public boolean konektatuta(Zinematografikoa pZine1, Zinematografikoa pZine2){
		
		//Aurre-baldintza:	Aktore edo Pelikula motako instantzia izango dute parametroak, eta desberdinak izango dira.
		/*Post-baldinta:	Beraien artean tarteko pelikula eta aktoreak badaude True bueltatuko du,
							bestela False.
		//Kostua: O(n+m)
			
			/*Proba kasuak:
			 
			 	1. Horietako batek konexiorik ez izatea: Pelikula bat aktorerik gabe edo
			 	   txertatu den aktore berria pelikularik ez izatea. (False)
			 	2. Bi elementuek konexiorik ez izatea. (False)
			 	3. Bi elementuek konexioak izatea, baina elkarren artean konexiorik ez
			 	   egotea (False)
			 	4. Elementuen artean konexio bakarra (izen berdineko pelikula eta aktorea) (True)
			 	5. Elementuen artean konexio bakarra (izen ezberdinekoak) (True)
			 	6. Elementuen artean bi baino gehiagoko konexioa (izen berdineko pelikula eta aktorea) (True).
			 	7. Elementuen artean bi baino gehiagoko konexioa (izen ezberdinekoak) (True).
			 */
		
		Zinematografikoa hasierakoa = pZine1;
	    Zinematografikoa amaierakoa = pZine2;
	    Zinematografikoa unekoa 	= hasierakoa;
	    
	    
	    //Stack<Zinematografikoa>		aztertuGabeak		=	new Stack<Zinematografikoa>();
	    Queue<Zinematografikoa>		aztertuGabeak		=	new LinkedList<Zinematografikoa>();
	    HashSet<Zinematografikoa>	aztertuak			=	new HashSet<Zinematografikoa>();
	    
	    aztertuak.add(unekoa);
	    aztertuGabeak.add(unekoa);
	    
	    boolean topatua		   = false;
	    boolean instantziaBera = false; //Biak pelikulak edo biak aktoreak diren jakiteko
	    
	    while (!topatua && !aztertuGabeak.isEmpty()){
	    	
	    	unekoa = aztertuGabeak.remove();
	    	
	    	instantziaBera = unekoa.instantziaBerekoak(amaierakoa); //Izen berdina duten pelikula eta aktorea ekiditzeko.
	    	
	    	if( unekoa.getIzena().equals(amaierakoa.getIzena()) && instantziaBera ){
	    		
	    		topatua	= true;
	    	}
	    	
	    	else{
	    		
	    		/*prozesatu( Zinematografikoa pProzesatzekoa, Stack<Zinematografikoa> pAztertuGabeak, 
		 				Queue<Zinematografikoa> pAztertuak){*/
	    		
	    		Iterator<Zinematografikoa>	itr	=	this.grafoa.get(unekoa).iterator(); /*Unekoaren arrayList-aren 
	    																					iteradorea lortu da*/
	    		Zinematografikoa unekoarenZerrendakoa = null;
	    		
	    		while(itr.hasNext()){
	    			
	    			unekoarenZerrendakoa	= itr.next();
	    			this.prozesatu(unekoarenZerrendakoa, aztertuGabeak, aztertuak);
	    		}
	    	}

	    }
	    
		return topatua;
	}
	
	 private void prozesatu( Zinematografikoa pProzesatzekoa, Queue<Zinematografikoa>	 pAztertuGabeak, 
				HashSet<Zinematografikoa> pAztertuak){


		if( !pAztertuak.contains(pProzesatzekoa) ){
		
		pAztertuGabeak.add(pProzesatzekoa);
		pAztertuak.add(pProzesatzekoa);
		
		}


	 }
	
	
	
	///********************************************FROGAK***********************************///
	 
	public void erreseteatuFrogetan(){ //Frogak egiterakoan grafoa erreseteatu ahal izateko.
		
		nireGrafoa = null;
	}
	public static void main(String[] args){
		
		 IrakurketakEtaIdazketak cHau = new IrakurketakEtaIdazketak(); //Klase honetako metodoei deia egiteko: claseHau
		 GraphHash				 gHau = GraphHash.getNireGrafoa();
		// Scanner sarrera	= new Scanner(System.in);
		// boolean jarraitu	= true;

		 int aukera;
	//	 "Fitxategiak/Murriztuta.txt";
		 System.out.println("\t\t\t*******FILMAK ETA AKTOREAK - PRAKTIKA 1*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Murriztuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
	}
	
	
	

}