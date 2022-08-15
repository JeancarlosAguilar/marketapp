package com.example.marketapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marketapp.R;
import com.example.marketapp.interactor.SignUp2Interactor;
import com.example.marketapp.presenter.SignUp2Presenter;
import com.example.marketapp.databinding.ActivitySignUp2ViewBinding;

public class SignUp2ActivityView extends AppCompatActivity implements SignUp2Interactor.View {

    private ActivitySignUp2ViewBinding binding;
    private SignUp2Interactor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2_view);

        binding = ActivitySignUp2ViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new SignUp2Presenter(this);

        btn_back();
        btn_continue();
    }

    private void btn_continue() {
        binding.btnSignup2Continue.setOnClickListener(view -> {
            Bundle bundle = getIntent().getExtras();

            Context context = SignUp2ActivityView.this;
            String email = bundle.getString("email");
            String password = bundle.getString("password");
            String firstname = binding.etSignup2Firstname.getText().toString();
            String lastname = binding.etSignup2Lastname.getText().toString();
            String phonenumber = binding.etSignup2Phonenumber.getText().toString();
            String address = binding.etSignup2Address.getText().toString();
            presenter.pasardatos(context, email, password, firstname, lastname, phonenumber, address);
        });
    }

    private void btn_back() {
        binding.imgSignup2Back.setOnClickListener(view -> finish());
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        startActivity(intent);
        finish();
    }

    @Override
    public void mostrarAlerta(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}