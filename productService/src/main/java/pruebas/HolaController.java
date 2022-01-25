package pruebas;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
	
	private static final String plantilla = "Hola, %s!";
	private final AtomicLong contador = new AtomicLong();
	
	
	@GetMapping("/hola")
	public Hola saludo (@RequestParam(value ="extension", defaultValue="Mundo" ) String extension ) {
		
		return new Hola(contador.incrementAndGet(), String.format(plantilla, extension));
		
	}

}
