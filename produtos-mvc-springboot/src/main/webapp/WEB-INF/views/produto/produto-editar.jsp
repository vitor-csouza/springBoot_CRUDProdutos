<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
		<meta charset="ISO-8859-1">
		<title>Produtos</title>
		
		<!-- ATALHO PARA TRAZER A URL DE CONTEXTO DO PROJETO -->
		<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
		
		<!-- ATALHOS PARA OS ARQUIVOS ESTATICOS DO WEBJAR -->
		<spring:url value="${contextPath}/webjars/bootstrap/css" var="css" />
		<spring:url value="${contextPath}/webjars/jquery" var="jquery" />
		<spring:url value="${contextPath}/webjars/bootstrap/js" var="js" />

		<!-- APONTAMENTO PARA O CSS DO BOOTSTRAP -->
		<link href="${css}/bootstrap.min.css" rel="stylesheet">
		
		<!-- CSS PARA NOSAS CUSTOMIZACOES -->
		<link href="/css/style.css" rel="stylesheet">

		<!-- LINKS PARA USAR FONTE CUSTOMIZAVEL DO GOOGLE FONTES -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
				
	</head>
	<body>
		<header>
			<%@include file="../navbar/navbar.html" %>
		</header>
    
    <main class="container">
	
		<section id="formulario">
	        <!-- Call to Action Well -->
	        <div class="row">
	            <div class="col-lg-12">
	                <div class="well">
						
						<h2 class="fonte-titulo texto-cor-especial">Produto</h2>
						
						<form:form modelAttribute="produtoModel" action="${contextPath}/produto/${produtoModel.id}" method="post">
							
							<spring:hasBindErrors name="produtoModel">
								<div class="alert alert-danger" role="alert">
									<form:errors path="*" class="has-error" />
								</div> 
							</spring:hasBindErrors>
						
							<div class="form-group">
								<form:input type="hidden" path="id" name="id" id="id" value="${produto.id}" />
	                        </div>
							
							<div class="form-group">
								<label class="control-label" for="nome">Nome:</label>
								<form:input type="text" name="nome" path="nome" id="nome" class="form-control" maxlength="50" size="50" />
	                       		<font color="red"><form:errors path="nome" /></font><br/>
	                        </div>
	                        <div class="form-group">
								<label class="control-label" for="nome">SKU:</label>
								<form:input type="text" name="sku" path="sku" id="sku" class="form-control" maxlength="50" size="50" />
								<font color="red"><form:errors path="sku" /></font><br/>
							</div>
							
	                        <div class="form-group">
								<label class="control-label" for="idCategoria">Categoria:</label>
								<form:select path="categoriaModel.idCategoria" name="idCategoria" id="idCategoria">
									<form:options items="${categorias}" itemValue="idCategoria" itemLabel="nomeCategoria"/>
								</form:select>
							</div>
							<div class="form-group">
								<label class="control-label" for="mesnagem">Descri��o:</label>
								<form:textarea id="descricao" class="form-control" path="descricao" name="descricao" rows="4" cols="100"></form:textarea>
								<font color="red"><form:errors path="descricao" /></font><br/>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="preco">Pre�o:</label>
								<form:input type="text" name="preco" path="preco" id="preco" class="form-control" maxlength="14" size="15" />
								<font color="red"><form:errors path="preco" /></font><br/>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="mesnagem">Caracter�sticas:</label>
								<form:textarea id="caracteristicas" class="form-control" path="caracteristicas" name="caracteristicas"  value="${produto.caracteristicas}" rows="4" cols="100"></form:textarea>
								<font color="red"><form:errors path="caracteristicas" /></font><br/>
							</div>
							<hr>
							
							<a class="btn btn-secondary btn-sm" href="${contextPath}/produto">Cancelar</a>
							<button type="submit" class="btn btn-primary btn-sm">Gravar</button>
						</form:form>
	                </div>
	            </div>
	        </div>
	    </section>
	</main>
	
	<!-- APONTAMENTO PARA AS BIBLIOTECAS E JAVASCRIPT DO JQUERY E BOOTSTRAP -->
	<script src="${jquery}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>