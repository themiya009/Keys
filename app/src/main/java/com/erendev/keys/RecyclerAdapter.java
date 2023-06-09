package com.erendev.keys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.pwdViewholder> {

    Context context;
    RealmResults<PasswordModel> passwdlist;

    public RecyclerAdapter(Context context, RealmResults<PasswordModel> passwdlist) {
        this.context = context;
        this.passwdlist = passwdlist;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public pwdViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new pwdViewholder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull pwdViewholder holder, int position) {
        PasswordModel pwd = passwdlist.get(position);
        holder.pNameout.setText(pwd.getpName());
        holder.usrPwdout.setText(pwd.getUsrPwd());
        holder.usrDescout.setText(pwd.getUsrDesc());
    }

    @Override
    public int getItemCount() {
        return passwdlist.size();
    }

    public class pwdViewholder extends RecyclerView.ViewHolder{

        TextView pNameout , usrPwdout, usrDescout;

        public pwdViewholder(@NonNull View itemView) {
            super(itemView);

            pNameout = itemView.findViewById(R.id.pname);
            usrPwdout = itemView.findViewById(R.id.pwdname);
            usrDescout = itemView.findViewById(R.id.descpt);
        }
    }
}
