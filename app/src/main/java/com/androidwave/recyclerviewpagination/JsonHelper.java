package com.androidwave.recyclerviewpagination;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class JsonHelper {




    private ArrayList<PostItem> stockArrayList = new ArrayList<PostItem>();
    private PostItem stock;





    public ArrayList<PostItem> parseStockList(String rawLeadListResponse) {
        // TODO Auto-generated method stub
        Log.d("scheduleListResponse", rawLeadListResponse);
        try {
            JSONObject jsonObject = new JSONObject(rawLeadListResponse);

            if (!jsonObject.isNull("results")) {
                JSONArray leadJsonObj = jsonObject.getJSONArray("results");

                for (int i = 0; i < leadJsonObj.length(); i++) {
                    stock = new PostItem();
                    String sequence = String.format("%03d", i + 1);
                    JSONObject json_data = leadJsonObj.getJSONObject(i);
                    stock.setDescription(json_data.getString("item_Name"));
                    stockArrayList.add(stock);
                }
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stockArrayList;
    }


}
