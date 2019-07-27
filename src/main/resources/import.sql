INSERT INTO SOCIO(soc_cedula, soc_nombre, soc_direccion, soc_telefono, soc_correo) values ('2300428790','Josue Erazo','Latacunga','0996006757','josue19978@hotmail.com');
INSERT INTO SOCIO(soc_cedula, soc_nombre, soc_direccion, soc_telefono, soc_correo) values ('1300428791','Carlos Ramirez','Quito','0986006853','ramirez@hotmail.com');
INSERT INTO SOCIO(soc_cedula, soc_nombre, soc_direccion, soc_telefono, soc_correo) values ('4300428794','Moises Porozo','Ambato','0966006758','porozo8@hotmail.com');

INSERT INTO SEXO(sex_nombre) values ('Masculino');
INSERT INTO SEXO(sex_nombre) values ('Femenino');

INSERT INTO ACTOR(act_nombre, sex_id) values ('Gabriel Mercado',1);
INSERT INTO ACTOR(act_nombre, sex_id) values ('Angela Mize',2);
INSERT INTO ACTOR(act_nombre, sex_id) values ('Carlos Tapia',1);

INSERT INTO FORMATO(for_nombre) values ('Cd');
INSERT INTO FORMATO(for_nombre) values ('Vhs');
INSERT INTO FORMATO(for_nombre) values ('Dvd');

INSERT INTO DIRECTOR(dir_nombre) values ('Gabriel Espinosa');
INSERT INTO DIRECTOR(dir_nombre) values ('Marco Macias');
INSERT INTO DIRECTOR(dir_nombre) values ('Johan Zambrano');

INSERT INTO GENERO(gen_nombre) values ('Accion');
INSERT INTO GENERO(gen_nombre) values ('Comedia');
INSERT INTO GENERO(gen_nombre) values ('Drama');

INSERT INTO PELICULA(pel_nombre, pel_costo, pel_fecha_estreno, dir_id, gen_id, for_id) values ('Los increibles',3.5,'2005-06-03',1,1,3);
INSERT INTO PELICULA(pel_nombre, pel_costo, pel_fecha_estreno, dir_id, gen_id, for_id) values ('Uno mas dos',2.5,'2007-04-05',2,2,2);
INSERT INTO PELICULA(pel_nombre, pel_costo, pel_fecha_estreno, dir_id, gen_id, for_id) values ('Los caminantes',4.5,'2015-11-02',3,3,1);

INSERT INTO ACTOR_PELICULA(apl_papel, act_id, pel_id) values ('Actor principal',1,2);
INSERT INTO ACTOR_PELICULA(apl_papel, act_id, pel_id) values ('Actor Secundario',2,1);
INSERT INTO ACTOR_PELICULA(apl_papel, act_id, pel_id) values ('Extra',3,3);

INSERT INTO ALQUILER(alq_fecha_desde, alq_fecha_hasta, alq_valor , pel_id, soc_id) values ('2019-03-02', '2019-03-05', 8.50 ,1,2);
INSERT INTO ALQUILER(alq_fecha_desde, alq_fecha_hasta, alq_valor , pel_id, soc_id) values ('2019-03-07', '2019-03-10', 3.50 ,2,3);
INSERT INTO ALQUILER(alq_fecha_desde, alq_fecha_hasta, alq_valor , pel_id, soc_id) values ('2019-03-10', '2019-03-12', 6.35 ,3,1);







