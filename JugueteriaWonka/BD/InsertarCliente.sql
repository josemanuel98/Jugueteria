USE [JugueteriaWonka]
GO

/****** Object:  StoredProcedure [dbo].[uspInsertarCliente]    Script Date: 24/10/2017 09:59:27 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspInsertarCliente]
@Nombre VARCHAR(50),
@Paterno VARCHAR(50),
@Materno VARCHAR(50),
@Genero VARCHAR(2),
@Rfc VARCHAR(14),
@Curp VARCHAR(20),
@FechaNacimiento VARCHAR(20),
@Cp VARCHAR(15),
@Fotografia TEXT,
@Domicilio VARCHAR(128),
@Email VARCHAR(128),
@Telefono VARCHAR(20),
@IdPersona INT OUT,
@IdCliente INT OUT
AS
SET NOCOUNT ON
BEGIN
	BEGIN TRANSACTION
	BEGIN TRY
		INSERT INTO Persona
		(
			Nombre,
			ApellidoPaterno,
			ApellidoMaterno,
			Genero,
			Rfc,
			Curp,
			FechaNacimiento,
			Cp,
			Fotografia,
			Domicilio
		)
		VALUES
		(
			@Nombre,
			@Paterno,
			@Materno,
			@Genero,
			@Rfc,
			@Curp,
			CONVERT(DATE, @FechaNacimiento, 103),
			@Cp,
			@Fotografia,
			@Domicilio
		)
		
		SET @IdPersona = IDENT_CURRENT('Persona')
		
		INSERT INTO Cliente
		(
			Email,
			Telefono,
			Activo,
			IdPersona
		)
		VALUES
		(
			@Email,
			@Telefono,
			1,
			@IdPersona
		)
		
		SET @IdCliente = IDENT_CURRENT('Cliente')

		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		declare @errnumber int=0, 
		@errseverity int=0, 
		@errstate int=0,
		@errproc nvarchar(126)=N'',
		@errline int=0,
		@errmsg nvarchar(2048)=N''

		select @errnumber=ERROR_NUMBER(),
			@errseverity=ERROR_SEVERITY(),
			@errstate=ERROR_STATE(),
			@errproc=ERROR_PROCEDURE(),
			@errline=ERROR_LINE(),
			@errmsg=ERROR_MESSAGE()

		select ERROR_NUMBER(),ERROR_SEVERITY(),ERROR_STATE(),ERROR_PROCEDURE(),ERROR_LINE(),ERROR_MESSAGE()
		ROLLBACK TRANSACTION
	END CATCH
END
GO


