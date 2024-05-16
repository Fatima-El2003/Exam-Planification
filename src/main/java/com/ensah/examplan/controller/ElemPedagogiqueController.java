package com.ensah.examplan.controller;

import com.ensah.examplan.model.ElementPedagogique;
import com.ensah.examplan.model.Personnel;
import com.ensah.examplan.service.ElemPedagogiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elements")
public class ElemPedagogiqueController {
    @Autowired
    ElemPedagogiqueService elemPedagogiqueService;
    @PostMapping
    public ResponseEntity<ElementPedagogique> addElemPedagogique(@RequestBody ElementPedagogique elementPedagogique){
        return   ResponseEntity.ok(elemPedagogiqueService.addElemPedagogique(elementPedagogique));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ElementPedagogique> getElemPedagogiqueById(@PathVariable("id") Long id){
        return  ResponseEntity.ok( elemPedagogiqueService.getElemPedagogiqueById(id));
    }
    @GetMapping
    public ResponseEntity<List<ElementPedagogique>> getAllElemPedagogique(){
        return   ResponseEntity.ok(elemPedagogiqueService.getAllElemPedagogique());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ElementPedagogique> updateElemPedagogique(@PathVariable("id") Long id,@RequestBody ElementPedagogique elementPedagogique){

      return  ResponseEntity.ok(elemPedagogiqueService.updateElemPedagogique(id,elementPedagogique));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElemPedagogique(@PathVariable("id") Long id  ){

          elemPedagogiqueService.deleteElemPedagogique(id);
          return ResponseEntity.ok("ElementPedagogique deleted successfully");
    }
}
