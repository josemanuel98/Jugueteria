USE [JugueteriaWonka]
GO

/****** Object:  View [dbo].[V_Empleados]    Script Date: 24/10/2017 10:06:07 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





CREATE VIEW [dbo].[V_Empleados] 
	AS 
		
		--SELECT IdEmpleado,Salario, Nombre, Username, Descripcion
SELECT E.IdEmpleado,E.Salario,E.Codigo,CONVERT(NVARCHAR,E.FechaIngreso,103)AS FechaIngreso,E.Activo as Activo_Empleado,
	   P.IdPersona,P.Nombre,P.ApellidoPaterno,P.ApellidoMaterno,P.Genero,P.Rfc,P.Curp,CONVERT(NVARCHAR,P.FechaNacimiento,103)AS FechaNacimiento,
	   P.Cp,P.Fotografia,P.Domicilio,
	   U.IdUsuario,U.Password,U.Username,U.Activo,
	   R.Descripcion,R.IdRol
	   
	   FROM Empleado E INNER JOIN Persona P ON E.IdPersona = P.IdPersona
	   INNER JOIN Usuario U ON E.IdUsuario = U.IdUsuario
	   INNER JOIN Rol R ON U.IdRol = R.IdRol 

	   WHERE E.Activo = 1

GO


