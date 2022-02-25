package com.mijale.adaapp.Fragments;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.mijale.adaapp.LoginActivity;
import com.mijale.adaapp.MainActivity;
import com.mijale.adaapp.R;
import com.mijale.adaapp.RegisterActivity;


public class SettingsFragment extends Fragment {

    private Button logOut, aboutUs, feedback, links, contacto;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        logOut = view.findViewById(R.id.logOut);
        aboutUs = view.findViewById(R.id.aboutUs);
        feedback = view.findViewById(R.id.feedback);
        links = view.findViewById(R.id.links);
        contacto = view.findViewById(R.id.contacto);

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog d = new AlertDialog.Builder(getActivity())
                        .setTitle("Sobre nosotros.")
                        .setMessage("ADA es una app creada por 3 alumnos del instituto Juan de la Cierva para la asignatura Desarollo de Interfaces.\n" +
                                "Nuestra intencion con esta app es poder ayudar a que el mundo de la informatica sea mas igualitario.\n" +
                                "La informatica no es solo cosa de hombres.\n" +
                                "\n\nHecha por Miguel Barriga, Alejandro Gonzalez y Jack Sierralta\n" +
                                "Ernesto we love u <3")
                        .create();

                d.show();
            }
        });

        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SpannableString s = new SpannableString(" Diana Aceves: \n https://twitter.com/diana_aceves_ \n\n" +
                        " Ladybenko: \n  https://twitter.com/ladybenko \n\n" +
                        " Evabelmonte \n https://twitter.com/evabelmonte \n\n" +
                        " N03m1ms \n https://twitter.com/n03m1ms \n\n" +
                        " B0rk \n https://twitter.com/b0rk \n\n" +
                        "Manuelabat \n https://twitter.com/manuelabat \n\n" +
                        " Luterceiro \n https://twitter.com/luterceiro \n\n" +
                        " Cristinafsanz \n https://twitter.com/cristinafsanz \n\n" +
                        " Micro machismos \n  https://elpais.com/elpais/2019/03/04/icon/1551724415_734886.html \n\n"
                );
                Linkify.addLinks(s, Linkify.ALL);

                final AlertDialog d = new AlertDialog.Builder(getActivity())
                        .setTitle("Nuestras referentes")
                        .setMessage(s)
                        .create();

                d.show();


                ((TextView) d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
            }
        });


        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "flase");
                editor.apply();

                Intent logOut = new Intent(getActivity(), LoginActivity.class);
                startActivity(logOut);
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:adaappdi@gmail.com")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Informe error");
                startActivity(intent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getActivity().getPackageName())));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }
            }
        });


        return view;
    }

}