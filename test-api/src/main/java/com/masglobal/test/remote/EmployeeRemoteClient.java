package com.masglobal.test.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public interface EmployeeRemoteClient {
    @GET("./")
    Call<List<EmployeeRemoteResponse>> getEmployees();
}
