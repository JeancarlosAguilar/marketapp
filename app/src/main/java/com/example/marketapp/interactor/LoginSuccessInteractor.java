package com.example.marketapp.interactor;

import android.content.Context;
import android.content.Intent;

public interface LoginSuccessInteractor {

    interface View {
        void cambiarPantalla(Intent intent);
    }

    interface Presenter {
        void pasarDatos(Context context);

        void cambiarPantalla(Intent intent);
    }

    interface Model {
        void validarLoginSuccess(Context context);
    }

}
