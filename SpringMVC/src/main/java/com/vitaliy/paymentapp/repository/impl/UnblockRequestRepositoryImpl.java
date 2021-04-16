package com.vitaliy.paymentapp.repository.impl;

import com.vitaliy.paymentapp.model.Payment;
import com.vitaliy.paymentapp.model.UnblockRequest;
import com.vitaliy.paymentapp.repository.UnblockRequestRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnblockRequestRepositoryImpl implements UnblockRequestRepository {

    private List<UnblockRequest> requests = new ArrayList<>();

    @Override
    public UnblockRequest createUnblockRequest(UnblockRequest request) {
        requests.add(request);
        return request;
    }

    @Override
    public UnblockRequest getUnblockRequest(Integer id) {
        return requests.stream()
                .filter(request -> request.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UnblockRequest> getAllUnblockRequests() {
        return requests;
    }

    @Override
    public String updatePaymentStatus(String status, Integer id) {
        UnblockRequest request = getUnblockRequest(id);
        request.setStatus(status);
        return request.getStatus();
    }
}
