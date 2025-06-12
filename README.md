# XPDriveNB
Codigo para gerar o banco de dados:

create DATABASE XPdrive;

use XPdrive;

create table Produtos ( id int auto_increment primary key, nome varchar (50) not null, tipo varchar (30) not null, valor double not null, quantidade int not null);

INSERT INTO Produtos (nome, tipo, valor, quantidade) VALUES ("Ajazz AK680", "Keyboard", 179.99, 80), ("Razer Viper Mini", "Mouse", 299.99, 50), ("XFX RX 6650 XT", "Video Card", 1799.99, 30);
