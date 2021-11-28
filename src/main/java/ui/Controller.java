package ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RoutesManagementService;

@RestController
@RequestMapping(value = "/routes")
@ComponentScan("service")
public class Controller {

    @Autowired
    private RoutesManagementService service;

    @PostMapping(value = "/calculate/{initialPoint}{finalPoint}")
    public ResponseEntity calculateBestRoute(@PathVariable String finalPoint, @PathVariable String initialPoint){
        try {
            int firtspoint = Integer.parseInt(initialPoint);
            int lastPoint = Integer.parseInt(finalPoint);
            return new ResponseEntity(service.calculateRoute(firtspoint,lastPoint),HttpStatus.OK);
        }catch (NumberFormatException exception){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }

    }


}