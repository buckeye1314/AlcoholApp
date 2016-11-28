package com.example.phillip.alcoholapp;

        import android.database.Cursor;
        import android.database.SQLException;
        import android.net.Uri;
        import android.os.Bundle;
        import android.app.Activity;
        import android.os.StrictMode;
        import android.view.Menu;
        import android.widget.ListView;
        import android.widget.SimpleCursorAdapter;
        import android.widget.TextView;
        import android.widget.EditText;
        import android.widget.Button;
        import android.view.View;
        import android.database.sqlite.*;


        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;


        import org.jsoup.*;
        import org.jsoup.nodes.Document;
        import org.jsoup.select.Elements;
        import org.w3c.dom.Text;

        import java.io.IOException;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;

public class AlcoholActivity extends Activity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public static Map<String, Double> listOfProducts = new TreeMap<String, Double>();
    public List<String> productLinks = new ArrayList<String>();
    public static boolean databaseUpdated = false;

    static SQLiteDatabase tempDatabase;
    static String[] tempLinks;
    static ListView listView1;
    static Cursor RatioCursor;
    static SimpleCursorAdapter cursorAdapter;
















    public static double getPrice(String html) {




        boolean foundPrice = false;
        int lengthTextSearch = html.length();
        int pricePlace = 0;
        int endPlace = 0;



        for (int i = 0; i < 3000 && i<lengthTextSearch-5; i++) {
            if (html.substring(i, i + 5).equals("price")) {
                for (int j = 0; j < 3000&& i<lengthTextSearch-5; j++) {
                    if (html.substring(i + j, i + j + 1).equals(",")) {
                        endPlace = j;
                        j = lengthTextSearch;
                    }
                }
                pricePlace = i;
                i = lengthTextSearch;
                foundPrice = true;
            }

        }
        if (foundPrice == false) {
            return 0.0;
        }


        return Double.parseDouble(html.substring(pricePlace + 7, pricePlace + endPlace));
    }






    public static Map<String,Double> createProductMap(String[] links, Map<String, Double> map) throws IOException {

        for (int i = 0; i < links.length; i++) {
            System.out.println(links.length);
            double price = getPrice(links[i]);
            System.out.println(price);
            map.put(links[i], price);
        }
        return map;

    }

    public static void updateSQLPrice(Map<String,Double> map, SQLiteDatabase SQL, String[] links) throws SQLException, IOException {

        for (int i = 0; i < links.length; i++) {

            SQL.execSQL("UPDATE Beer SET Price = " + map.get(links[i]) + " WHERE URL = '" + links[i] + "'");
        }
    }

    public static void addLinksToList(Cursor cursor, String[] links) throws SQLException {
        cursor.moveToFirst();

        for(int i = 0; cursor.isAfterLast() == false;i++)
        {
            links[i] = cursor.getString(0);
            cursor.moveToNext();
        }


    }

    public static void calculateAlcoholDollarRatio(Cursor cursor, SQLiteDatabase SQL)
    {
        int i = 1;
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false)
        {
            if(cursor.getDouble(3)> 0.0) {
                SQL.execSQL("UPDATE Beer SET 'Alcohol(Fluid oz)/Dollar($)' = " + (cursor.getDouble(2) / cursor.getDouble(3)) + " WHERE `_id` = " + i);
            }
            i++;
            cursor.moveToNext();
        }
    }

    public static void printAlcoholRatio(Cursor cursor,TextView resp)
    {
        String ratio = "";
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false)
        {
            ratio += cursor.getDouble(3) + "\n";
            cursor.moveToNext();
        }
        resp.setText(ratio);
    }




    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol);
        Button b = (Button) this.findViewById(R.id.Database_button);

        final MyDatabase database = new MyDatabase(this);
        final SQLiteDatabase AlcoholDatabase = database.getWritableDatabase();

        tempDatabase = AlcoholDatabase;




        final String[] Namecolumn = {"Name"};
        final String[] URLcolumn = {"URL"};


        final Cursor currentCursor = AlcoholDatabase.query("Beer",Namecolumn,"_id=30",null,null,null,null,null);
        final Cursor URLCursor = AlcoholDatabase.query("Beer",URLcolumn,null,null,null,null,null,null);
        final Cursor DatabaseCursor = AlcoholDatabase.query("Beer",null,null,null,null,null,null,null);
        RatioCursor = AlcoholDatabase.query("Beer",null,null,null,null,null,null,null);
        currentCursor.moveToFirst();
        DatabaseCursor.moveToLast();
        URLCursor.moveToFirst();


        final String[] productsLinksToBeExecuted = new String[DatabaseCursor.getInt(0)];
        addLinksToList(URLCursor,productsLinksToBeExecuted);

        tempLinks = productsLinksToBeExecuted;

         listView1 = (ListView) findViewById(R.id.listView);

        String[] fromColumn = {DatabaseCursor.getColumnName(1),DatabaseCursor.getColumnName(4)};
        int[] toView = {R.id.Product_Name,R.id.Product_Ratio};
        cursorAdapter = new SimpleCursorAdapter(this,R.layout.a,RatioCursor,fromColumn,toView,0);

        listView1.setAdapter(cursorAdapter);






        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {






                RetrievePriceOfLinks myRetrievePriceOfLinks = new RetrievePriceOfLinks(AlcoholActivity.this);
                myRetrievePriceOfLinks.execute(productsLinksToBeExecuted);


                //try {
                  //  updateSQLPrice(productsLinksToBeExecuted,AlcoholDatabase);
                //} catch (IOException e) {
                 //   e.printStackTrace();
               // }


                //addLinksToList(SQL, productLinks);
                // System.out.println(productLinks.size());


                ///try {
                // updateSQLPrice(productLinks, myDB);
                // } catch (IOException e) {
                // e.printStackTrace();
                //}

                //calculateAlcoholDollarRatio(SQL);


                // ATTENTION: This was auto-generated to implement the App Indexing API.
                // See https://g.co/AppIndexing/AndroidStudio for more information.
                //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
            }


        });
    }
}
