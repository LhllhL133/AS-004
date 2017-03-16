package edu.lhl133.as_004;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q3Activity extends AppCompatActivity {

    private String[] names = new String[]{"one", "two", "three", "four", "five"};
    private int imageid = R.drawable.lll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("name", names[i]);
            item.put("desc", imageid);
            listitem.add(item);
        }
        SimpleAdapter s = new SimpleAdapter(this, listitem, R.layout.list_item,
                new String[]{"name", "desc"},
                new int[]{R.id.name, R.id.desc});
        ListView list = (ListView) findViewById(R.id.listView);

        list.setAdapter(s);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
        {
            registerForContextMenu(list);
        }
        else
        {
            list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
            list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
                @Override
                public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                    ListView list = (ListView) findViewById(R.id.listView);
//                    for(int i=0;i<5;i++) {
//                        Log.d("2", "" + (list.isItemChecked(i)==true?"yes":"no"));
//                    }
                    mode.setTitle(list.getCheckedItemCount()+" selected");
                }

                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.actionmode_menu, menu);
                    ListView list = (ListView) findViewById(R.id.listView);
//                    for(int i=0;i<5;i++) {
//                        Log.d("" + ListView.CHOICE_MODE_MULTIPLE_MODAL, "" + (list.isItemChecked(i)==true?"yes":"no"));
//                    }
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.add:
                            Toast.makeText(q3Activity.this,"add",Toast.LENGTH_LONG).show();
                            break;
                        case R.id.delete:
                            Toast.makeText(q3Activity.this,"delete",Toast.LENGTH_LONG).show();
                            break;
                        case R.id.update:
                            Toast.makeText(q3Activity.this,"update",Toast.LENGTH_LONG).show();
                            break;
                    }
                    return true;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                }
            });
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);
        //装填R.menu.my_menu对应的菜单，并添加到menu中
        inflator.inflate(R.menu.actionmode_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                Toast.makeText(q3Activity.this,"add",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(q3Activity.this,"delete",Toast.LENGTH_LONG).show();
                break;
            case R.id.update:
                Toast.makeText(q3Activity.this,"update",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
