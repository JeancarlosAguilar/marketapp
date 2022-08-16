package com.example.marketapp.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.interactor.SignInInteractor;
import com.example.marketapp.model.SignInModel;

public class SignInPresenter implements SignInInteractor.Presenter {

    private SignInInteractor.View view;
    private SignInInteractor.Model model;

    public SignInPresenter(SignInInteractor.View view) {
        this.view = view;
        model = new SignInModel(this);
    }

    @Override
    public void pasardatos(Context context, String email, String password) {
        model.validarSignIn(context, email, password);
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        view.cambiarPantalla(intent);
    }

    @Override
    public void alerta(String msg) {
        view.mostrarAlerta(msg);
    }
}
