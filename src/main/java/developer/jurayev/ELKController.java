package developer.jurayev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/elk")
public class ELKController {
    private final Logger logger = (Logger) LogManager.getLogger(ELKController.class);
    @GetMapping(path = "/welcome")
    public ResponseEntity<String> welcome() {
        logger.debug("Welcome to ELK demo service");
        return ResponseEntity.ok("Hello ELK Integration!!!");
    }
    @GetMapping(path = "/users/{name}")
    public ResponseEntity<String> getUserByName(@PathVariable String name) {
        if (name.equals("ADMIN")) {
            logger.debug("Access by ADMIN triggered");
            return ResponseEntity.ok("Access Granted to " + name);
        } else {
            logger.error("Access denied for: " + name);
            return new ResponseEntity<>(("Access Denied for " + name), HttpStatus.BAD_REQUEST);
        }
    }
}
