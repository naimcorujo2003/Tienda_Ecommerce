package com.naimcorujo.venta.repository;

import com.naimcorujo.venta.dto.VentaDTO;
import com.naimcorujo.venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository  extends JpaRepository <Venta, Long> {
}
