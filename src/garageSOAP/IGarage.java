package garageSOAP;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGarage extends Remote{
	
	public IVehicule[] getVehiculeDispo() throws RemoteException;
	public boolean reserveVehicule(IVehicule vehicule) throws RemoteException;
	public void addVehicule(IVehicule vehicule) throws RemoteException;
}
