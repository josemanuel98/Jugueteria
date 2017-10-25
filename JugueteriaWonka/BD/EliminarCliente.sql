USE [JugueteriaWonka]
GO

/****** Object:  StoredProcedure [dbo].[uspEliminarCliente]    Script Date: 24/10/2017 09:59:20 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspEliminarCliente]
@IdCliente INT
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRANSACTION
	BEGIN TRY
		UPDATE Cliente SET Activo = 0 WHERE IdCliente = @IdCliente
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


