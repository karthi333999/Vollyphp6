package com.example.vollyphp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;

    String loginurl="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.edittext1);
        ed2=findViewById(R.id.edittext2);
        b1=findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

StringRequest stringRequest=new StringRequest(Request.Method.POST, loginurl,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonArray=new JSONArray(response);
                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                    String code=jsonObject.getString("code");

                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(MainActivity.this,"Error...",Toast.LENGTH_LONG).show();
        error.printStackTrace();

    }
})

{
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        Map<String,String> params=new HashMap<String, String>();
        params.put();

        return super.getParams();
    }
};

MySingleton.getInstance(MainActivity.this).addToRequestque(stringRequest);



            }
        });

    }
}