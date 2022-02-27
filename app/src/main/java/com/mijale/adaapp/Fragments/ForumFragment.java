package com.mijale.adaapp.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mijale.adaapp.R;

import java.util.ArrayList;
import java.util.Map;


public class ForumFragment extends Fragment {

    private DatabaseReference postDatabase;
    //private DatabaseReference userDatabase;
    AdapterListas adapterListas;
    private RecyclerView recyclerViewPersonas;
    ArrayList<Post> listaPersonas = new ArrayList<>();
    ;

    String mProfileImageUrl;
    ProgressDialog progressDialog;
    String user = null, message = null;

    public ForumFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        postDatabase = FirebaseDatabase.getInstance("https://adaapp-f73d9-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Messages");
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        recyclerViewPersonas = view.findViewById(R.id.recyclerPost);
        mostrarData();
        cargarLista();
        dialogoProgreso();
        return view;
    }

    private void cargarLista() {
        listaPersonas.clear();
        postDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                allListData(dataSnapshot);
                adapterListas.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    @SuppressLint("NewApi")
    public void allListData(final DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {

            Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
            if (map.get("useruid") != null) {
                user = map.get("useruid").toString();
            }
            if (map.get("message") != null) {
                message = map.get("message").toString();
            }
            if (map.get("image") != null) {
                mProfileImageUrl = map.get("image").toString();
            }
        }

        progressDialog.dismiss();

        listaPersonas.add(new Post(user, message, mProfileImageUrl));
    }

    public void mostrarData() {
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListas = new AdapterListas(getContext(), listaPersonas);
        recyclerViewPersonas.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPersonas.setAdapter(adapterListas);
    }

    public void dialogoProgreso() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

}
