package com.example.homework4112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.homework4112.R.string.large_text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        //String[] values = prepareContent();

        List<Map<String,String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);

        String[] noteTxt = sharedPref.getString(getString(large_text).split("\n\n")); //застрял здесь


    }

    @NonNull
    private List<Map<String,String>> prepareContent(){
        String titleLength;
        List<Map<String,String>> data = new ArrayList<>();

        String[] arrayContent = getString(large_text).split("\n\n");
        Map<String,String> title = new HashMap<>();
        Map<String,String> title2 = new HashMap<>();
        Map<String,String> title3 = new HashMap<>();
        Map<String,String> title4 = new HashMap<>();
        Map<String,String> title5 = new HashMap<>();
        
//        for (int i = 0; i < arrayContent.length; i++) {
//            title.put("title",arrayContent[i]);
//            titleLength = String.valueOf(arrayContent[i].length());
//            title.put("subtitle",titleLength);
//            data.add(title);
//        }
//        title.put("title",arrayContent[3]);
//        title.put("subtitle","test");

        title.put("title",arrayContent[0]);
        title.put("subtitle",String.valueOf(arrayContent[0].length()));

        title2.put("title",arrayContent[1]);
        title2.put("subtitle",String.valueOf(arrayContent[1].length()));

        title3.put("title",arrayContent[2]);
        title3.put("subtitle",String.valueOf(arrayContent[2].length()));

        title4.put("title",arrayContent[3]);
        title4.put("subtitle",String.valueOf(arrayContent[3].length()));

        title5.put("title",arrayContent[4]);
        title5.put("subtitle",String.valueOf(arrayContent[4].length()));

        data.add(title);
        data.add(title2);
        data.add(title3);
        data.add(title4);

        return data;
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String,String>> values){
        return new SimpleAdapter(this, values, R.layout.simple_list_view,
                new String[]{"title","subtitle"},new int[]{R.id.title,R.id.subtitle});
    }

//    @NonNull
//    private BaseAdapter createAdapter(String[] values) {
//        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
//    }

//    @NonNull
//    private String[] prepareContent() {
//        return getString(R.string.large_text).split("\n\n");
//    }


}
