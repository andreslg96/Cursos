<%@page import="com.alg.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar mensaje</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="editar.jsp" method="POST">
				<div class="modal-header">
					<h1 class="modal-title fs-5">Editar mensaje</h1>
				</div>
				<div class="modal-body">

					<div class="mb-3">
						<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
						<label for="exampleInputEmail1" class="form-label">Ingrese
							el mensaje</label>
						<textarea class="form-control" name="mensaje" rows="3"><%=request.getParameter("mensaje")%>
						</textarea>

					</div>
					<div class="mb-3">
						<label>Autor</label> 
						<input type="text" name="autor" class="form-control" value="<%=request.getParameter("autor")%>">
					</div>
				</div>
				<div class="modal-footer">
					<a href="index.jsp" type="submit" class="btn btn-danger">Regresar</a>
					<button type="submit" class="btn btn-primary" name="enviar">Guardar cambios</button>
				</div>
			</form>
		</div>
		</div>
		<%
		MensajeDao mensajeDao = new MensajeDao();
		
		String id = request.getParameter("id");
		
		if(request.getParameter("enviar")!= null){
			Mensaje mensaje = new Mensaje(
					Integer.parseInt(id.trim()),
					request.getParameter("mensaje"), 
					request.getParameter("autor")
			);
			mensajeDao.editar(mensaje);
		}
		%>

</body>
</html>