package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ReciyclerAdapter.ListItemClick {
   // private RecyclerView recyclerView;
    private List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView = findViewById(R.id.rv_numeros);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);

        // ReciyclerAdapter adapter=new ReciyclerAdapter(50, this);

        //recyclerView.setAdapter(adapter);
        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "1 Pedro", "Mexico", "Activo"));
        elements.add(new ListElement("#F29A89", "2 Juan", "Mexico", "Activo"));
        elements.add(new ListElement("#D6234A", "3 Lalo", "Mexico", "Activo"));
        elements.add(new ListElement("#F8E469", "4 Hector", "Mexico", "Activo"));
        elements.add(new ListElement("#575443", "5 Mariana", "Mexico", "Activo"));
        elements.add(new ListElement("#F29A89", "6 Juan", "Mexico", "Activo"));
        elements.add(new ListElement("#D6234A", "7 Lalo", "Mexico", "Activo"));
        elements.add(new ListElement("#F8E469", "8 Hector", "Mexico", "Activo"));
        elements.add(new ListElement("#575443", "9 Mariana", "Mexico", "Activo"));
        elements.add(new ListElement("#575443", "9 Mariana", "Mexico", "Activo"));

        ReciyclerAdapter adapter = new ReciyclerAdapter(elements, this, this);

        RecyclerView recyclerView = findViewById(R.id.rv_numeros);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onListItemClick(int clickedItem) {
        String mensaje = "item # " + clickedItem + " ";
        Toast.makeText(this, " " + mensaje, Toast.LENGTH_SHORT).show();
    }
}