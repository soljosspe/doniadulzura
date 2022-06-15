package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Producto;
import com.josspepf.doniadulzura.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")


public class ProductoMainController {

    @Autowired
    private ProductoRepository productoRepository ;

    @GetMapping(path = "/producto/all")
    public @ResponseBody
    Iterable<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @GetMapping(path = "/producto/{id_producto}")
    public @ResponseBody
    Optional<Producto> getProductoById(@PathVariable("id_producto") int id_pdt) {
        return productoRepository.findById(id_pdt);
    }

    @PostMapping(path = "/producto/create",
            consumes = "application/json", produces = "application/json")
    public Producto createProducto(@RequestBody Producto newProducto) {
        return productoRepository.save(newProducto);
    }

    @PutMapping(path = "/producto/update",
            consumes = "application/json", produces = "application/json")
    public Producto updateProducto(@RequestBody Producto updateProducto) {
        return productoRepository.save(updateProducto);
    }

    @DeleteMapping(path = "/producto/delete/{id_producto}")
    public @ResponseBody
    Iterable<Producto> deleteProductoById(@PathVariable("id_producto") int id_pdt) {
        try {
            productoRepository.deleteById(id_pdt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return productoRepository.findAll();
        }

    }

    //consultas

    @GetMapping(path = "/producto/name/{producto}")
    public @ResponseBody
    Collection<Producto> getProductoByName(@PathVariable("producto") String name) {
        return productoRepository.getProductoByName(name);
    }
}
