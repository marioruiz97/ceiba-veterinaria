INSERT INTO TIPO_CITA(NOMBRE, TARIFA_BASICA, DESCRIPCION_BREVE) VALUES ('CITA GENERAL', 18500, 'CITA BÁSICA');
INSERT INTO VETERINARIO(ID, IDENTIFICACION, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO_CONTACTO) VALUES (1, '98665023', 'Veterinario test', 'RUIZ', 'TEST', '3006521777');
INSERT INTO VETERINARIO(IDENTIFICACION, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO_CONTACTO) VALUES ('1017214122', 'CAROLINA', 'RUIZ', '', '3046021544');
INSERT INTO RESPONSABLE_MASCOTA(ID, IDENTIFICACION, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO_CONTACTO) VALUES (1, '43032118', 'GLORIA', 'BEODYA', 'JARAMILLO', '3007855772');
INSERT INTO RESPONSABLE_MASCOTA(IDENTIFICACION, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO_CONTACTO) VALUES ('71665023', 'MARIO', 'RUIZ', 'BEDOYA', '3006521777');
INSERT INTO MASCOTA(NOMBRE, FECHA_NACIMIENTO, PESO, RASGOS_CARACTERISTICOS, ID_RESPONSABLE_MASCOTA) VALUES ('Nala', '2020-10-01', 2.5, 'golden retriever juguetona', 1);
