package com.example.vasuchand.lbb_phonebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Vasu Chand on 5/3/2017.
 */

public class adapter  extends RecyclerView.Adapter<adapter.MyViewHolder> {
    private List<contacts_data> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView t1, t2;
        ImageView imageView;
        protected RecyclerView recycler_view_list;


        public MyViewHolder(View view) {
            super(view);
            t1 = (TextView)view.findViewById(R.id.user_name);
            t2 = (TextView)view.findViewById(R.id.tvPhoneNumber);
            imageView = (ImageView)view.findViewById(R.id.image);

        }


    }
    public adapter(Context context, List<contacts_data> moviesList)
    {
        this.moviesList = moviesList;
        this.mContext = context;
        //System.out.println(moviesList.size());

        //this.mImageLoader =i;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_contact, parent, false);


        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        contacts_data data = moviesList.get(position);
        holder.t1.setText(data.getName());
        holder.t2.setText(data.getNumber());
        Bitmap bitmap=null;
        try {
             bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(),data.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bitmap!=null) {
            holder.imageView.setImageBitmap(bitmap);
        }
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
