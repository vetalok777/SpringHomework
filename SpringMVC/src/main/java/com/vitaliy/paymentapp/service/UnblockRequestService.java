package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.UnblockRequestDto;

import java.util.List;

public interface UnblockRequestService {
    UnblockRequestDto getUnblockRequest(Integer id);

    List<UnblockRequestDto> getAllUnblockRequest();

    UnblockRequestDto createUnblockRequest(UnblockRequestDto unblockRequestDto);

    UnblockRequestDto changeUnblockRequestStatus(String status, Integer id);
}
