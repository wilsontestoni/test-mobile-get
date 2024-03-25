package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class GetCursos1 extends AppCompatActivity {

    RequestQueue filaRequest;

    List<Curso> cursos = new ArrayList<>();
    //String baseURL = "http://localhost:3000/";
    //String path = "cursos/informatica";
    String finalURL = "http://10.0.2.2:3000/cursos/todos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_cursos1);
        filaRequest = Volley.newRequestQueue(this);
        getData();
    }
    public void getData() {
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, finalURL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject cursoJson = response.getJSONObject(i);
                                    Curso curso = new Curso();
                                    curso.setId(cursoJson.getInt("id"));
                                    curso.setTitle(cursoJson.getString("title"));
                                    curso.setCategory(cursoJson.getString("category"));
                                    curso.setImg(cursoJson.getString("img"));
                                    curso.setDescription(cursoJson.getString("description"));
                                    curso.setAddress(cursoJson.getString("address"));
                                    curso.setTitle(cursoJson.getString("title"));
                                    curso.setOccupiedSlots(cursoJson.getInt("occupiedSlots"));
                                    curso.setMaxCapacity(cursoJson.getInt("maxCapacity"));
                                    cursos.add(curso);
                                    //Log.d("GetCursos1", "Curso recebido: " + curso.toString());
                                } catch (JSONException e) {
                                    Log.e("Volley", "Erro no JSON");
                                    //System.out.println("Erro no JSON");
                                }

                            }
                            RecyclerView recyclerView = findViewById(R.id.recyclerView);
                            recyclerView.setLayoutManager(new LinearLayoutManager(GetCursos1.this));
                            CursoAdapter adapter = new CursoAdapter(GetCursos1.this, cursos);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.d("Data","Sem Dados");
                            //System.out.println("Sem Dados");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                        //System.out.println(error.toString());
                    }
                });
        filaRequest.add(arrReq);
    }
}
