package com.example.tp1moviles;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class MainActivityViewModel extends AndroidViewModel {


    private Context context;

    private MutableLiveData<Double> Resultado;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Double> getResultado() {
        if (Resultado == null) {
            this.Resultado = new MutableLiveData<>();
        }
        return Resultado;
    }
    
    

    public void convertir(String monDolar , String monEuro){
        if(monDolar.length()>0){
            Resultado.setValue(Double.parseDouble(monDolar) * 0.92);
        }else if(monEuro.length()>0){
            Resultado.setValue(Double.parseDouble(monEuro) * 1.08);
        }else{
            Toast.makeText(context,"ingrese un valor", Toast.LENGTH_LONG).show();
        }
    }
     }

  
