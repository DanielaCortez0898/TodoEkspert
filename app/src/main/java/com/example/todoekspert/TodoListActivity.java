package com.example.todoekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TodoListActivity extends AppCompatActivity {


    private static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            finish();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return true;
        }else if(id==R.id.action_new){
            Intent intent=new Intent(getApplicationContext(),AddTodoActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
        return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK) {
                Todo todo=(Todo) data.getSerializableExtra(AddTodoActivity.TODO);
                Toast.makeText(getApplicationContext(), "Result ok content:"+ todo.content, Toast.LENGTH_SHORT).show();
            }else if(resultCode==RESULT_CANCELED){
                    Toast.makeText(getApplicationContext(),"Result canceled!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
