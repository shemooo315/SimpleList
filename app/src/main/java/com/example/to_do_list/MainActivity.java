package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView mylist=(ListView)findViewById(R.id.viewlist);

        final ArrayAdapter<String> list_adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        mylist.setAdapter(list_adapter);
        Button btn_add=(Button)findViewById(R.id.button_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           EditText my_item=(EditText)findViewById(R.id.editText_list);
                                           String value=my_item.getText().toString();
                                           list_adapter.add(value);
                                           my_item.getText().clear();
                                       }
                                   }
        );

        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list_adapter.remove(list_adapter.getItem(i));
                list_adapter.notifyDataSetChanged();
                return true;
            }
        });



    }
}