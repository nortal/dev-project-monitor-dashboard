package com.nortal.devdash.ping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nortal.devdash.ping.model.PingInfo;
import com.nortal.devdash.rest.ResponseEvent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("ping")
@ApiModel(value = "Ping operations")
public class PingInfoController {
    @Autowired
    private PingInfoUseCase pingInteractor;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(
            value = "Returns ping result list",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = PingInfo.class)
    public ResponseEntity<List<PingInfo>> getPingInfos() {
        return ResponseEvent.of(pingInteractor.getPingResult()).requiredResponse();
    }

}
