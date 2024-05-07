package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cliente")
public class ProveedorController {
    //Inyectar el servicio
    @Autowired
    private IProveedorService service;

    @GetMapping("/all")
    public List<Proveedor> findAll() {
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Proveedor> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public Proveedor save(@RequestBody Proveedor proveedor) {
        return service.save(proveedor);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody Proveedor proveedor, @PathVariable String id) {
        service.update(proveedor, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
