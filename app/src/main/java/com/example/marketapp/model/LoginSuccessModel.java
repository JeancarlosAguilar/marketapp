package com.example.marketapp.model;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.interactor.LoginSuccessInteractor;
import com.example.marketapp.SystemIndexActivityView;


public class LoginSuccessModel implements LoginSuccessInteractor.Model {

    private LoginSuccessInteractor.Presenter presenter;

    public LoginSuccessModel(LoginSuccessInteractor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarLoginSuccess(Context context) {
        Intent intent = new Intent(context, SystemIndexActivityView.class);
        presenter.cambiarPantalla(intent);
    }
}
