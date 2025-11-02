package com.example.bt_recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {
    private RecyclerView recyclerView;
    private List<MyModel> myModelList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu
        myModelList = new ArrayList<>();
        myModelList.add(new MyModel("Alexander", 32));
        myModelList.add(new MyModel("Arun", 24));
        myModelList.add(new MyModel("Benjamin", 28));
        myModelList.add(new MyModel("Bruce", 26));
        myModelList.add(new MyModel("Charlotte", 23));
        myModelList.add(new MyModel("Daniel", 31));
        myModelList.add(new MyModel("David", 29));
        myModelList.add(new MyModel("Emma", 27));
        myModelList.add(new MyModel("Evan", 25));
        myModelList.add(new MyModel("Ethan", 22));
        myModelList.add(new MyModel("Fiona", 26));
        myModelList.add(new MyModel("Gabriel", 30));
        myModelList.add(new MyModel("Grace", 24));
        myModelList.add(new MyModel("Henry", 33));
        myModelList.add(new MyModel("Isabella", 25));
        myModelList.add(new MyModel("Imtiaj", 26));
        myModelList.add(new MyModel("James", 34));
        myModelList.add(new MyModel("Jennifer", 28));
        myModelList.add(new MyModel("Josh", 18));
        myModelList.add(new MyModel("Kevin", 22));
        myModelList.add(new MyModel("Lucas", 29));
        myModelList.add(new MyModel("Michael", 36));
        myModelList.add(new MyModel("Muntasir", 25));
        myModelList.add(new MyModel("Natasha", 24));
        myModelList.add(new MyModel("Raeed", 21));
        myModelList.add(new MyModel("Rakib", 28));
        myModelList.add(new MyModel("Sojib", 25));
        myModelList.add(new MyModel("Sophia", 26));
        myModelList.add(new MyModel("Stark", 35));
        myModelList.add(new MyModel("William", 30));
        // Gắn adapter
        customAdapter = new CustomAdapter(this, myModelList, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onItemClicked(MyModel myModel) {
        Toast.makeText(this, myModel.getName() + " - " + myModel.getAge() + " tuổi",
                Toast.LENGTH_SHORT).show();
    }
}