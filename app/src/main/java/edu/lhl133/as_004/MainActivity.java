package edu.lhl133.as_004;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void q1(View view)
    {
        Intent itent=new Intent(MainActivity.this,q1Activity.class);
        startActivity(itent);
    }

    public void q2(View view)
    {
        Intent intent=new Intent(MainActivity.this,q2Activity.class);
        startActivity(intent);
    }

    public void q3(View view)
    {
        Intent intent=new Intent(MainActivity.this,q3Activity.class);
        startActivity(intent);
    }

}
