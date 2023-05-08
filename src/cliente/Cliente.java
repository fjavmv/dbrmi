package cliente;

import dao.Operaciones;
import dto.DtoLibros;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public Cliente(){
        try{
            Registry registry = LocateRegistry.getRegistry(null);
            // Buscando el registro del objeto remoto
            Operaciones stubObjetoRemoto = (Operaciones) registry.lookup("Eliminar");
            // Llamar al método remoto usando el objeto obtenido
            int data = stubObjetoRemoto.eliminarLibro(new DtoLibros(15));
            System.out.println("Elemento eliminado: " + data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
