package BookSwap.controller;

import BookSwap.model.entity.Exchange;
import BookSwap.service.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ExchangeController {

    @Autowired
    private IExchange exchangeService;

    @PostMapping(path = "exchange")
    public Exchange create(@RequestBody Exchange exchange) { return exchangeService.save(exchange); }

    @PutMapping(path = "exchange")
    public Exchange update(@RequestBody Exchange exchange) { return exchangeService.save(exchange); }

    @DeleteMapping(path = "exchange/{id}")
    public void delete(@PathVariable Integer id) {
        exchangeService.delete(exchangeService.findById(id));
    }

    @GetMapping(path = "exchange/{id}")
    public Exchange findById(@PathVariable Integer id) {
        return exchangeService.findById(id);
    }

    @GetMapping(path = "exchanges")
    public List<Exchange> findAll(){
        return exchangeService.findAll();
    }

}
