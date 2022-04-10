package org.openvz.grpc.service;

import org.openvz.proto.customer.AddCustomerRequest;
import org.openvz.proto.customer.AddCustomerResponse;
import org.openvz.proto.customer.AddCustomerServiceGrpc;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import reactor.core.publisher.Flux;

@Service
public class AggregatorService {

	@GrpcClient("customer-service-grpc")
	private AddCustomerServiceGrpc.AddCustomerServiceBlockingStub blockingCustomerStub;

//	public Flux<AddCustomerResponse> getAllCustomers() {
//
//		AddCustomerRequest req = AddCustomerRequest.newBuilder().setCustomerId("VZ001").setFirstName("VZ").build();
//
//		return Flux.create(fluxSink -> {
//			fluxSink.next(this.blockingCustomerStub.addCustomer(req));
//			fluxSink.complete();
//		});
//	}
	
	public AddCustomerResponse getAllCustomers() {
		
		System.out.println("###################### Request IN Agreegator Service");

		AddCustomerRequest req = AddCustomerRequest.newBuilder().setCustomerId("VZ001").setFirstName("VZ").build();
		
		System.out.println("###################### Request About to IN Agreegator Service");

		return this.blockingCustomerStub.addCustomer(req);
	}
}
