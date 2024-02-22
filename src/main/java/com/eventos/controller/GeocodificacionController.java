package com.eventos.controller;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeocodificacionController {

    private final GeoApiContext geocodificacion;

    Logger logger = LoggerFactory.getLogger(GeocodificacionController.class);

    public GeocodificacionController() {
        String apiKey = "AIzaSyA8Sq2SjrHdfY84uakxZtJCgs9WTMt3JsY";
        this.geocodificacion = new GeoApiContext.Builder().apiKey(apiKey).build();
    }

    @Operation(summary = "Servicio de Geocodificación Inversa")
    @GetMapping("/geocodificacion")
    public String getEventDetails(@RequestParam String direccion, @RequestParam int rango) {
        try {

            long startTime = System.nanoTime();

            GeocodingResult[] resultados = GeocodingApi.geocode(geocodificacion, direccion).await();

            LatLng localizacion = resultados[0].geometry.location;

            String lugares = resultados[0].formattedAddress;

            PlacesSearchResponse lugaresCercanos = com.google.maps.PlacesApi.nearbySearchQuery(geocodificacion, localizacion).radius(rango).await();

            StringBuilder respuesta = new StringBuilder();

            respuesta.append("Dirección: ").append(lugares).append("\n");

            respuesta.append("Lugares cercanos:\n");

            for (PlacesSearchResult lugar : lugaresCercanos.results)
                respuesta.append("- ").append(lugar.name).append("\n");

            long endTime = System.nanoTime();

            long timeElapsed = endTime - startTime;

            logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos del  servicio de Geocodificación Inversa: " + timeElapsed / 1000000);

            return respuesta.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener resultados.";
        }
    }
}
