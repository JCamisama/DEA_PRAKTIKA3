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
		 	3. Aktoreen zerrenda hutsa, pelikulena beteta.
		 	4. Aktore bakarra eta Pelikula bakarra.
		 	5. Aktoreen zerrenda eta pelikulen zerrenda beteta.
		 */
		System.out.println("\nGrafoa sortuko da orain");
		Stopwatch kronometroa = new Stopwatch();
		lAktoreak.grafoaOsatu();
		lPelikulak.grafoaOsatu();
		System.out.println("\nTardatutako denbora: "+kronometroa.elapsedTime()+" segundu.");
	}
	
	public void gehitu(Zinematografikoa pGiltza, ArrayList<Zinematografikoa> pZerrenda){
		
		this.grafoa.put(pGiltza, pZerrenda);
			
	}
	
	public boolean konektatuta(Zinematografikoa pZine1, Zinematografikoa pZine2){
		
		/*Aurre-baldintza:	Aktore edo Pelikula motako instantzia izango dute parametroak, eta desberdinak izango dira.
							Bi elementuak grafoan egongo dira. */
		/*Post-baldinta:	Beraien artean tarteko pelikula eta aktoreak badaude True bueltatuko du,
							bestela False. Parametroren bat null bada, false bueltatuko du.*/
		//Kostua: TO-DO
			
			/*Proba kasuak:
			 
			 	1.  Elementuak konexiorik ez izatea (fitxategiaren karga eta gero gehitzen direnean) (False)
			 	2.  Pelikula aktoreak ditu, baina aktorea ez dauka erlaziorik (False)
			 	3.  Pelikula aktorerik ez izatea (karga eta gero gehitzen bada), baina aktoreak bai (False)
			 	4.  Elementuak erlazioak dituzte, baina ez bien artean (False)
			 	5.  Erlazio zuzena (aktorea pelikulan lan egin duenean (True)
			 	6.  Aktoreen arteko erlazioa (pelikula berean lan egin dute) (True)
			 	7.  Izen berdineko aktore eta pelikula baten artean erlazioa egotea (True)
			 	8.  Izen ezberdineko bi elementuen artean erlazioa egotea (True)
			 	9.  Bi elementuen artean erlazio bat baino gehiago egotea.
			 	10. Null elementuak sartzerakoan
			 */
		
		boolean topatua		   = false;
		
		if((pZine1 != null)&&(pZine2 != null)){
			
			
			Zinematografikoa hasierakoa = pZine1;
		    Zinematografikoa amaierakoa = pZine2;
		    Zinematografikoa unekoa 	= hasierakoa;
		    
		    
		    //Stack<Zinematografikoa>		aztertuGabeak		=	new Stack<Zinematografikoa>();
		    Queue<Zinematografikoa>		aztertuGabeak		=	new LinkedList<Zinematografikoa>();
		    HashSet<Zinematografikoa>	aztertuak			=	new HashSet<Zinematografikoa>();
		    
		    aztertuak.add(unekoa);
		    aztertuGabeak.add(unekoa);
		    
		    
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
		    			this.prozesatuKonektatuta(unekoarenZerrendakoa, aztertuGabeak, aztertuak);
		    		}
		    	}
	
		    }
		}
		
		return topatua;
	}
	
	 private void prozesatuKonektatuta( Zinematografikoa pProzesatzekoa, Queue<Zinematografikoa>	 pAztertuGabeak, 
				HashSet<Zinematografikoa> pAztertuak){


		if( !pAztertuak.contains(pProzesatzekoa) ){
		
		pAztertuGabeak.add(pProzesatzekoa);
		pAztertuak.add(pProzesatzekoa);
		
		}


	 }
	
	
	 public ArrayList<Zinematografikoa> erlazionatuta(Zinematografikoa pZine1, Zinematografikoa pZine2){
		 
		
		 
		/*Aurre-baldintza:	Aktore edo Pelikula motako instantzia izango dute parametroak, eta desberdinak izango dira.
		 					Bi elementuak grafoan egongo dira. */
		/*Post-baldinta:	pZine1-etik pZine2-rainoko erlazioen zerrenda izango da, 2 pertsonen arteko erlazio
							bakoitzak pelikula berean parte hartu dutela adierazten duelarik. 
							Elementuen artean konexiorik ez badago, zerrenda hutsa bueltatuko du.
							Null elementuren bat sartzen bada, null bueltatuko du.*/
		//Kostua: TO-DO
			
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
			 	12. Null elementuak sartzerakoan.   (null)
			*/
		ArrayList<Zinematografikoa> bidea = null; 
		
		if((pZine1 != null)&&(pZine2 != null)){
			
			bidea = new ArrayList<Zinematografikoa>();
			
			Zinematografikoa hasierakoa = pZine1;
		    Zinematografikoa amaierakoa = pZine2;
		    Zinematografikoa unekoa 	= hasierakoa;
		  
		    Queue<Zinematografikoa>		aztertuGabeak		=	new LinkedList<Zinematografikoa>();
		    
		    HashMap<Zinematografikoa, Zinematografikoa>	aztertuak			
		    												=	new HashMap<Zinematografikoa, Zinematografikoa>();//elementua, nondik
		    
		    aztertuak.put(unekoa, null); 
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
		    			this.prozesatuErlazionatuta(unekoa, unekoarenZerrendakoa, aztertuGabeak, aztertuak);
		    		}
		    	}
	
		    }
		    
		    if (topatua){
		    	
		    	//Emaitza zerrenda formatuan ordenatzen
		    	Stack<Zinematografikoa> bideaOrdenatzen = new Stack<Zinematografikoa>();
		    	bideaOrdenatzen.push(amaierakoa); //Pilaren goikaldean ipiniko da.
		    	
		    	Zinematografikoa nondik = amaierakoa;
		    	Zinematografikoa nondikHurrengoa = aztertuak.get(nondik);
		    	while(nondikHurrengoa != null){
		    		
		    		nondik = nondikHurrengoa;//Objektura nondik etorri den 
		    		bideaOrdenatzen.add(nondik);
		    		//Aztertu eta gehituko den hurrengo balioa zehazten
		    		nondikHurrengoa = aztertuak.get(nondik);
		    	}

		    	//Emaitza prestatzen ArrayList moduan
		    	while( !bideaOrdenatzen.isEmpty() ){
		    		
		    		unekoa = bideaOrdenatzen.pop();
		    		bidea.add(unekoa);
		    	}
		    	
		    }
		}
		 
		 
		 return bidea;
	 }
	 
	 private void prozesatuErlazionatuta( Zinematografikoa pUnekoa, Zinematografikoa pProzesatzekoa, 
			 							  Queue<Zinematografikoa>	 pAztertuGabeak, 
			 							  HashMap<Zinematografikoa, Zinematografikoa> pAztertuak){


		if( !pAztertuak.containsKey(pProzesatzekoa) ){
		
			pAztertuGabeak.add(pProzesatzekoa);
			pAztertuak.put(pProzesatzekoa, pUnekoa);
		
		}


	 }
	
	///********************************************FROGAK***********************************///
	 
	public void erreseteatuFrogetan(){ //Frogak egiterakoan grafoa erreseteatu ahal izateko.
		
		nireGrafoa = null;
	}
	
	public int size(){ //Frogak egiterakoan grafoaren elementu kopurua zein den jakiteko.
		
		return this.grafoa.size();
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
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n");
		 gHau.grafoaInprimatu();
	}
	
	
	public void grafoaInprimatu(){
		
		int i = 1;
		for (Zinematografikoa s: this.grafoa.keySet()){
			System.out.print("Elementua: " + i++ + " " + s.getIzena() + " --> ");
			for (Zinematografikoa k : this.grafoa.get(s)){
				System.out.print(k.getIzena() + " ### ");
			} 
			System.out.println();
		}
	}
	
	
	public Zinematografikoa[] elementuenArrayaLortu(){ //probak egoteko metodoa
		
		Zinematografikoa[] ausazkorako = (Zinematografikoa[]) this.grafoa.keySet().toArray();
		
		return ausazkorako;
		
	}
	

}