package com.example.bessie.appmall;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listview;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode =0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = (ViewStub) findViewById(R.id.stublist);
        stubGrid = (ViewStub) findViewById(R.id.stubgrid);

        //inflate viewstub before get view

        stubList.inflate();
        stubGrid.inflate();

        listview = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //get list of product

        getProductList();

        //get current view mode in share reference

        SharedPreferences sharedpreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedpreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//default is listview
        //Register item click
        listview.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);


        switchView();

    }

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //display Listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        }
        else {
            //hide listview
            stubList.setVisibility(View.GONE);
            //display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }

        setAdapters();
    }

    private void setAdapters() {

        if(VIEW_MODE_LISTVIEW == currentViewMode){
            listViewAdapter = new ListViewAdapter(this, R.layout.list_items, productList);
            listview.setAdapter(listViewAdapter);
        }
        else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_items, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }


    public List<Product> getProductList() {
        //psuedo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.coke,"R8.99 (500ml) ","Can Assorted(All Checkers stores)"));
        productList.add(new Product(R.drawable.maize,"R27.99 (2.5 kg)","Ace Maize meal, Southdale Shoprite"));
        productList.add(new Product(R.drawable.purity,"R22.99 (200 g)","Purity Baby first box get free bottle, Southgate Checkers"));
        productList.add(new Product(R.drawable.rat,"Title 4","This description 4"));
        productList.add(new Product(R.drawable.rat,"Title 5","This description 5"));
        productList.add(new Product(R.drawable.rat,"Title 6","This description 6"));
        productList.add(new Product(R.drawable.rat,"Title 7","This description 7"));
        productList.add(new Product(R.drawable.rat,"Title 8","This description 8"));
        productList.add(new Product(R.drawable.rat,"Title 9","This description 9"));
        productList.add(new Product(R.drawable.rat,"Title 10","This description 10"));


        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //do anything when user clicks on item
            Toast.makeText(getApplicationContext(), productList.get(position).getTitle()+"-"+ productList.get(position).getDescription(),Toast.LENGTH_SHORT).show();

        }
    };

         @Override
    public boolean onCreateOptionsMenu(Menu menu){
             getMenuInflater().inflate(R.menu.main, menu);
             return super.onCreateOptionsMenu(menu);


         }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;

                }
                else {
                    currentViewMode = VIEW_MODE_LISTVIEW ;
                }
                   //switch view
                switchView();
                //save view  mode in share reference

                SharedPreferences sharedPreferences = getSharedPreferences("Viewmode",MODE_PRIVATE);
                SharedPreferences.Editor  editor =  sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();


                break;
        }

        return true;

    }


}
