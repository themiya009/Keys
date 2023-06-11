package com.erendev.keys;

import static io.realm.Realm.getApplicationContext;
import static io.realm.Realm.init;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class Search extends Fragment {


    EditText editText;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);



        button =  view.findViewById(R.id.searchBtn);
        editText = view.findViewById(R.id.searchTxt);

        String searchID = editText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchView.class);
                intent.putExtra("searchKey", editText.getText().toString());
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        return view;

    }
}