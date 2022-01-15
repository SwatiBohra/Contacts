package com.example.contacts.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts.Model.Contact;
import com.example.contacts.R;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

    private Context mContext;
    private List<Contact> mContact;

    public myAdapter(Context mContext, List<Contact> mContact){
        this.mContact = mContact;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.singlerow,parent,false);
        return new myAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContact.get(position);
        holder.name.setText(contact.getName());
        holder.pNumber.setText(contact.getNumber());
        holder.profile_image.setImageResource(R.mipmap.display);


    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name,pNumber;
        public ImageView profile_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.text_name);
            pNumber = itemView.findViewById(R.id.text_num);
            profile_image = itemView.findViewById(R.id.img1);
        }
    }
}


