package com.example.tp1moviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tp1moviles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private com.example.tp1moviles.MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(com.example.tp1moviles.MainActivityViewModel.class);



    mv.getResultado().observe(this, new Observer<Double>() {
        @Override
        public void onChanged(Double aDouble) {
            binding.edResultado.setText(aDouble.toString());
        }
    });

    binding.rbDolarEuro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            binding.edDolar.setEnabled(true);
            binding.edEuro.setEnabled(false);
        }
    });

    binding.rbEuroDolar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            binding.edEuro.setEnabled(true);
            binding.edDolar.setEnabled(false);
        }
    });

    binding.btConvertir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mv.convertir(binding.edDolar.getText().toString(), binding.edEuro.getText().toString());
            binding.edDolar.setText("");
            binding.edEuro.setText("");
        }
    });

}



    }