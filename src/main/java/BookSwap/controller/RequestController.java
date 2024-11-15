package BookSwap.controller;

import BookSwap.model.entity.Notification;
import BookSwap.model.entity.Request;
import BookSwap.service.INotification;
import BookSwap.service.IRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:5173")
public class RequestController {

    @Autowired
    private IRequest requestService;

    @PostMapping(path = "request")
    public Request create(@RequestBody Request request) { return requestService.save(request); }

    @PutMapping(path = "request")
    public Request update(@RequestBody Request request) { return requestService.save(request); }

    @DeleteMapping(path = "request/{id}")
    public void delete(@PathVariable Integer id) {
        requestService.delete(requestService.findById(id));
    }

    @GetMapping(path = "request/{id}")
    public Request findById(@PathVariable Integer id) {
        return requestService.findById(id);
    }

    @GetMapping(path = "requests")
    public List<Request> findAll(){
        return requestService.findAll();
    }

}
