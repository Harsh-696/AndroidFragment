package com.example.fragment_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginRegister extends Fragment {

    EditText edt1, edt2, edt3;
    TextView txt1, txt2, txt3, heading;
    Button register, display;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username = "userKey";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedPreferences;
    boolean result = false;

    public LoginRegister() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this

        View view = inflater.inflate(R.layout.fragment_login_register, container, false);

        edt1 = view.findViewById(R.id.userName);
        edt2 = view.findViewById(R.id.email);
        edt3 = view.findViewById(R.id.pass);

        txt1 = view.findViewById(R.id.display_username);
        txt2 = view.findViewById(R.id.display_email);
        txt3 = view.findViewById(R.id.display_password);
        heading = view.findViewById(R.id.heading);

        register = view.findViewById(R.id.btn);
        display = view.findViewById(R.id.display_data);

        edt1.setVisibility(View.VISIBLE);
        edt2.setVisibility(View.VISIBLE);
        edt3.setVisibility(View.VISIBLE);
        register.setVisibility(View.VISIBLE);
        display.setVisibility(View.GONE);

        sharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){

                    String name = edt1.getText().toString();
                    String email = edt2.getText().toString();
                    String password = edt3.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(Username, name);
                    editor.putString(Email, email);
                    editor.putString(Password, password);
                    editor.commit();
                    Toast.makeText(getContext(), "Arigato", Toast.LENGTH_SHORT).show();
                    edt1.setVisibility(View.GONE);
                    edt2.setVisibility(View.GONE);
                    edt3.setVisibility(View.GONE);
                    register.setVisibility(View.GONE);
                    display.setVisibility(View.VISIBLE);
                    heading.setVisibility(View.GONE);
                }
            }

            private boolean validation() {

                String name = edt1.getText().toString();
                String email = edt2.getText().toString();
                String password = edt3.getText().toString();

                if(name.matches("")){
                    edt1.setError("This Field is required");
                }
                else if(email.matches("")){
                    edt1.setText(name);
                    edt2.setError("This Field is required");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    edt2.setError("Invalid Email Id");
                }
                else if(password.matches("")){
                    edt2.setText(email);
                    edt3.setError("This field is required");
                }
                else {
                    edt3.setText(password);
                    result = true;
                }

                return result;
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = sharedPreferences.getString(Username, "No Value");
                String email = sharedPreferences.getString(Email, "No Value");
                String password = sharedPreferences.getString(Password, "No Value");

                txt1.setText(username);
                txt2.setText(email);
                txt3.setText(password);

                display.setVisibility(View.GONE);
            }
        });




        return view;
    }
}