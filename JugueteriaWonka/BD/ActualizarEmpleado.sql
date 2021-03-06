USE [JugueteriaWonka]
GO
/****** Object:  StoredProcedure [dbo].[UpdateEmpleado]    Script Date: 24/10/2017 10:04:50 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[UpdateEmpleado]
	--Atributos para dbo.Persona
	@Nombre					VARCHAR(50),
	@ApellidoPaterno		VARCHAR(50),
	@ApellidoMaterno		VARCHAR(50),
	@Genero					VARCHAR(2),
	@FechaNacimiento		VARCHAR(20),
	@Cp						VARCHAR(15),
	@Domicilio				VARCHAR(128),
	@Fotografia				TEXT,
	@Curp					VARCHAR(20),
	@Rfc					VARCHAR(14),
	--Atributos para dbo.Empleado
	@Salario				FLOAT,
	@Codigo					VARCHAR(20),
	--Atributos para dbo.Usuario
	@Password				VARCHAR(64),
	--Atributos para dbo.Rol
	@Descripcion			VARCHAR(30),
	--Atributos IDs 
	@IdPersona					INT, 
	@IdRol						INT,
	@IdUsuario					INT,
	@IdEmpleado					INT  
AS
BEGIN
	UPDATE Empleado SET Salario=@Salario,Codigo=@Codigo,Activo=1 WHERE IdEmpleado=@IdEmpleado
	UPDATE Persona SET Nombre=@Nombre,ApellidoMaterno=@ApellidoMaterno,ApellidoPaterno=@ApellidoPaterno,
					   Genero=@Genero,FechaNacimiento=CONVERT(DATE, @FechaNacimiento, 103),Cp=@Cp,Domicilio=@Domicilio,
					   Fotografia=@Fotografia,Curp=@Curp,Rfc=@Rfc WHERE IdPersona=@IdPersona

	

	UPDATE Usuario SET Password=@Password,Username=@Codigo,Activo=1 WHERE IdUsuario=@IdUsuario

	UPDATE Rol SET Descripcion=@Descripcion WHERE IdRol=@IdRol


END
