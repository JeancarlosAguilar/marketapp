package com.example.marketapp.model;

import android.content.Context;
import android.content.Intent;

import com.example.marketapp.R;
import com.example.marketapp.SignInActivityView;
import com.example.marketapp.interactor.SignUp2Interactor;
import com.example.marketapp.data.AdminSQLiteOpenHelper;

public class SignUp2Model implements SignUp2Interactor.Model {

    private SignUp2Interactor.Presenter presenter;
    private AdminSQLiteOpenHelper myDB;


    public SignUp2Model(SignUp2Interactor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarSignUp2(Context context, String email, String password, String firstname, String lastname, String phonenumber, String address) {
        myDB = new AdminSQLiteOpenHelper(context);

        if (firstname.equals("") || lastname.equals("") || phonenumber.equals("") || address.equals("")) {
            presenter.alerta(context.getString(R.string.alert_empty_fields));
        } else {

            boolean checkRegUser = myDB.checkRegUser(email);
            if (checkRegUser) {
                presenter.alerta(context.getString(R.string.alert_user_exist));
            } else {
                myDB.regUser(email, password, firstname, lastname, phonenumber, address);

                Intent intent = new Intent(context, SignInActivityView.class);
                presenter.cambiarPantalla(intent);
                presenter.alerta(context.getString(R.string.alert_user_successfully_registed));
            }

        }
    }
}
