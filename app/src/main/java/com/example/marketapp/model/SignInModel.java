package com.example.marketapp.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.marketapp.LoginSuccessActivityView;
import com.example.marketapp.R;
import com.example.marketapp.interactor.SignInInteractor;
import com.example.marketapp.data.AdminSQLiteOpenHelper;

public class SignInModel implements SignInInteractor.Model {

    private SignInInteractor.Presenter presenter;
    private AdminSQLiteOpenHelper myDB;


    public SignInModel(SignInInteractor.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarSignIn(Context context, String email, String password) {
        myDB = new AdminSQLiteOpenHelper(context);
        if (email.equals("") || password.equals("")) {
            presenter.alerta(context.getString(R.string.alert_empty_fields));
        } else {
            boolean checkUserLogin = myDB.checkUserLogin(email, password);
            if (checkUserLogin) {

                guardarIdUser(context, email); // guardamos id del usuario registrado para usarlo dentro del sistema
                Intent intent = new Intent(context, LoginSuccessActivityView.class);
                presenter.cambiarPantalla(intent);

            } else {
                presenter.alerta(context.getString(R.string.alert_user_invalid_data));
            }
        }
    }

    public void guardarIdUser(Context context, String email) {
        SQLiteDatabase db = myDB.getReadableDatabase();
        String[] parametros = {email};
        String[] campo = {"ID"};

        Cursor cursor = db.query("USER_DATA", campo, "EMAIL" + "=?", parametros, null, null, null);
        cursor.moveToFirst();
        String id_usuario = (cursor.getString(0));
        cursor.close();

        SharedPreferences preferences = context.getSharedPreferences("USUARIO", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id_usuario", id_usuario);
        editor.apply();
    }

}
