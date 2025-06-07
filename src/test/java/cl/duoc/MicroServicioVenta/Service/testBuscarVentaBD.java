package cl.duoc.MicroServicioVenta.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cl.duoc.MicroservicioVenta.Model.venta;
import cl.duoc.MicroservicioVenta.Service.ventaService;
@SpringBootTest
public class testBuscarVentaBD {

@Autowired
private ventaService ventaservice;

    @Test 
    public void testBuscarVenta(){
        venta ventaBuscada = ventaservice.BuscarUnaVenta(179);
        assertEquals("10026478-9", ventaBuscada.getRutusuario());
}

    
    @Test
    public void testRegistrarVenta(){
        venta V= new venta();
    V.setFechaventa(LocalDate.now());
    V.setRutusuario("99999999-9");
    venta VentaRegistrada = ventaservice.GuardarVenta(V);
    assertEquals(240, VentaRegistrada.getFechaventa());


}
 
}