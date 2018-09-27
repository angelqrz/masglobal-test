package com.masglobal.test.remote;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by angelquiroz on 9/26/18 .
 */
@Service
public class EmployeeRemoteService {

    private EmployeeRemoteClient employeeClient;

    public EmployeeRemoteService(EmployeeRemoteClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public List<EmployeeRemoteResponse> getEmployees(){
        Call<List<EmployeeRemoteResponse>> call = employeeClient.getEmployees();

        Response<List<EmployeeRemoteResponse>> response;

        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(
                    "Has occurred an error invoking getExperts method from experts manager . Error details: "
                            + e.getMessage());
        }

        return response.body();
    }
}
