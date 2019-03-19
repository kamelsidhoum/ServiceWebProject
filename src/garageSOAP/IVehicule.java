package garageSOAP;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVehicule extends Remote{
	
	public boolean isDispo()throws RemoteException;
	public void reserve() throws RemoteException;
	public void dispo()throws RemoteException;
	public void setEtat() throws RemoteException;
	public void addAvis(String avis) throws RemoteException;
	public String getInfoVehicule() throws RemoteException;
}
