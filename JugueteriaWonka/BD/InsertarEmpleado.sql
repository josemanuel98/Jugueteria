USE [JugueteriaWonka]
GO

/****** Object:  StoredProcedure [dbo].[InsertarEmpleado]    Script Date: 24/10/2017 09:58:54 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarEmpleado] 
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
	--Atributos generados automaticamente
	@IdRolGenerado		INT OUT,
	@IdUsuarioGenerado		INT OUT,
	@IdPersonaGenerado		INT OUT,
	@IdEmpleadoGenerado		INT OUT


AS 
	--Insertamos valores en la tabla Persona
	INSERT INTO Persona(Nombre,ApellidoPaterno,ApellidoMaterno,Genero,Rfc,Curp,FechaNacimiento,Cp,Fotografia,Domicilio)
	VALUES(@Nombre,@ApellidoPaterno,@ApellidoMaterno,@Genero,@Rfc,@Curp,CONVERT(DATE,@FechaNacimiento,103),@Cp,@Fotografia,@Domicilio)

	--Recuperamos el Id generado y lo guardamos en la variable:
	SET @IdPersonaGenerado=SCOPE_IDENTITY()

	
	
	INSERT INTO Rol(Descripcion)
	VALUES(@Descripcion)SET @IdRolGenerado=SCOPE_IDENTITY()	

	
	--Recuperamos el Id generado y lo guardamos en la variable:
	
	INSERT INTO Usuario(Password,Username,Activo, IdRol) VALUES (@Password,@Codigo,1,@IdRolGenerado)
	SET @IdUsuarioGenerado=SCOPE_IDENTITY()

	
	INSERT INTO Empleado(Salario,Codigo,FechaIngreso,Activo,IdPersona,IdUsuario)VALUES(@Salario,@Codigo,CONVERT(DATE,GETDATE(),103),1,@IdPersonaGenerado,@IdUsuarioGenerado)
	SET @IdEmpleadoGenerado=SCOPE_IDENTITY()
				



				
GO


