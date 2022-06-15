package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.*;
import com.josspepf.doniadulzura.repository.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collection;
import java.util.Optional;

    @RestController
    @RequestMapping(path = "/doniadulzura/ada/v1")

    public class MarcaMainController {

        @Autowired
        private MarcaRepository marcaRepository;

        @GetMapping(path = "/marca/all")
        public @ResponseBody
        Iterable<Marca> getAllMarca() {
            return marcaRepository.findAll();
        }

        @GetMapping(path = "/marca/{id_marca}")
        public @ResponseBody
        Optional<Marca> getMarcaById(@PathVariable("id_marca") int id_m) {
            return marcaRepository.findById(id_m);
        }

        @PostMapping(path = "/marca/create",
                consumes = "application/json", produces = "application/json")
        public Marca createMarca(@RequestBody Marca newMarca) {
            return marcaRepository.save(newMarca);
        }

        @PutMapping(path = "/marca/update",
                 consumes = "application/json", produces = "application/json")
        public Marca updateMarca(@RequestBody Marca updateMarca) {
            return marcaRepository.save(updateMarca);
        }

        @DeleteMapping(path = "/marca/delete/{id_marca}")
        public @ResponseBody
        Iterable<Marca> deleteMarcaById (@PathVariable("id_marca") int id_m) {
            try {
                marcaRepository.deleteById(id_m);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                return marcaRepository.findAll();
            }

        }


        // consultas

        @GetMapping(path = "/marca/name/{marca}")
        public @ResponseBody
        Collection<Marca> getMarcaByName(@PathVariable("marca") String name) {
            return marcaRepository.getMarcaByName(name);

        }

        @GetMapping(path = "/marca/name/param/{marca}")
        public @ResponseBody
        Collection<Marca> getMarcaByNameParametro(@PathVariable("marca") String name) {
            return marcaRepository.getMarcaByNameParametro(name);

        }
    }


