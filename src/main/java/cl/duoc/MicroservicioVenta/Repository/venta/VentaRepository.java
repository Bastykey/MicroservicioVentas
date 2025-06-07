package cl.duoc.MicroservicioVenta.Repository.venta;

import cl.duoc.MicroservicioVenta.Model.venta;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<venta, Long> {
    List<venta> findByFecha(LocalDate fecha);
}