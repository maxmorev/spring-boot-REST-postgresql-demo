Demo RESTful Web Service | Spring boot | Spring Data with PostgreSQL
=======
#### Overview
This Simple Demo will show:

⚫ how to configure the application using Spring Boot.

⚫ how to develop an application using Spring Data JPA. 

⚫ demonstrate the server running RESTFull service wich returning data in JSON standard.

#### What you’ll need (linux)
PostgreSQL server

```java

sudo apt-get install postgresql-10 pgadmin3

then change config for using pgAdminIII
file path : /etc/postgresql/10/main/pg_hba.conf
line you need to change from: 
local   all             postgres      peer
to:
local   all             postgres      trust
Restart postgreSQL server
sudo service postgresql restart

then change password for user postgres
passwd postgres
type postgres

```
#### Create database and tables
```java

su postgres
createdb testdb
psql -d testdb

create table departament ( 
id serial PRIMARY KEY, 
name varchar(50) NOT NULL );

create table employeeLevel(
id serial PRIMARY KEY,
name varchar(50) NOT NULL )

create table employee ( 
id serial PRIMARY KEY, 
departamentId INTEGER REFERENCES departament(id),
employeeLevelId INTEGER REFERENCES employeeLevel(id),
name varchar(50) NOT NULL );

INSERT INTO departament (name) VALUES ('java');
INSERT INTO departament (name) VALUES ('hr');
INSERT INTO departament (name) VALUES ('analytics');
INSERT INTO departament (name) VALUES ('ai');

INSERT INTO employeelevel (name) VALUES ('juniour');
INSERT INTO employeelevel (name) VALUES ('senior');
INSERT INTO employeelevel (name) VALUES ('master');

insert into employee (name, departamentId, employeeLevelId) VALUES ('Maxim', 1, 1);
insert into employee (name, departamentId, employeeLevelId) VALUES ('Victoria', 1, 1);
insert into employee (name, departamentId, employeeLevelId) VALUES ('Android', 1, 1);

insert into employee (name, departamentId, employeeLevelId) VALUES ('Metallica', 2, 2);
insert into employee (name, departamentId, employeeLevelId) VALUES ('Mötley Crüe', 2, 2);

```


