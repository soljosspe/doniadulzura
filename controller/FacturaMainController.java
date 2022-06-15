package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Factura;
import com.josspepf.doniadulzura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class FacturaMainController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping(path = "/factura/all")
    public @ResponseBody
    Iterable<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @GetMapping(path = "/factura/{id_factura}")
    public @ResponseBody
    Optional<Factura> getFacturaById(@PathVariable("id_factura") int id_f) {
        return facturaRepository.findById(id_f);
    }

    @PostMapping(path = "/factura/create",
            consumes = "application/json", produces = "application/json")
    public Factura createFactura(@RequestBody Factura newFactura) {
        return facturaRepository.save(newFactura);
    }

    @PutMapping(path = "/factura/update",
            consumes = "application/json", produces = "application/json")
    public Factura updateFactura(@RequestBody Factura updateFactura) {
        return facturaRepository.save(updateFactura);
    }

    @DeleteMapping(path = "/factura/delete/{id_factura}")
    public @ResponseBody
    Iterable<Factura> deleteFacturaById(@PathVariable("id_factura") int id_f) {
        try {
            facturaRepository.deleteById(id_f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return facturaRepository.findAll();
        }

    }
}
