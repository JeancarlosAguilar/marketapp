package com.example.marketapp.interactor;

import android.content.Context;
import android.content.Intent;

public interface SignUp2Interactor {

    interface View {
        //SALIDA
        void cambiarPantalla(Intent intent);

        void mostrarAlerta(String error);
    }

    interface Presenter {

        //ENTRADA
        void pasardatos(Context context, String email, String password, String firstname, String lastname, String phonenumber, String address);

        //SALIDA
        void cambiarPantalla(Intent intent);

        void alerta(String msg);
    }

    interface Model {
        //LOGICA
        void validarSignUp2(Context context, String email, String password, String firstname, String lastname, String phonenumber, String address);
    }

}
