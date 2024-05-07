package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Document.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {
    List<Proveedor> findAll(); // Devuelve una lista de clientes
    Optional<Proveedor> findById(String id); // Devuelve un cliente por su id
    Proveedor save(Proveedor proveedor); // Guarda un cliente
    String update(Proveedor proveedor, String id); // Actualiza un cliente
    void delete(String id); // Elimina un cliente
}
