<%@page import="java.util.*" %>
<%@page import="com.alg.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>

	<!-- Modal -->
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="index.jsp" method="POST">
				<div class="modal-header">
					<h1 class="modal-title fs-5">Crear mensaje</h1>
				</div>
				<div class="modal-body">

					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Ingrese
							el mensaje</label>
						<textarea class="form-control" name="mensaje" rows="3"></textarea>

					</div>
					<div class="mb-3">
						<label>Autor</label> 
						<input type="text" name="autor" class="form-control">
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" name="enviar">Enviar</button>
				</div>
			</form>
		</div>
		
		<!-- 
			String mensaje = request.getParameter("mensaje");
			String autor = request.getParameter("autor");
		%> -->
		<%
			MensajeDao mensajeDao = new MensajeDao();
		
			if(request.getParameter("enviar")!= null){
				Mensaje mensaje = new Mensaje(
						request.getParameter("mensaje"), 
						request.getParameter("autor")
				);
				mensajeDao.insertar(mensaje);
			}
			
		%>
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title">Todos los mensajes</h1>
			</div>
			<%
				//MensajeDao mensajeDao = new MensajeDao();
				List<Mensaje> mensajes = mensajeDao.seleccionar();
				Collections.reverse(mensajes);
				
				for (Mensaje mensaje : mensajes){
					
			%>
			<div class="modal-body">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%=mensaje.getAutor()%></h5>
						<p class="card-text"><%=mensaje.getMensaje()%></p>
						<p class="blockquote-footer">
							<cite><%=mensaje.getFecha() %></cite>
						</p>
						<a href="editar.jsp?id=<%=mensaje.getId() %>
						&&mensaje=<%=mensaje.getMensaje()%>
						&&autor=<%=mensaje.getAutor()%>" 
						class="card-link">Editar</a> <a href="eliminar.jsp?id=<%=mensaje.getId() %>"
							class="card-link">Eliminar</a>
					</div>
				</div>
			</div>
			<%} %>
		</div>
	</div>
</body>
</html>