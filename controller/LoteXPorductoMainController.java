package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.LoteXProducto;
import com.josspepf.doniadulzura.repository.LoteXProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class LoteXPorductoMainController {

    @Autowired
    private LoteXProductoRepository loteXProductoRepository;

    @GetMapping(path = "/lotexproducto/all")
    public @ResponseBody
    Iterable<LoteXProducto> getAllLoteXProducto() {
        return loteXProductoRepository.findAll();
    }

    @GetMapping(path = "/lotexproducto/{id_lotexproducto}")
    public @ResponseBody
    Optional<LoteXProducto> getLoteXProductoById(@PathVariable("id_lotexproducto") int id_lotexpro) {
        return loteXProductoRepository.findById(id_lotexpro);
    }

    @PostMapping(path = "/lotexproducto/create",
            consumes = "application/json", produces = "application/json")
    public LoteXProducto createLoteXProducto(@RequestBody LoteXProducto newLoteXProducto) {
        return loteXProductoRepository.save(newLoteXProducto);
    }

    @PutMapping(path = "/lotexproducto/update",
            consumes = "application/json", produces = "application/json")
    public LoteXProducto updateLoteXProducto(@RequestBody LoteXProducto updateLoteXProducto) {
        return loteXProductoRepository.save(updateLoteXProducto);
    }

    @DeleteMapping(path = "/lotexproducto/delete/{id_lotexpro}")
    public @ResponseBody
    Iterable<LoteXProducto> deleteLoteXProductoById(@PathVariable("id_lotexpro") int id_lxp) {
        try {
            loteXProductoRepository.deleteById(id_lxp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return loteXProductoRepository.findAll();
        }

    }
}
