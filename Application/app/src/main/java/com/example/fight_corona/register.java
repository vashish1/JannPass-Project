package com.example.fight_corona;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity
{


    EditText em,an,pw,dd,mm,yy;
    RequestQueue requestQueue;
    Button regis;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        em=(EditText) findViewById(R.id.email);
        an=(EditText) findViewById(R.id.aadharn);
        pw=(EditText) findViewById(R.id.password);
        dd=(EditText) findViewById(R.id.dd);

        mm=(EditText) findViewById(R.id.mm);
        yy=(EditText) findViewById(R.id.yy);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        regis=(Button) findViewById(R.id.btn);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(v);
            }
        });

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);



    }
    public void register(View v)
    {
        String email,pass,ano,d,m,y;
        email=em.getText().toString().trim();
        pass=pw.getText().toString().trim();
        ano=an.getText().toString().trim();
        m=mm.getText().toString().trim();
        y=yy.getText().toString().trim();
        d=dd.getText().toString().trim();

        if(email.equals("")||pass.equals("")||ano.equals("")||m.equals("")||y.equals("")||d.equals(""))
        {
            Toast.makeText(getApplicationContext(),"ALL FIELDS ARE COMPULSARY",Toast.LENGTH_LONG).show();
        }
        else
        {



            RequestQueue queue = Volley.newRequestQueue(this);

            final JSONObject jsonObject = new JSONObject();
            try {
               // jsonObject.put("", e);
                jsonObject.put("name", "12345678");
                jsonObject.put("aadhar", "11-13");
                jsonObject.put("email", "54terw2wi");
                jsonObject.put("time", "342");
                jsonObject.put("password", "Jaipur");
            } catch (JSONException ex) {
                // handle exception
            }
            final String url1 = "http://34.251.48.235:3000/signup";

            JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST, url1, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String res;

                            Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_LONG).show();



                            // Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }


            ) {

                @Override
                protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                    try {
                        String jsonString = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));

                        JSONObject result = null;

                        if (jsonString != null && jsonString.length() > 0)
                            result = new JSONObject(jsonString);

                        return Response.success(result,
                                HttpHeaderParser.parseCacheHeaders(response));
                    } catch (UnsupportedEncodingException e) {
                        return Response.error(new ParseError(e));
                    } catch (JSONException je) {
                        return Response.error(new ParseError(je));
                    }
                }


                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("Accept", "application/json");
                    return headers;
                }


                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public byte[] getBody() {

                    try {
                        Log.i("json", jsonObject.toString());
                        return jsonObject.toString().getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };

            queue.add(putRequest);









        }

    }

}
