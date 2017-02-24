package com.example.bessie.appmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }
    public void sales (View v)
    {
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);
    }


    public void mall (View v)
    {
        Intent intent = new Intent(getBaseContext(),Malls.class);
        startActivity(intent);
    }

    public void competitions (View v)
    {
        Intent intent = new Intent(getBaseContext(),Competition.class);
        startActivity(intent);
    }
    public void promotion (View v)
    {
        Intent intent = new Intent(getBaseContext(),Promotions.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.message_icon:
                //TODO write actions here

                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                startActivity(intent);


                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
