package com.example.marketapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.marketapp.R;
import com.example.marketapp.interactor.SignInInteractor;
import com.example.marketapp.presenter.SignInPresenter;
import com.example.marketapp.databinding.ActivitySignInViewBinding;

public class SignInActivityView extends AppCompatActivity implements SignInInteractor.View {

    private ActivitySignInViewBinding binding;
    private SignInInteractor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_view);

        binding = ActivitySignInViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new SignInPresenter(this);

        btn_signup();
        btn_continue();
    }

    private void btn_continue() {
        binding.btnSignup1Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = SignInActivityView.this;
                String email = binding.etSigninEmail.getText().toString();
                String password = binding.etSigninPassword.getText().toString();
                presenter.pasardatos(context, email, password);
            }
        });
    }

    private void btn_signup() {
        binding.tvSigninMsg6.setOnClickListener(view -> {
            Intent intent = new Intent(SignInActivityView.this, SignUp1ActivityView.class);
            startActivity(intent);
        });
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