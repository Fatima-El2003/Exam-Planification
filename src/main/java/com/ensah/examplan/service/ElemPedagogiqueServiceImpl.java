package com.ensah.examplan.service;

import com.ensah.examplan.model.ElementPedagogique;
import com.ensah.examplan.repository.ElemPedagogiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElemPedagogiqueServiceImpl implements   ElemPedagogiqueService{
    @Autowired
    ElemPedagogiqueRepository elemPedagogiqueRepository;

    @Override
    public ElementPedagogique addElemPedagogique(ElementPedagogique elementPedagogique) {
        return elemPedagogiqueRepository.save(elementPedagogique);
    }

    @Override
    public ElementPedagogique getElemPedagogiqueById(Long id) {
        return elemPedagogiqueRepository.findById(id).get();
    }

    @Override
    public List<ElementPedagogique> getAllElemPedagogique() {
        return elemPedagogiqueRepository.findAll();
    }

    @Override
    public ElementPedagogique updateElemPedagogique(Long id, ElementPedagogique elementPedagogique) {
        ElementPedagogique elementPedagogique1=getElemPedagogiqueById(id);
        elementPedagogique1.setNiveau(elementPedagogique.getNiveau());
        elementPedagogique1.setType(elementPedagogique.getType());
        elementPedagogique1.setTitre(elementPedagogique.getTitre());
        return elemPedagogiqueRepository.save(elementPedagogique1);
    }

    @Override
    public void deleteElemPedagogique(Long id) {
        elemPedagogiqueRepository.delete(elemPedagogiqueRepository.findById(id).get());
    }
}
