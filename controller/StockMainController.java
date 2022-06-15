package com.josspepf.doniadulzura.controller;

import com.josspepf.doniadulzura.models.Stock;
import com.josspepf.doniadulzura.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doniadulzura/ada/v1")

public class StockMainController {

    @Autowired
    private StockRepository stockRepository;


    @GetMapping(path = "/stock/all")
    public @ResponseBody
    Iterable<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @GetMapping(path = "/stock/{id_stock}")
    public @ResponseBody
    Optional<Stock> getStockById(@PathVariable("id_stock") int id_s) {
        return stockRepository.findById(id_s);
    }

    @PostMapping(path = "/stock/create",
            consumes = "application/json", produces = "application/json")
    public Stock createStock(@RequestBody Stock newStock) {
        return stockRepository.save(newStock);
    }

    @PutMapping(path = "/stock/update",
            consumes = "application/json", produces = "application/json")
    public Stock updateStock(@RequestBody Stock updateStock) {
        return stockRepository.save(updateStock);
    }

    @DeleteMapping(path = "/stock/delete/{id_stock}")
    public @ResponseBody
    Iterable<Stock> deleteStockById(@PathVariable("id_stock") int id_s) {
        try {
           stockRepository.deleteById(id_s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return stockRepository.findAll();
        }

    }
}
