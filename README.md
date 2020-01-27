# PizzeriaPanucci

![alt text](https://github.com/antromeo/PizzeriaPanucci/blob/master/PizzeriaPanucci_img.jpg)
## Configurazione Database

Per la persistenza abbiamo usato MySQL.

Connettore Java utilizzato: mysql-connector-java:8.0.18
Driver utilizzato: om.mysql.cj.jdbc.Driver

Per configurarlo correttamente in locale, se si vuole configurare da terminale, effettuare le seguenti operazioni:

1) avviare il servizio mysql e accedere con root, con il seguente comando: mysql -u root -p

2) creare una utente di nome pizzeriapanucci con pw pizzeriapanucci e con tipo password mysql_native_password, usare quindi il seguente comando:
CREATE USER 'pizzeriapanucci'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pizzeripanucci';


3) creare un database di nome pizzeriapanucci: CREATE DATABASE pizzeriapanucci;

4) creare una tabella di nome Clienti con il comando che segue:

        CREATE TABLE Clienti (
             id int NOT NULL AUTO_INCREMENT,
             nome varchar(255) NOT NULL,
             cognome varchar(255),
             email varchar(255),
             indirizzo varchar(255),
             PRIMARY KEY (id)
        );

5) è possibile inizializzare i clienti nel DB con i seguenti:

        INSERT INTO Clienti (nome, cognome, email, indirizzo) VALUES ('mario', 'rossi', 'mrossi@gmail.com', 'via marco polo');
        INSERT INTO Clienti (nome, cognome, email, indirizzo) VALUES ('alfredo', 'verdi', 'averdi@gmail.com', 'via garibaldi');

6) fornire i privilegi sul DB pizzeriapanucci all'utente pizzeriapanucci con il seguente comando:

        GRANT ALL PRIVILEGES ON pizzeriapanucci.* TO 'pizzeriapanucci'@'localhost';




