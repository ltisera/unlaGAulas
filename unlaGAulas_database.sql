create database if not exists `unlaGAulas_database`;

use `unlaGAulas_database`;

insert into unlagaulas_database.user values (1,"2022-03-01",1,"$2a$10$ujL2Bx27KF5IpH/GEqOIMujLhNadkhMEXc8aAPChaW.Ve2ogt5ji6","2022-03-01","user");
insert into unlagaulas_database.user_role values (1,"2022-03-01","ROLE_USER","2022-03-01",1);

insert into unlagaulas_database.user values (2,"2022-03-01",1,"$2a$10$ujL2Bx27KF5IpH/GEqOIMujLhNadkhMEXc8aAPChaW.Ve2ogt5ji6","2022-03-01","user2");
insert into unlagaulas_database.user_role values (2,"2022-03-01","ROLE_ADMIN","2022-03-01",2);


insert into unlagaulas_database.departamento values (1,"Departamento 1");
insert into unlagaulas_database.carrera values (1,"Licenciatura en sistemas",1);
insert into unlagaulas_database.materia values (1,"1608","Objetos 2",1);
insert into unlagaulas_database.edificio values (1,"Hernandez");
insert into unlagaulas_database.aula values (1,1,1);

select * from user;
select * from user_role;
select * from nota_pedido_final;
select * from nota_pedido_curso;