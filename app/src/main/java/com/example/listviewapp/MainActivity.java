package com.example.listviewapp;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView customListView;
    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customListView = findViewById(R.id.customListView);
        expandableListView = findViewById(R.id.expandableListView);

        // Data for Custom ListView
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            items.add("Item " + i);
        }
        customAdapter = new CustomAdapter(this, items);
        customListView.setAdapter(customAdapter);

        // Data for Expandable ListView
        prepareListData();
        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding header data
        listDataHeader.add("Group 1");
        listDataHeader.add("Group 2");
        listDataHeader.add("Group 3");

        // Adding child data
        List<String> group1 = new ArrayList<>();
        group1.add("Child 1.1");
        group1.add("Child 1.2");

        List<String> group2 = new ArrayList<>();
        group2.add("Child 2.1");
        group2.add("Child 2.2");

        List<String> group3 = new ArrayList<>();
        group3.add("Child 3.1");
        group3.add("Child 3.2");

        listDataChild.put(listDataHeader.get(0), group1);
        listDataChild.put(listDataHeader.get(1), group2);
        listDataChild.put(listDataHeader.get(2), group3);
    }
}
