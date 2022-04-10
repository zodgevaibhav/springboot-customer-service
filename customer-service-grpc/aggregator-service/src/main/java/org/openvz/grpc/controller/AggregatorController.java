package org.openvz.grpc.controller;

import org.openvz.grpc.service.AggregatorService;
import org.openvz.proto.customer.AddCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlecode.protobuf.format.JsonFormat;

@RestController
@RequestMapping("/api")
public class AggregatorController {

    @Autowired
    private AggregatorService aggregatorService;
    
    @GetMapping(path="/customer/all",produces= {"application/json"})
    public String getAllCustomers(){
    	AddCustomerResponse addCustomerResponse =  this.aggregatorService.getAllCustomers();
    	
    	return new JsonFormat().printToString(addCustomerResponse);
    }

}
