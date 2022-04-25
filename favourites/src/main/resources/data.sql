create table favourite(id int identity(1,1) primary key, type varchar(5), name varchar(100), serviceCode varchar(3), clientId varchar(50) )

insert into [dbo].[favourite](TipoFavorito, NombreFavorito, CodServicio, IdCliente)
values('A', 'Telf casa', '010','08000401')