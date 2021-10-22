package com.ims.recyclerviewviewbinding;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiInterface {
    @GET("users/?per_page=12&page=1")
    Call<EmployeeResponse> getEmployees();
}
