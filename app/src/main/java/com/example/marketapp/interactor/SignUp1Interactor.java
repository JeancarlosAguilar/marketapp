package com.example.marketapp.interactor;

import android.content.Context;
import android.content.Intent;

public interface SignUp1Interactor {

    interface View {
        void cambiarPantalla(Intent intent);

        void mostrarError(String error);
    }

    interface Presenter {
        void pasarDatos(Context context, String email, String password, String confirmpassword);

        void cambiarPantalla(Intent intent);

        void errorPassword(String error);
    }

    interface Model {
        void validarSignUp1(Context context, String email, String password, String confirmpassword);
    }

}
