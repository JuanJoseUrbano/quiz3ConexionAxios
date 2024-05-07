package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Producto;
import com.corhuila.shoppingcar.IRepository.IProductoRepository;
import com.corhuila.shoppingcar.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public String update(Producto producto, String id) {
        Optional<Producto> ps = repository.findById(id);
        if (!ps.isEmpty()) {
            Producto productoUpdate = new Producto();
            productoUpdate.setId(id);
            productoUpdate.setCodigo(producto.getCodigo());
            productoUpdate.setNombre(producto.getNombre());
            productoUpdate.setPrecio(producto.getPrecio());
            productoUpdate.setStock(producto.getStock());
            productoUpdate.setMarca(producto.getMarca());
            productoUpdate.setDeleteAt(null);
            productoUpdate.setStatus(true);
            //Actualizar el objeto producto
            repository.save(productoUpdate);
            return "Producto actualizado con exito";
        }
        return "Producto no encontrado por ese id";
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public String deleteLogic(String id) {
        Optional<Producto> productoBuscado = repository.findById(id);
        if (productoBuscado.isPresent()) {
            Producto productoEliminado = new Producto(id, productoBuscado.get().getCodigo(),
                    productoBuscado.get().getNombre(), productoBuscado.get().getPrecio(),
                    productoBuscado.get().getStock(), productoBuscado.get().getMarca(), LocalDateTime.now(), false);
            repository.save(productoEliminado);
            return "Eliminado con exito";
        }
        return "Producto no encontrado";
    }
}
