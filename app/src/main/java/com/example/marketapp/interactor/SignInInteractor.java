package com.example.marketapp.interactor;

import android.content.Context;
import android.content.Intent;

public interface SignInInteractor {

    interface View {
        //SALIDA
        void cambiarPantalla(Intent intent);

        void mostrarAlerta(String msg);
    }

    interface Presenter {
        //ENTRADA
        void pasardatos(Context context, String email, String password, boolean checket);

        //SALIDA
        void cambiarPantalla(Intent intent);

        void alerta(String msg);
    }

    interface Model {
        //LOGICA
        void validarSignIn(Context context, String email, String password, boolean checket);
    }

}
