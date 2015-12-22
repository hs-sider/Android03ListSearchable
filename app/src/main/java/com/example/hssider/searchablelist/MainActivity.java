package com.example.hssider.searchablelist;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hssider.searchablelist.adapter.DepartmentAdapter;
import com.example.hssider.searchablelist.model.Department;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private DepartmentAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Department> departments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.department_recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        departments = generateDepartments();

        adapter = new DepartmentAdapter(this.getApplicationContext(), departments);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<Department> filteredDepartments = filter(departments, query);
        adapter.animateTo(filteredDepartments);
        recyclerView.scrollToPosition(0);
        return true;
    }

    private List<Department> filter(List<Department> departments, String query) {
        query = query.toLowerCase();

        final List<Department> filteredModelList = new ArrayList<>();
        for (Department department : departments) {
            final String text = department.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(department);
            }
        }
        return filteredModelList;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchable, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<Department> generateDepartments() {

        List<Department> departments = new ArrayList<>();

        Department dpt01 = new Department();
        dpt01.setName("Beni");
        dpt01.setCapital("Trinidad");
        dpt01.setExtension(213564);
        dpt01.setPopulation(430049);
        dpt01.setImgPath("_Beni");
        departments.add(dpt01);

        Department dpt02 = new Department();
        dpt02.setName("Chuquisaca");
        dpt02.setCapital("Sucre");
        dpt02.setExtension(51524);
        dpt02.setPopulation(631062);
        dpt02.setImgPath("_Chuquisaca");
        departments.add(dpt02);

        Department dpt03 = new Department();
        dpt03.setName("Cochabamba");
        dpt03.setCapital("Cochabamba");
        dpt03.setExtension(55631);
        dpt03.setPopulation(1786040);
        dpt03.setImgPath("_Cochabamba");
        departments.add(dpt03);

        Department dpt04 = new Department();
        dpt04.setName("La Paz");
        dpt04.setCapital("Nuestra Señora de La Paz");
        dpt04.setExtension(133985);
        dpt04.setPopulation(2756989);
        dpt04.setImgPath("_LaPaz");
        departments.add(dpt04);

        Department dpt05 = new Department();
        dpt05.setName("Oruro");
        dpt05.setCapital("Oruro");
        dpt05.setExtension(53588);
        dpt05.setPopulation(444093);
        dpt05.setImgPath("_Oruro");
        departments.add(dpt05);

        Department dpt06 = new Department();
        dpt06.setName("Pando");
        dpt06.setCapital("Cobija");
        dpt06.setExtension(63827);
        dpt06.setPopulation(75335);
        dpt06.setImgPath("_Pando");
        departments.add(dpt06);

        Department dpt07 = new Department();
        dpt07.setName("Potosi");
        dpt07.setCapital("Potosi");
        dpt07.setExtension(118218);
        dpt07.setPopulation(780392);
        dpt07.setImgPath("_Potosi");
        departments.add(dpt07);

        Department dpt08 = new Department();
        dpt08.setName("Santa Cruz");
        dpt08.setCapital("Santa Cruz de la Sierra");
        dpt08.setExtension(370621);
        dpt08.setPopulation(2626697);
        dpt08.setImgPath("_SantaCruz");
        departments.add(dpt08);

        Department dpt09 = new Department();
        dpt09.setName("Tarija");
        dpt09.setCapital("Tarija");
        dpt09.setExtension(37623);
        dpt09.setPopulation(496988);
        dpt09.setImgPath("_Tarija");
        departments.add(dpt09);

        return departments;
    }
}
