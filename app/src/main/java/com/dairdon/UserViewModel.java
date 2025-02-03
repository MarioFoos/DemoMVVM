package com.dairdon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel
{
    private final MutableLiveData<User> user = new MutableLiveData<>();

    public LiveData<User> getUser()
    {
        return user;
    }
    public void cargarUsuario()
    {
        // Simulamos la carga de datos, podría ser desde una API o BD
        user.setValue(new User("Juan Pérez", 25));
    }
}
