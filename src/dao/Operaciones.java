package dao;

import dto.DtoLibros;

import java.rmi.Remote;


public interface Operaciones extends Remote {
   int eliminarLibro(DtoLibros DTOLibros) throws Exception;
}
