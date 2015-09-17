package com.example.madany.app_viewholder;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.app.Activity;
import android.app.AlertDialog;

public class MainActivity extends Activity {

    AlertDialog alertDialogStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // a button to show the pop up with a list view
        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.buttonShowPopUp:
                        showPopUp();
                        break;
                }
            }
        };

        findViewById(R.id.buttonShowPopUp).setOnClickListener(handler);

    }

    public void showPopUp(){

        // we'll specify the number of items we want our ListView to have.
        int numberOfItems = 10;

        // add your items, this can be done programatically
        // your items can be from a database
        ObjectItem[] ObjectItemData = new ObjectItem[numberOfItems];

        // we'll use a for loop
        // created objects = number of items specified above
        for(int x=0; x<numberOfItems; x++){

            int sampleId = 9 + x;
            ObjectItemData[x] = new ObjectItem(sampleId, "Elemento # " + (x+1));

        }

        // our adapter instance
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_view_row_item, ObjectItemData);

        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = new ListView(this);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());

        // put the ListView in the pop up
        alertDialogStores = new AlertDialog.Builder(MainActivity.this)
                .setView(listViewItems)
                .setTitle("Elementos")
                .show();
    }


}