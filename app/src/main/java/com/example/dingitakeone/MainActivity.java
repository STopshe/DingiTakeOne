package com.example.dingitakeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<PlaceItem> placeList;
    public List<Result> info;
    private TextView textViewError;
    private AutoCompleteTextView autoTextView;
    private String placeSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        textViewError = findViewById(R.id.errorText);
        autoTextView = findViewById(R.id.autotext);


        autoTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    placeSearch= autoTextView.getText().toString();
                    onCall();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });







    }

    private void onCall() {
        //api client
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.dingi.live/maps/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<Data> call;
        call = api.getData(""+placeSearch, "en");

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                Log.d("blahhjhgu", "onResponse: "+response.body());
                if(!response.isSuccessful()){
                    textViewError.setText("Code: "+response.code());
                    return;
                }

                Data datas = response.body();
                placeList = new ArrayList<>();
                info = datas.getResult();

                for(int i=0; 1<info.size(); i++){
                    PlaceItem placeItem = new PlaceItem(
                            ""+info.get(i).getName(),
                            ""+datas.getAddress()

                    );
                    placeList.add(placeItem);
                }

                AutoCompleteTextView editText = findViewById(R.id.autotext);
                AutoCompleteAdapter adapter = new AutoCompleteAdapter(MainActivity.this, placeList);
                editText.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                textViewError.setText(t.getMessage());

            }
        });

    }






}
