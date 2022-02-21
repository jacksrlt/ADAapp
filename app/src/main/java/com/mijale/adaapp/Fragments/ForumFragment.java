package com.mijale.adaapp.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mijale.adaapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ForumFragment extends Fragment {

    private DatabaseReference postDatabase;

    AdapterListas adapterListas;
    private RecyclerView recyclerViewPersonas;
    ArrayList<Post> listaPersonas = new ArrayList<>();
    FirebaseFirestore userStore;

    String imageRef;
    ProgressDialog progressDialog;
    String userRef = null, message = null;

    public ForumFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        postDatabase = FirebaseDatabase.getInstance("https://adaapp-f73d9-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Messages");
        userStore = FirebaseFirestore.getInstance();
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
                userRef = map.get("useruid").toString();
            }
            if (map.get("message") != null) {
                message = map.get("message").toString();
            }
            if (map.get("image") != null) {
                imageRef = map.get("message").toString();;
            }
        }

        progressDialog.dismiss();

        listaPersonas.add(new Post(userRef, message, imageRef));
    }

    public void mostrarData() {
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListas = new AdapterListas(getContext(), listaPersonas);
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
