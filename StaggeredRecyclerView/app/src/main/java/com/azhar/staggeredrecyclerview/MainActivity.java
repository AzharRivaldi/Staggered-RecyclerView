package com.azhar.staggeredrecyclerview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Bitmap[] bitmaps = getBitmaps();
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(bitmaps);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(myRecyclerAdapter);

    }

    private Bitmap[] getBitmaps() {
        Bitmap[] tempBitmaps = new Bitmap[10];
        tempBitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.satu);
        tempBitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.lima);
        tempBitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.tiga);
        tempBitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.empat);
        tempBitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.dua);
        tempBitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.enam);
        tempBitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.tujuh);
        tempBitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.delapan);
        tempBitmaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.sembilan);
        tempBitmaps[9] = BitmapFactory.decodeResource(getResources(), R.drawable.sepuluh);
        return tempBitmaps;
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;

        public MyRecyclerAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @NonNull
        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.staggered_grid, parent, false);
            return new GridHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int position) {
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("Deskripsi " + position);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.desc);
        }
    }

}
