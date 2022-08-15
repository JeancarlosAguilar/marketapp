package com.example.marketapp.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.interactor.SignUp1Interactor;
import com.example.marketapp.model.SignUp1Model;

public class SignUp1Presenter implements SignUp1Interactor.Presenter {

    private SignUp1Interactor.View view;
    private SignUp1Interactor.Model model;

    public SignUp1Presenter(SignUp1Interactor.View view) {
        this.view = view;
        model = new SignUp1Model(this);
    }

    @Override
    public void pasarDatos(Context context, String email, String password, String confirmpassword) {
        if (view != null) {
            model.validarSignUp1(context, email, password, confirmpassword);
        }
    }

    @Override
    public void cambiarPantalla(Intent intent) {
        if (view != null) {
            view.cambiarPantalla(intent);
        }
    }

    @Override
    public void alerta(String msg) {
        view.mostrarAlerta(msg);
    }

}
