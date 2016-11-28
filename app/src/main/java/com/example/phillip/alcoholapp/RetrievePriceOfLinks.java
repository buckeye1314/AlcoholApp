package com.example.phillip.alcoholapp;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;


import android.app.ProgressDialog;
import android.text.Html;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Phillip on 6/6/2016.
 */
public class RetrievePriceOfLinks extends AsyncTask<String , Integer,String[]> {

    Map<String, Double> listOfProducts2 = new TreeMap<String, Double>();
    ProgressDialog progressDialog;
    Context context;
    TextView textView;
    int MaxUrl = 100;
    String[] links;
    AlcoholActivity database = new AlcoholActivity();

    String[] HtmlOfLinks;




    RetrievePriceOfLinks(Context context)
    {
        this.context = context;


    }

    protected String[] doInBackground(String... params) {
        links=params;
        MaxUrl = params.length;
        HtmlOfLinks = new String[params.length];

        for(int i =0;i<params.length;i++)
        {
            Document doc = null;
            try {
                doc = Jsoup.connect(params[i]).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            HtmlOfLinks[i] = doc.select("script").html();

            publishProgress(i+1);
        }



        return HtmlOfLinks;

    }

    @Override
    protected void onPreExecute() {
        progressDialog =new ProgressDialog(context);
        progressDialog.setTitle("Updating Database...");

        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        progressDialog.setMax(MaxUrl);
        progressDialog.setProgress(progress);


    }


    protected void onPostExecute(String[] result) {
        for(int i =0;i<links.length;i++)
        {
            listOfProducts2.put(links[i],AlcoholActivity.getPrice(HtmlOfLinks[i]));
        }
        AlcoholActivity.listOfProducts = listOfProducts2;
        System.out.println(AlcoholActivity.listOfProducts.toString());

        progressDialog.hide();

        try {
            AlcoholActivity.updateSQLPrice(AlcoholActivity.listOfProducts,AlcoholActivity.tempDatabase,AlcoholActivity.tempLinks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] alcoholContentAndPrice = {"'Alcohol Content'","PRICE"};
        String[] ratio = {"'Alcohol(Fluid oz)/Dollar($)'"};



        Cursor DatabaseCursor = AlcoholActivity.tempDatabase.query("Beer",null,null,null,null,null,null);

        AlcoholActivity.calculateAlcoholDollarRatio(DatabaseCursor,AlcoholActivity.tempDatabase);
        AlcoholActivity.RatioCursor = AlcoholActivity.tempDatabase.query("Beer",null,null,null,null,null,"`Alcohol(Fluid oz)/Dollar($)` DESC");
        AlcoholActivity.cursorAdapter.changeCursor(AlcoholActivity.RatioCursor);

        AlcoholActivity.listView1.setAdapter(AlcoholActivity.cursorAdapter);









    }

}


