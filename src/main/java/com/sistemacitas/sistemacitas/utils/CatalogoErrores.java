package com.sistemacitas.sistemacitas.utils;

import lombok.Getter;

@Getter
public enum CatalogoErrores {

    // Se crean los mensajes de error para dentsita
    DENTISTA_NO_ENCONTRADO("001", "Dentista no encontrado"),
    DENTISTA_NO_DISPONIBLE("004", "Dentista no disponible"),
    DENTISTA_YA_EXISTE("005", "Dentista ya existe"),
    DENTISTA_NO_ACTUALIZADO("007", "Dentista no actualizado"),
    DENTISTA_NO_ELIMINADO("009", "Dentista no eliminado"),
    DENTISTA_INVALIDO("010", "Dentista inválido"),
    // Se crean los mensajes de error para paciente
    PACIENTE_NO_ENCONTRADO("011", "Paciente no encontrado"),
    PACIENTE_NO_DISPONIBLE("012", "Paciente no disponible"),
    PACIENTE_YA_EXISTE("013", "Paciente ya existe"),
    PACIENTE_NO_ACTUALIZADO("014", "Paciente no actualizado"),
    PACIENTE_NO_ELIMINADO("015", "Paciente no eliminado"),
    PACIENTE_INVALIDO("016", "Paciente inválido"),
    // Se crean los mensajes de error para cita
    CITA_NO_ENCONTRADA("002", "Cita no encontrada"),
    CITA_NO_DISPONIBLE("003", "Cita no disponible"),
    CITA_YA_EXISTE("006", "Cita ya existe"),
    CITA_NO_ACTUALIZADA("008", "Cita no actualizada"),
    CITA_NO_ELIMINADA("017", "Cita no eliminada"),
    CITA_INVALIDA("018", "Cita inválida"),
    // Se crea un mensaje de error doctor
    DOCTOR_NO_ENCONTRADO("019", "Doctor no encontrado"),
    DOCTOR_NO_DISPONIBLE("020", "Doctor no disponible"),
    DOCTOR_YA_EXISTE("021", "Doctor ya existe"),
    DOCTOR_NO_ACTUALIZADO("022", "Doctor no actualizado"),
    DOCTOR_NO_ELIMINADO("023", "Doctor no eliminado"),
    DOCTOR_INVALIDO("024", "Doctor inválido"),
    // Se crea un mensaje de error para especialidad
    ESPECIALIDAD_NO_ENCONTRADA("025", "Especialidad no encontrada"),
    ESPECIALIDAD_NO_DISPONIBLE("026", "Especialidad no disponible"),
    ESPECIALIDAD_YA_EXISTE("027", "Especialidad ya existe"),
    ESPECIALIDAD_NO_ACTUALIZADA("028", "Especialidad no actualizada"),
    ESPECIALIDAD_NO_ELIMINADA("029", "Especialidad no eliminada"),
    ESPECIALIDAD_INVALIDA("030", "Especialidad inválida"),

    ERROR_GENERICO("999", "Ha ocurrido un error inesperado");

    private final String codigo;
    private final String mensaje;

    CatalogoErrores(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
}
