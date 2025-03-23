package com.fjlr.lista.modelo

class PersonasRepository {
    companion object {
        val listaPeronas = listOf(
            Persona("123456", "anselmo", "julio", "https://robohash.org/anselmo"),
            Persona("234567", "maria", "soledad", "https://robohash.org/maria"),
            Persona("345678", "pedro", "alejandro", "https://robohash.org/pedro"),
            Persona("456789", "camila", "fernanda", "https://robohash.org/camila"),
            Persona("567890", "juan", "manuel", "https://robohash.org/juan"),
            Persona("678901", "isabel", "margarita", "https://robohash.org/isabel"),
            Persona("789012", "roberto", "carlos", "https://robohash.org/roberto"),
            Persona("890123", "laura", "cristina", "https://robohash.org/laura"),
            Persona("901234", "santiago", "ignacio", "https://robohash.org/santiago"),
            Persona("012345", "valentina", "lucía", "https://robohash.org/valentina")
        )

        fun getPersonaByDni(dni: String): Persona? = listaPeronas.find { it.dni == dni}
    }

}