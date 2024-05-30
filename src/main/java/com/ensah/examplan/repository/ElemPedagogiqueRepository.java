package com.ensah.examplan.repository;

import com.ensah.examplan.model.ElementPedagogique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElemPedagogiqueRepository  extends JpaRepository<ElementPedagogique,Long> {
}
