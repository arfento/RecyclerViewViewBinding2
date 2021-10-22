package com.ims.recyclerviewviewbinding;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    private static final String TAG = "EmployeeRepository";
    private ArrayList<DataItem> employees = new ArrayList<>();
    private MutableLiveData<List<DataItem>> mutableLiveData = new MutableLiveData<>();
    public EmployeeRepository(){

    }

    public MutableLiveData<List<DataItem>> getMutableLiveData(){
        final apiInterface apiInterface = RetrofitClient.getService();

        Call<EmployeeResponse> employeeResponseCall = apiInterface.getEmployees();
        employeeResponseCall.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                EmployeeResponse employeeResponse = response.body();
                if (employeeResponse != null && employeeResponse.getData() != null){
                    employees = (ArrayList<DataItem>) employeeResponse.getData();
                    mutableLiveData.setValue(employees);
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;


    }


}
