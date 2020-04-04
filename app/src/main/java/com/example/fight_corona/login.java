package com.example.fight_corona;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity

{
    RequestQueue requestQueue;
    EditText email,password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

// Start the queue
        requestQueue.start();
        setSupportActionBar(toolbar);

    }

    public void login(View v) {
        String e = email.getText().toString().trim();
        String p = password.getText().toString().trim();
        if (e.equals("rathod") && p.equals("rathod"))
        {
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
           startActivity(i);

        }
        else if(p.equals("")||e.equals(""))
        {
            Toast.makeText(getApplicationContext(),"FILL ALL DETAILS",Toast.LENGTH_LONG).show();
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
            final String url1 = "http://34.251.48.235:3000/signin";

            JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST, url1, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String res=response.getString("Success");
                                if(res.equals("Loged in successfully"))
                                {
                                    Intent i=new Intent(getApplicationContext(),policemain.class);
                                    startActivity(i);
                                }
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }





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


    public void signup(View v)
    {
        Intent i=new Intent(login.this,register.class);
        startActivity(i);

    }
    public void loginpp(View v)
    {

        Intent i=new Intent(login.this,police.class);
        startActivity(i);

    }

}
