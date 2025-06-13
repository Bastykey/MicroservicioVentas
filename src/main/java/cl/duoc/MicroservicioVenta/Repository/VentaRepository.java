package cl.duoc.MicroservicioVenta.Repository;

import cl.duoc.MicroservicioVenta.Model.Venta;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByFecha(LocalDate fecha);

    Optional<Venta> findById(Venta nuevaventa);

    Object findAll(Venta nuevaventa);
}