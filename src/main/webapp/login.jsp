<jsp:include page="templates/cabecera.jsp" />
	<ul class="topnav">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#news">News</a></li>
		<li class="right"><a class="active" href="login.jsp">Entrar</a></li>
		<li class="right"><a href="registro.jsp">Registrate</a></li>
	</ul>

	<h1 class="center">Login</h1>

	<div class="centralBox">
		<jsp:include page="componentes/loginForm.jsp"></jsp:include>
	</div>
  <section class="section">
    <div class="container">
      <h1 class="title">
        Hello World
      </h1>
      <p class="subtitle">
        My first website with <strong>Bulma</strong>!
      </p>
    </div>
  </section>
</body>
</html>