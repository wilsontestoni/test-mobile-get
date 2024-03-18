package com.example.myapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.time.Instant;
import java.util.List;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder> {

    private List<Curso> cursos;

    public CursoAdapter(List<Curso> cursos) {
        this.cursos = cursos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_course, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Curso curso = cursos.get(position);

        String baseUrl = "http://10.0.2.2:3000";
        String imagePath = curso.getImg();
        String imageUrl = baseUrl + imagePath;

        // Use a referência do ImageView do ViewHolder para carregar a imagem
        Picasso.get().load(imageUrl).into(holder.courseImg);

        holder.courseTitle.setText(curso.getTitle());
        holder.courseCategory.setText("Categoria: " + curso.getCategory());
        holder.courseAddress.setText("Endereço: " + curso.getAddress());
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView courseImg;
        TextView courseTitle;
        TextView courseCategory;
        TextView courseAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImg = itemView.findViewById(R.id.courseImg);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseCategory = itemView.findViewById(R.id.courseCategory);
            courseAddress = itemView.findViewById(R.id.courseAddress);
        }
    }
}
