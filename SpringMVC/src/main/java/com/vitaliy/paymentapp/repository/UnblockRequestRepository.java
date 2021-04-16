package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.UnblockRequest;

import java.util.List;

public interface UnblockRequestRepository {
    UnblockRequest createUnblockRequest(UnblockRequest request);

    UnblockRequest getUnblockRequest(Integer id);

    List<UnblockRequest> getAllUnblockRequests();

    String updatePaymentStatus(String status, Integer id);
}
