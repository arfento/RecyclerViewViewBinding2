package com.ims.recyclerviewviewbinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.ims.recyclerviewviewbinding.databinding.ListEmployeeBinding;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.ViewHolder> {

    private ArrayList<DataItem> employees;



    @NonNull
    @Override
    public EmployeeDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListEmployeeBinding employeeBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.list_employee, parent, false);
        return new ViewHolder(employeeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeDataAdapter.ViewHolder holder, int position) {
        DataItem currentEmployee = employees.get(position);
        holder.employeeBinding.setEmployee(currentEmployee);
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }
    public void setEmployeeList(ArrayList<DataItem> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ListEmployeeBinding employeeBinding;

        public ViewHolder(ListEmployeeBinding employeeBinding) {
            super(employeeBinding.getRoot());

            this.employeeBinding = employeeBinding;
        }
    }


}

