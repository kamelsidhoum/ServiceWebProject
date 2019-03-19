package garageSOAP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Garage extends UnicastRemoteObject implements IGarage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IVehicule> listVehicule;
	
	protected Garage() throws RemoteException {
		super();
		
		listVehicule = new ArrayList<IVehicule>();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public IVehicule[] getVehiculeDispo() throws RemoteException {
		// TODO Auto-generated method stub
		
		List<IVehicule> listVehiculeDispo = new ArrayList<IVehicule>();
		for(IVehicule vehicule : listVehicule) {
			if(vehicule.isDispo())
				listVehiculeDispo.add(vehicule);
		}
		
		IVehicule[] vehiculeDispoTab = new Vehicule[listVehiculeDispo.size()];
		
		int cpt = 0;
		for(IVehicule vehicule : listVehiculeDispo) {
			vehiculeDispoTab[cpt] = vehicule;
			cpt++;
		}
		return vehiculeDispoTab;
	}

	@Override
	public boolean reserveVehicule(IVehicule vehicule) throws RemoteException {
		// TODO Auto-generated method stub
		if(listVehicule.contains(vehicule) && vehicule.isDispo()) {
			vehicule.reserve();
			return true;
		}
		return false;
	}

	@Override
	public void addVehicule(IVehicule vehicule) throws RemoteException {
		// TODO Auto-generated method stub
		listVehicule.add(vehicule);
	}

}
