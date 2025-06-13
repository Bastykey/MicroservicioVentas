package cl.duoc.MicroservicioVenta.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.stereotype.Service;

import cl.duoc.MicroservicioVenta.Model.Venta;
import cl.duoc.MicroservicioVenta.Repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    private final WebClientSsl webClient;
    private final VentaRepository ventarepository;

    public VentaService(WebClientSsl webClient, VentaRepository ventarepository) {
        this.webClient = webClient;
        this.ventarepository = ventarepository;
    }

    public List<Venta> BuscarTodaVenta(){
        return ventarepository.findAll();
    }

    public Venta BuscarVenta(Venta nuevaventa){
        return ventarepository.findById(nuevaventa).get();
    }

    public Venta GuardarVenta(Venta venta){
        return ventarepository.save(venta);
    }

    public void EliminarVenta(Long idventa){
        ventarepository.deleteById(idventa);
    }


    public List<Venta> BuscarPorFecha(LocalDate fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarPorFecha'");
    }

    public Venta BuscarVenta(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuscarVenta'");
    }


}
