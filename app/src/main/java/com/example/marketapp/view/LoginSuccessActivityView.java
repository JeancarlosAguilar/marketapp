package com.example.marketapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.interactor.LoginSuccessInteractor;
import com.example.marketapp.presenter.LoginSuccessPresenter;
import com.example.marketapp.R;
import com.example.marketapp.databinding.ActivityLoginSuccessViewBinding;

public class LoginSuccessActivityView extends AppCompatActivity implements LoginSuccessInteractor.View {

    private ActivityLoginSuccessViewBinding binding;
    private LoginSuccessInteractor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success_view);

        binding = ActivityLoginSuccessViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new LoginSuccessPresenter(this);

        btn_ls_backtohome();
    }

    public void btn_ls_backtohome() {
        binding.btnLsBackothome.setOnClickListener(view -> {
            Context context = LoginSuccessActivityView.this;
            presenter.pasarDatos(context);
        });
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        startActivity(intent);
        finish();
    }
}