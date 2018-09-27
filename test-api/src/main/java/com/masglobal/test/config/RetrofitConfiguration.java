package com.masglobal.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masglobal.test.remote.EmployeeRemoteClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by angelquiroz on 9/26/18 .
 */
@Configuration
public class RetrofitConfiguration {

    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    private Environment environment;

    public RetrofitConfiguration(ObjectMapper jacksonObjectMapper) {
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    private Retrofit retrofitClient(String url, int timeout) {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper))
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    @Bean
    public EmployeeRemoteClient employeeClient() {
        String url = environment.getProperty("masglobal.test.clients.employees.url");
        int timeout = Integer.valueOf(environment.getProperty("masglobal.test.clients.employees.timeout"));
        return retrofitClient(url, timeout).create(EmployeeRemoteClient.class);
    }

}
