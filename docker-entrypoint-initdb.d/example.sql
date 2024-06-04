-- Crear la tabla 'estudiante'
CREATE TABLE estudiante (
                            cedula VARCHAR(255) PRIMARY KEY,
                            nombre VARCHAR(255) NOT NULL
);

-- Crear la tabla 'materia'
CREATE TABLE materia (
                         codigo_materia VARCHAR(255) PRIMARY KEY,
                         creditos VARCHAR(255) NOT NULL,
                         nombre_materia VARCHAR(255) NOT NULL
);

-- Crear la tabla 'nota'
CREATE TABLE nota (
                      nota_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      cedula VARCHAR(255) NOT NULL,
                      codigo_materia VARCHAR(255) NOT NULL,
                      nota INT NOT NULL,
                      FOREIGN KEY (cedula) REFERENCES estudiante(cedula),
                      FOREIGN KEY (codigo_materia) REFERENCES materia(codigo_materia)
);

-- Insertar datos de ejemplo en la tabla 'estudiante'
INSERT INTO estudiante (cedula, nombre) VALUES
                                                ('1234567890', 'Juan Perez'),
                                                ('0987654321', 'Maria Gomez');

-- Insertar datos de ejemplo en la tabla 'materia'
INSERT INTO materia (codigo_materia, creditos, nombre_materia) VALUES
                                                                   ('MAT101', '3', 'Matematicas'),
                                                                   ('INF102', '4', 'Informatica');

-- Insertar datos de ejemplo en la tabla 'nota'
INSERT INTO nota (cedula, codigo_materia, nota) VALUES
                                                    ('1234567890', 'MAT101', 85),
                                                    ('1234567890', 'INF102', 90),
                                                    ('0987654321', 'MAT101', 78),
                                                    ('0987654321', 'INF102', 88);