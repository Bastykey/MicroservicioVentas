package cl.duoc.MicroservicioVenta.Controller;


import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.MicroservicioVenta.Model.venta;
import cl.duoc.MicroservicioVenta.Service.ventaService;

@RestController
@RequestMapping("/api/v1/ventas")
public class ventaController {

    private ventaService ventaService = new ventaService();

    public void VentaController(ventaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public ResponseEntity<List<venta>> listar() {
        List<venta> ventas = ventaService.BuscarTodaVenta();
        return ventas.isEmpty() ? 
            ResponseEntity.noContent().build() : 
            ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarVenta(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("ID de venta inválido");
        }
        
        return null;
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody venta venta) {
        try {
            if (venta.getFechaventa() == null || venta.getFechaventa().isAfter(LocalDate.now())) {
                return ResponseEntity.badRequest().body("Fecha de venta inválida");
            }
            
            venta ventaNueva = ventaService.guardarVenta(venta);
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaNueva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error al guardar venta: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return null;
        
            
    }
    @GetMapping("/por-fecha")
     public ResponseEntity<?> buscarPorFecha(@RequestParam LocalDate fecha) {
        try {
            if (fecha == null || fecha.isAfter(LocalDate.now())) {
                return ResponseEntity.badRequest().body("Fecha inválida");
            }
            
            List<venta> ventas = (List<venta>) ventaService.BuscarFecha(fecha);
            return ventas.isEmpty() ? 
                ResponseEntity.noContent().build() : 
                ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Error al buscar por fecha");
        }
    }
}