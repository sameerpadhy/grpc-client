package com.sameer.client;
import com.sameer.grpc.User.APIResponse;
import com.sameer.grpc.User.LoginRequest;
import com.sameer.grpc.userGrpc;
import com.sameer.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GRPCClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        // stubs - generate from proto

        userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();

        APIResponse response = userStub.login(loginrequest);

        System.out.println(response.getResponsemessage());


    }
}
