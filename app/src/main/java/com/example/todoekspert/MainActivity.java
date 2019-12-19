package com.example.todoekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText usernameEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login_btn);
        button.setOnClickListener(this);
        usernameEditText = (EditText) findViewById(R.id.username_et);
        passwordEditText = (EditText) findViewById(R.id.password_et);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        String username = usernameEditText.getText().toString();
        String password = usernameEditText.getText().toString();
        boolean isError = false;

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError(getString(R.string.this_field_is_required));
            isError = true;

        }
        if (TextUtils.isEmpty(password)) {
            usernameEditText.setError(getString(R.string.this_field_is_required));
            isError = true;
        }
        if (!isError) {
            login(username, password);
        }
    }

    private void login(String username, String password) {
        if (username.equals("test") && password.equals("test")) {
            AsyncTask<String, Integer, Boolean> asyncTask = new AsyncTask<String, Integer, Boolean>() {
                @Override
                protected Boolean doInBackground(String... strings) {
                    String username = strings[0];
                    String password = strings[1];
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return username.equals("test") && password.equals("test");
                }

                protected void onPostExecute(Boolean logged) {
                    super.onPostExecute(logged);
                    button.setEnabled(true);
                    if (logged) {
                        Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TodoListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

                protected void onPreExecute() {
                    super.onPreExecute();
                    button.setEnabled(false);
                }
            };
            asyncTask.execute(username, password);
        }
    }
}