package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.UnblockRequestDto;
import com.vitaliy.paymentapp.service.UnblockRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unblockRequests")
@Slf4j
public class UnblockRequestController {

    private final UnblockRequestService unblockRequestService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UnblockRequestDto getUnblockRequest(@PathVariable Integer id) {
        log.info("Get unblock request: " + unblockRequestService.getUnblockRequest(id));
        return unblockRequestService.getUnblockRequest(id);
    }

    @GetMapping("/allUnblockRequests")
    @ResponseStatus(HttpStatus.OK)
    public List<UnblockRequestDto> getAllUnblockRequest() {
        log.info("Get all unblock requests: " + unblockRequestService.getAllUnblockRequest());
        return unblockRequestService.getAllUnblockRequest();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UnblockRequestDto createUnblockRequest(@RequestBody UnblockRequestDto unblockRequestDto) {
        log.info("Create unblock request: " + unblockRequestDto);
        return unblockRequestService.createUnblockRequest(unblockRequestDto);
    }

    @PutMapping("/changeStatus/{id}{status}")
    @ResponseStatus(HttpStatus.OK)
    public UnblockRequestDto changeUnblockRequestStatus(@PathVariable Integer id, @PathVariable String status) {
        log.info("Change unblock request status: " + id + ", " + status);
        return unblockRequestService.changeUnblockRequestStatus(status, id);
    }
}
