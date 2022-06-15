package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Proveedor;
import com.josspepf.doniadulzura.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class ProveedorMainController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping(path = "/proveedor/all")
    public @ResponseBody
    Iterable<Proveedor> getAllProveedor() {
        return proveedorRepository.findAll();
    }

    @GetMapping(path = "/proveedor/{id_proveedor}")
    public @ResponseBody
    Optional<Proveedor> getProveedorById(@PathVariable("id_proveedor") int id_pvr) {
        return proveedorRepository.findById(id_pvr);
    }

    @PostMapping(path = "/proveedor/create",
            consumes = "application/json", produces = "application/json")
    public Proveedor createProveedor(@RequestBody Proveedor newProveedor) {
        return proveedorRepository.save(newProveedor);
    }

    @PutMapping(path = "/proveedor/update",
            consumes = "application/json", produces = "application/json")
    public Proveedor updateProveedor(@RequestBody Proveedor updateProveedor) {
        return proveedorRepository.save(updateProveedor);
    }

    @DeleteMapping(path = "/proveedor/delete/{id_proveedor}")
    public @ResponseBody
    Iterable<Proveedor> deleteProveedorById(@PathVariable("id_proveedor") int id_pvr) {
        try {
            proveedorRepository.deleteById(id_pvr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return proveedorRepository.findAll();

        }

    }

    // consulta

    @GetMapping(path = "/proveedor/name/{proveedor}")
    public @ResponseBody
    Collection<Proveedor> getProveedorByName(@PathVariable("proveedor") String name) {
        return proveedorRepository.getProveedorByName(name);
    }
}