package edu.lhl133.as_004;

import android.graphics.Color;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class q2Activity extends AppCompatActivity {


    private TextView tester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        tester =(TextView) findViewById(R.id.test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = new MenuInflater(this);
        //装填R.menu.my_menu对应的菜单，并添加到menu中
        inflator.inflate(R.menu.custon_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.font10:
                tester.setTextSize(10*2);
                break;
            case R.id.font14:
                tester.setTextSize(14*2);
                break;
            case R.id.front20:
                tester.setTextSize(20*2);
                break;
            case R.id.normal:
                Toast.makeText(q2Activity.this,"普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                tester.setTextColor(Color.RED);
                break;
            case R.id.black:
                tester.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
