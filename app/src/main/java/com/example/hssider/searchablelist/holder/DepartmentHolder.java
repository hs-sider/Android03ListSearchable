package com.example.hssider.searchablelist.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hssider.searchablelist.R;
import com.example.hssider.searchablelist.model.Department;

/**
 * Created by hssider on 12/10/15.
 */
public class DepartmentHolder extends RecyclerView.ViewHolder {

    private final TextView tv_depName;
    private final TextView tv_depCapital;
    private final TextView tv_depExtension;
    private final TextView tv_depPopulation;

    public DepartmentHolder(View itemView) {
        super(itemView);

        tv_depName = (TextView) itemView.findViewById(R.id.tv_dep_name);
        tv_depCapital = (TextView) itemView.findViewById(R.id.tv_dep_capital);
        tv_depExtension = (TextView) itemView.findViewById(R.id.tv_dep_extension);
        tv_depPopulation = (TextView) itemView.findViewById(R.id.tv_dep_population);
    }

    public void bind(Department department) {
        tv_depName.setText(department.getName());
        tv_depCapital.setText(department.getCapital());
        tv_depExtension.setText(department.getExtension() + "");
        tv_depPopulation.setText(department.getPopulation() + "");
    }
}
