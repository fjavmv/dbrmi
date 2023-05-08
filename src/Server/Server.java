package Server;

import dao.DaoConsultas;
import dao.Operaciones;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends DaoConsultas {
    public Server(){
       try{
           DaoConsultas daoConsultas = new DaoConsultas();
           //Exportando el objeto de la clase de implementación aquí estamos exportando el objeto remoto al stub
           Operaciones stub = (Operaciones) UnicastRemoteObject.exportObject(daoConsultas,8080);
           // Vincular el objeto remoto (stub) en el registro
           Registry registry = LocateRegistry.getRegistry();
           registry.bind("Eliminar",stub);
           System.out.println("Servidor listo");
       }catch (RemoteException | AlreadyBoundException ex){
           System.err.println("Error en el servidor: " + ex.toString());
           ex.printStackTrace();
       }
    }
}
