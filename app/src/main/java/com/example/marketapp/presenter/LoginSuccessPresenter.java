package com.example.marketapp.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.interactor.LoginSuccessInteractor;
import com.example.marketapp.model.LoginSuccessModel;

public class LoginSuccessPresenter implements LoginSuccessInteractor.Presenter {

    private LoginSuccessInteractor.View view;
    private LoginSuccessInteractor.Model model;

    public LoginSuccessPresenter(LoginSuccessInteractor.View view) {
        this.view = view;
        model = new LoginSuccessModel(this);
    }

    @Override
    public void pasarDatos(Context context) {
        if (view != null) {
            model.validarLoginSuccess(context);
        }
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        if (view != null) {
            view.cambiarPantalla(intent);
        }
    }
}
