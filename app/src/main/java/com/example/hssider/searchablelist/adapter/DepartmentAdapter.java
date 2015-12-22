package com.example.hssider.searchablelist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hssider.searchablelist.R;
import com.example.hssider.searchablelist.holder.DepartmentHolder;
import com.example.hssider.searchablelist.model.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hssider on 12/10/15.
 */
public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentHolder> {

    private List<Department> departments;
    protected LayoutInflater inflater;

    public DepartmentAdapter(Context context, List<Department> departments) {
        this.inflater = LayoutInflater.from(context);
        this.departments = new ArrayList<>(departments);
    }

    @Override
    public DepartmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View itemView = inflater.inflate(R.layout.row_department, parent, false);
        return new DepartmentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DepartmentHolder departmentHolder, int position) {
        final Department department = departments.get(position);
        departmentHolder.bind(department);
    }

    @Override
    public int getItemCount() {
        return  departments.size();
    }

    public Department removeItem(int position) {
        final Department department = departments.remove(position);
        notifyItemRemoved(position);
        return department;
    }

    public void addItem(int position, Department department) {
        departments.add(position, department);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Department department = departments.remove(fromPosition);
        departments.add(toPosition, department);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<Department> departments) {
        applyAndAnimateRemovals(departments);
        applyAndAnimateAdditions(departments);
        applyAndAnimateMovedItems(departments);
    }

    private void applyAndAnimateRemovals(List<Department> newModels) {
        for (int i = departments.size() - 1; i >= 0; i--) {
            final Department department = departments.get(i);
            if (!newModels.contains(department)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Department> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Department department = newModels.get(i);
            if (!departments.contains(department)) {
                addItem(i, department);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Department> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Department department = newModels.get(toPosition);
            final int fromPosition = departments.indexOf(department);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }
}
