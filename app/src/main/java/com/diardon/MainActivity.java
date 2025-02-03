package com.diardon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity
{
    private UserViewModel userViewModel;
    private TextView textViewName, textViewAge;
    private Button butLoadUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        textViewName = findViewById(R.id.textName);
        textViewAge = findViewById(R.id.textAge);
        butLoadUserData = findViewById(R.id.butLoad);

        // Obtener ViewModel
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Observar cambios en LiveData
        userViewModel.getUser().observe(this, new Observer<User>()
        {
            @Override
            public void onChanged(User usuario)
            {
                textViewName.setText(usuario.getName());
                textViewAge.setText(String.valueOf(usuario.getAge()));
            }
        });

        // Evento del botón para cargar datos
        butLoadUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.cargarUsuario();
            }
        });
    }
}
