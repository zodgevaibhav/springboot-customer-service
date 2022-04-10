package org.openvz.customer.services;
import org.openvz.proto.customer.AddCustomerRequest;
import org.openvz.proto.customer.AddCustomerResponse;
import org.openvz.proto.customer.AddCustomerServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class AddCustomerService extends AddCustomerServiceGrpc.AddCustomerServiceImplBase{

	@Override
	public void addCustomer(AddCustomerRequest request, StreamObserver<AddCustomerResponse> responseObserver) {
		System.out.println("################### Request In at GRPC");
		responseObserver.onNext(AddCustomerResponse.newBuilder().clear().setCustomerCode(123).setCustomerId("VZ001").setFirstName("Vaibhav").setLastName("Zodge").build());
		responseObserver.onCompleted();
		System.out.println("################### Request Out from GRPC");
		//super.addCustomer(request, responseObserver);
	}

	
	
	
}
