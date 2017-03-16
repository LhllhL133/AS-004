package edu.lhl133.as_004;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class q1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
    }

    public void customdialog(View view)
    {
        LinearLayout question1_view = (LinearLayout)getLayoutInflater()
                .inflate( R.layout.question1_view, null);
        new AlertDialog.Builder(this)
                .setView(question1_view)
                .setPositiveButton("loggin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(q1Activity.this, "loggin", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(q1Activity.this, "cancle", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();

    }
}
