package com.example.todoekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {
    public static  final String CONTENT="content";
    public static final String DONE="done";
    public static final String TODO ="todo" ;
    private EditText contentEditText;
private CheckBox doneCheckBox;
  private  Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        contentEditText=(EditText) findViewById(R.id.content_et);
     doneCheckBox =(CheckBox) findViewById(R.id.done_cb);
       saveButton= findViewById(R.id.save_btn);

       saveButton.setOnClickListener(new View.OnClickListener() {
           private static final String TODO = "todo";

           @Override
           public void onClick(View v) {
               String content=contentEditText.getText().toString();
               boolean isDone=doneCheckBox.isChecked();

               Todo todo =new Todo();
               todo.content=content;
               todo.done=isDone;

               Intent intent=new Intent();
               intent.putExtra(TODO,todo );
               intent.putExtra(DONE,isDone);
               setResult(RESULT_OK, intent);
               finish();
           }
       });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add_todo, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
