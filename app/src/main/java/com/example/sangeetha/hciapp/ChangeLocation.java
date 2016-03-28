package com.example.sangeetha.hciapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sangeetha on 3/27/16.
 */
public class ChangeLocation extends Activity {

    EditText new_location;
    Button submit;
    String location = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_location);

        submit = (Button) findViewById(R.id.button_change_location);
        new_location = (EditText) findViewById(R.id.id_location);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                location = new_location.getText().toString();
                Toast.makeText(getApplicationContext(),
                "Location changed to " + location,
                Toast.LENGTH_LONG).show();

                Intent backtoIntroPage = new Intent(ChangeLocation.this, welcome.class);
                startActivity(backtoIntroPage);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
