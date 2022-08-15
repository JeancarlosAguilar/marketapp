package com.example.marketapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marketapp.R;
import com.example.marketapp.interactor.SignUp1Interactor;
import com.example.marketapp.presenter.SignUp1Presenter;
import com.example.marketapp.databinding.ActivitySignUp1ViewBinding;

public class SignUp1ActivityView extends AppCompatActivity implements SignUp1Interactor.View {

    private ActivitySignUp1ViewBinding binding;
    private SignUp1Interactor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1_view);

        binding = ActivitySignUp1ViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new SignUp1Presenter(this);

        btn_back();
        btn_continue();
    }

    private void btn_continue() {
        binding.btnSignup1Continue.setOnClickListener(view -> {
            Context context = SignUp1ActivityView.this;
            String email = binding.etSignup1Email.getText().toString();
            String password = binding.etSignup1Password.getText().toString();
            String confirmpassword = binding.etSignup1Confirmpassword.getText().toString();
            presenter.pasarDatos(context, email, password, confirmpassword);

        });
    }

    private void btn_back() {
        binding.imgSignup1Back.setOnClickListener(view -> finish());
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


}