package com.challeng.libreria.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);


}
