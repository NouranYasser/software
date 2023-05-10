package com.example.demo.services.Interfaces;
import com.example.demo.enums.RequestStatus;
import com.example.demo.models.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request createRequest(Request newRequest);

    List<Request> getAllRequests();

    Request getRequestById(Integer ID);
    Optional<Request> updateRequestStatus(Integer requestId, RequestStatus status);

    void deleteRequest(Integer ID);

}
