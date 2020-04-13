package com.example.fight_corona;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class genpass extends Fragment {


    EditText aadar ,slot,m,d,y,ar;
    Button btn;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_genpass, container, false);
        aadar=(EditText) v.findViewById(R.id.aadharn);
        slot=(EditText) v.findViewById(R.id.tymslt);
        m=(EditText)v.findViewById(R.id.mm);
        d=(EditText)v.findViewById(R.id.dd);
        y=(EditText)v.findViewById(R.id.yy);
        ar=(EditText) v.findViewById(R.id.city);
        btn=(Button) v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genpas();
            }
        });


        return  v;

    }

    public  void genpas()
    {

        String an,slt,date,tym,area;

       date=d.getText().toString().trim()+"  "+m.getText().toString().trim()+" "+y.getText().toString().trim();
      an=aadar.getText().toString().trim();
       slt=slot.getText().toString().trim();
       tym=slt;
       area=ar.getText().toString().trim();

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("aadhar", an);
            jsonObject.put("slot", slt);
            jsonObject.put("date", date);
            jsonObject.put("time", tym);
            jsonObject.put("area", area);
        } catch (JSONException ex) {
            // handle exception
        }
        final String url1 = "http://34.251.48.235:3000/epass";
        JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST, url1, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String res;

                        Toast.makeText(getActivity(), "YES", Toast.LENGTH_LONG).show();


                        // finish();

                        // Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
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
                headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Inlhc2hpLmd1cHRheWFzaGkuZ3VwdGFAZ21haWwuY29tIiwibmFtZSI6InNoYW50YW51In0.j3Elrw9lzqhXJDnklam2CwEyCMmTliMxFYxAlwgBHUU");
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
