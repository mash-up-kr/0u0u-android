package kr.ac.mashup.kongukongu.kongukongu.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import kr.ac.mashup.kongukongu.kongukongu.R;
import kr.ac.mashup.kongukongu.kongukongu.RecyclerItemClickListener;
import kr.ac.mashup.kongukongu.kongukongu.post.PostActivity;
import kr.ac.mashup.kongukongu.kongukongu.profile.ProfileActivity;
import kr.ac.mashup.kongukongu.kongukongu.write.WriteActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    HomeAdapter adapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<HomeItemData> items;
    ArrayList<String> arraylist;
    private Spinner spinner;
    ArrayAdapter<CharSequence> adspin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        items = new ArrayList<>();

        adapter = new HomeAdapter(items);

        recyclerView.setAdapter(adapter);

        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));
        items.add(new HomeItemData(R.mipmap.ic_launcher,"Test","sample"));


        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setPrompt("시/도 를 선택하세요.");

        adspin = ArrayAdapter.createFromResource(this, R.array.selected,    android.R.layout.simple_spinner_item);

        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?>  parent) {
            }
        });
//        spinner = (Spinner)findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);

//        fab.setColorNormal(getResources().getColor(R.color.primary));
//        fab.setColorPressed(getResources().getColor(R.color.primary_pressed));

        fab.setShadow(false);
        fab.show();
//        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        fab.setColorFilter(R.color.gray);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "a", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, PostActivity.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );

    }

//    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
//
//        String firstItem = String.valueOf(spinner.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(spinner.getSelectedItem()))) {
//                // ToDo when first item is selected
//            } else {
//                Toast.makeText(parent.getContext(),
//                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_my_profile) {
//            Toast.makeText(MainActivity.this, "s", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
