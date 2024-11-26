package BookSwap.service.impl;

import BookSwap.model.dao.RequestDao;
import BookSwap.model.dao.UserDao;
import BookSwap.model.entity.Copy;
import BookSwap.model.entity.Request;
import BookSwap.model.entity.User;
import BookSwap.service.IRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RequestImpl implements IRequest {

    @Autowired
    private RequestDao requestDao;
    private UserDao userDao;

    @Transactional
    public Request save(Request request) {
        return requestDao.save(request);
    }

    @Transactional(readOnly = true)
    public Request findById(Integer id) {
        return requestDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Request request) {
        requestDao.delete(request);
    }

    @Transactional
    public List<Request> findAll() {
        Iterable<Request> requestsIterable = requestDao.findAll();
        List<Request> requestsList = new ArrayList<>();
        requestsIterable.forEach(requestsList::add);
        return requestsList;
    }

    @Override
    public List<Request> RequestsUser(String id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Obtener las copias asociadas al usuario
        List<Copy> userCopies = user.getCopiesList();

        // Buscar las solicitudes relacionadas con esas copias
        List<Request> requests = new ArrayList<>();
        for (Copy copy : userCopies) {
            // Agregar solicitudes de copias ofrecidas y solicitadas
            requests.addAll(requestDao.findByOfferedCopiesListContains(copy));
            requests.addAll(requestDao.findByRequestedCopiesListContains(copy));
        }

        // Eliminar duplicados si la misma solicitud aparece dos veces
        return requests.stream().distinct().collect(Collectors.toList());
    }


}
