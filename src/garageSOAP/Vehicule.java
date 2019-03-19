package garageSOAP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Vehicule extends UnicastRemoteObject implements IVehicule{

	private static final long serialVersionUID = 1L;
	
	private final int id;
	private static int cpt = 0;
	private String infoVehicule;
	private boolean dispo;
	private List<String> avis;
	private boolean enEtatFonctionner;
	
	protected Vehicule(String info) throws RemoteException {
		super();
		id = cpt++;
		infoVehicule = info;
		dispo = true;
		avis = new ArrayList<String>();
		enEtatFonctionner = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDispo() throws RemoteException {
		// TODO Auto-generated method stub
		return dispo && enEtatFonctionner;
	}

	@Override
	public void reserve() throws RemoteException {
		// TODO Auto-generated method stub
		dispo = false;
	}

	@Override
	public void dispo() throws RemoteException {
		// TODO Auto-generated method stub
		dispo = true;
	}

	@Override
	public void setEtat() throws RemoteException {
		// TODO Auto-generated method stub
		if(enEtatFonctionner)
			enEtatFonctionner = false;
		else
			enEtatFonctionner = true;
	}

	@Override
	public void addAvis(String avis) throws RemoteException {
		// TODO Auto-generated method stub
		this.avis.add(avis);
	}

	@Override
	public String getInfoVehicule() throws RemoteException {
		// TODO Auto-generated method stub
		return infoVehicule;
	}
	
	public String string() {
		String disponible;
		if(dispo && enEtatFonctionner)
			disponible = "est disponible ";
		else
			disponible = "n'est pas disponible ";
		return "Vehicule d'id : " + id + " " + infoVehicule + " " + disponible;
	}
	
}
