package com.example.demo.services;

import com.example.demo.services.Interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import com.example.demo.models.Request;
import com.example.demo.repositories.RequestRepository;
import com.example.demo.enums.RequestStatus;
import java.util.List;
import java.util.Optional;
@Service

public class RequestServiceImp implements RequestService {
    @Autowired

    private RequestRepository requestRepository;
    @Override

    public Request createRequest(Request newRequest) {
        return requestRepository.save(newRequest);
    }
    @Override
    
    
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
    @Override
    
    
    public Request getRequestById(Integer ID) {
        return requestRepository.findById(ID).orElse(null);
        
    }
    @Override
    
    public Optional<Request> updateRequestStatus(Integer requestId, RequestStatus status) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus(status);
            return Optional.of(requestRepository.save(request));
        } else {
            throw new EntityNotFoundException("Request with ID " + requestId + " not found");
        }
    }
    
    @Override
    public void deleteRequest(Integer ID) {
        requestRepository.deleteById(ID);
    }
    
}
