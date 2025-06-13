package cl.duoc.MicroservicioVenta.Service
;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cl.duoc.MicroservicioVenta.Model.Venta;
@SpringBootTest
public class TestBuscarVentaBD {

@Autowired
private VentaService ventaservice;

    @Test 
    public void testBuscarVenta(){
        Venta ventaBuscada = ventaservice.BuscarVenta(179);
        assertEquals("10026478-9", ventaBuscada.getRutusuario());
}

    
    @Test
    public void testRegistrarVenta(){
        Venta V= new Venta();
    V.setFechaventa(LocalDate.now());
    V.setRutusuario("99999999-9");
    Venta VentaRegistrada = ventaservice.GuardarVenta(V);
    assertEquals(240, VentaRegistrada.getId_venta());


}
 
}
