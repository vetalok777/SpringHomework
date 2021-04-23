package com.vitaliy.paymentapp.service.impl;


import com.vitaliy.paymentapp.dto.UnblockRequestDto;
import com.vitaliy.paymentapp.model.UnblockRequest;
import com.vitaliy.paymentapp.repository.UnblockRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnblockRequestServiceImpl implements com.vitaliy.paymentapp.service.UnblockRequestService {

    private final UnblockRequestRepository unblockRequestRepository;

    @Override
    public UnblockRequestDto getUnblockRequest(Integer id) {
        UnblockRequest unblockRequest = unblockRequestRepository.getUnblockRequest(id);
        return mapUnblockRequestToUnblockRequestDto(unblockRequest);
    }

    @Override
    public List<UnblockRequestDto> getAllUnblockRequest() {
        return unblockRequestRepository.getAllUnblockRequests().stream()
                .map(this::mapUnblockRequestToUnblockRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public UnblockRequestDto createUnblockRequest(UnblockRequestDto unblockRequestDto) {
        UnblockRequest unblockRequest = mapCardDtoToCard(unblockRequestDto);
        unblockRequest = unblockRequestRepository.createUnblockRequest(unblockRequest);
        return mapUnblockRequestToUnblockRequestDto(unblockRequest);
    }

    @Override
    public UnblockRequestDto changeUnblockRequestStatus(String status, Integer id) {
        UnblockRequest unblockRequest = unblockRequestRepository.changeUnblockRequestStatus(status, id);
        return mapUnblockRequestToUnblockRequestDto(unblockRequest);
    }


    private UnblockRequestDto mapUnblockRequestToUnblockRequestDto(UnblockRequest unblockRequest) {
        return UnblockRequestDto.builder()
                .cardId(unblockRequest.getCardId())
                .status(unblockRequest.getStatus())
                .consideredByAdmin(unblockRequest.getConsideredByAdmin())
                .creationDate(unblockRequest.getCreationDate())
                .build();
    }

    private UnblockRequest mapCardDtoToCard(UnblockRequestDto unblockRequestDto) {
        return UnblockRequest.builder()
                .cardId(unblockRequestDto.getCardId())
                .status(unblockRequestDto.getStatus())
                .consideredByAdmin(unblockRequestDto.getConsideredByAdmin())
                .creationDate(unblockRequestDto.getCreationDate())
                .build();
    }
}
