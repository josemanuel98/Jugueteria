USE [JugueteriaWonka]
GO

/****** Object:  View [dbo].[V_Cliente]    Script Date: 24/10/2017 10:06:01 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[V_Cliente]
AS
SELECT Cliente.IdCliente,
		Persona.IdPersona,
		Persona.Nombre,
		Persona.ApellidoPaterno,
		Persona.ApellidoMaterno,
		Persona.Genero,
		Persona.Rfc,
		Persona.Curp,
		CONVERT(NVARCHAR, Persona.FechaNacimiento, 103) AS FechaNacimientol,
		Persona.Cp,
		Persona.Fotografia,
		Persona.Domicilio,
		Cliente.Email,
		Cliente.Telefono,
		Cliente.Activo
		FROM Cliente INNER JOIN Persona ON Cliente.IdPersona = Persona.IdPersona
GO


