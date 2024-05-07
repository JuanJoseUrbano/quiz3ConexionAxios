package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IRepository.IProveedorRepository;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository repository;

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public String update(Proveedor proveedor, String id) {
        Optional<Proveedor> proveedorOptional = repository.findById(id);

        //Cargar nuevo objeto
        if (!proveedorOptional.isEmpty()) {
            Proveedor proveedorUpdate = new Proveedor();
            proveedorUpdate.setId(id);
            proveedorUpdate.setNombre(proveedor.getNombre());
            proveedorUpdate.setDireccion(proveedor.getDireccion());
            //Actualizar el objeto cliente
            repository.save(proveedorUpdate);
            return "Proveedor actualizado con exito";
        }
        return "Proveedor no encontrado por ese id";
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
