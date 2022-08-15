package com.example.marketapp.model;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.R;
import com.example.marketapp.interactor.SignUp1Interactor;
import com.example.marketapp.view.SignUp2ActivityView;

public class SignUp1Model implements SignUp1Interactor.Model {

    private SignUp1Interactor.Presenter presenter;

    public SignUp1Model(SignUp1Interactor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarSignUp1(Context context, String email, String password, String confirmpassword) {

        if (email.equals("") || password.equals("") || confirmpassword.equals("")) {
            presenter.alerta(context.getString(R.string.alert_empty_fields));
        } else {

            if (password.equals(confirmpassword)) {

                Intent intent = new Intent(context, SignUp2ActivityView.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                presenter.cambiarPantalla(intent);

            } else {
                presenter.alerta(context.getString(R.string.alert_password));
            }

        }

    }

}
