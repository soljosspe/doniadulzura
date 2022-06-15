package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Venta;
import com.josspepf.doniadulzura.models.reportes.ReporteMes;
import com.josspepf.doniadulzura.models.reportes.ReporteProducto;
import com.josspepf.doniadulzura.repository.StockRepository;
import com.josspepf.doniadulzura.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class VentasMainController {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private StockRepository stockRepository;

    @GetMapping(path = "/ventas/all")
    public @ResponseBody
    Iterable<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @GetMapping(path = "/ventas/{id_ventas}")
    public @ResponseBody
    Optional<Venta> getVentasById(@PathVariable("id_ventas") int id_v) {
        return ventaRepository.findById(id_v);
    }

    @PostMapping(path = "/ventas/create",
            consumes = "application/json", produces = "application/json")
    public Venta createVenta(@RequestBody Venta newVenta) {
        return ventaRepository.save(newVenta);
    }

    @PutMapping(path = "/ventas/update",
            consumes = "application/json", produces = "application/json")
    public Venta updateVentas(@RequestBody Venta updateVentas) {
        return ventaRepository.save(updateVentas);
    }

    @DeleteMapping(path = "/ventas/delete/{id_ventas}")
    public @ResponseBody
    Iterable<Venta> deleteVentasById(@PathVariable("id_ventas") int id_v) {
        try {
            ventaRepository.deleteById(id_v);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return ventaRepository.findAll();
        }

    }


    // CONSULTAS

    // mes con mas venta

    @GetMapping(path = "/venta/mes")
    public @ResponseBody
    Iterable<ReporteMes> getMesDeVentas() {
        return ventaRepository.getMesDeVentas();
    }

    //producto mas vendido

    @GetMapping(path = "/venta/producto")
    public @ResponseBody
    Iterable<ReporteProducto> getProductoMasVendido() {
        return ventaRepository.getProductoMasVendido();
    }



}
