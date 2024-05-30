package com.ensah.examplan.service;

import com.ensah.examplan.model.ElementPedagogique;

import java.util.List;

public interface ElemPedagogiqueService {
    ElementPedagogique addElemPedagogique(ElementPedagogique elementPedagogique);

    ElementPedagogique getElemPedagogiqueById(Long id);

    List<ElementPedagogique> getAllElemPedagogique();

    ElementPedagogique updateElemPedagogique(Long id, ElementPedagogique elementPedagogique);

    void deleteElemPedagogique(Long id);
}
