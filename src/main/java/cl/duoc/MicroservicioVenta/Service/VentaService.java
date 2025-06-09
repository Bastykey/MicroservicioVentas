package cl.duoc.MicroservicioVenta.Service;


import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.MicroservicioVenta.Model.venta;
import cl.duoc.MicroservicioVenta.Repository.venta.VentaRepository;

@Service
public class ventaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<venta> getVentas() {
        return ventaRepository.findAll();
    }

    public venta guardarVenta(venta venta) {
        return ventaRepository.save(venta);
    }

    public List<venta> BuscarTodaVenta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarTodaVenta'");
    }

    public venta BuscarFecha(LocalDate fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorFecha'");
    }

    public venta BuscarFecha(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarFecha'");
    }

}
