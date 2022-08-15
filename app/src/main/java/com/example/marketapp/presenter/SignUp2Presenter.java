package com.example.marketapp.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.interactor.SignUp2Interactor;
import com.example.marketapp.model.SignUp2Model;


public class SignUp2Presenter implements SignUp2Interactor.Presenter {

    private SignUp2Interactor.View view;
    private SignUp2Interactor.Model model;

    public SignUp2Presenter(SignUp2Interactor.View view) {
        this.view = view;
        model = new SignUp2Model(this);
    }

    @Override
    public void pasardatos(Context context, String email, String password, String firstname, String lastname, String phonenumber, String address) {
        if (view != null) {
            model.validarSignUp2(context, email, password, firstname, lastname, phonenumber, address);
        }
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
