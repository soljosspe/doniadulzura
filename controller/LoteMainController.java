package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Lote;
import com.josspepf.doniadulzura.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class LoteMainController {

    @Autowired
    private LoteRepository loteRepository;

    @GetMapping(path = "/lote/all")
    public @ResponseBody
    Iterable<Lote> getAllLote() {
        return loteRepository.findAll();
    }

    @GetMapping(path = "/lote/{id_lote}")
    public @ResponseBody
    Optional<Lote> getLoteById(@PathVariable("id_lote") int id_l) {
        return loteRepository.findById(id_l);
    }

    @PostMapping(path = "/lote/create",
            consumes = "application/json", produces = "application/json")
    public Lote createLote(@RequestBody Lote newLote) {
        return loteRepository.save(newLote);
    }

    @PutMapping(path = "/lote/update",
            consumes = "application/json", produces = "application/json")
    public Lote updateLote(@RequestBody Lote updateLote) {
        return loteRepository.save(updateLote);
    }

    @DeleteMapping(path = "/lote/delete/{id_lote}")
    public @ResponseBody
    Iterable<Lote> deleteLoteById(@PathVariable("id_lote") int id_l) {
        try {
            loteRepository.deleteById(id_l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return loteRepository.findAll();
        }

    }
}
