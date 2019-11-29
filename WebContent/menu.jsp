<body>
<%@ include file="header.jsp" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Health Track</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
  
     <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Peso</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Cadastrar</a>
      <a class="dropdown-item" href="#">Listar</a>
      <a class="dropdown-item" href="#">Alterar</a>
      <a class="dropdown-item" href="#">Buscar</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Alimentação</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Cadastrar</a>
      <a class="dropdown-item" href="#">Listar</a>
      <a class="dropdown-item" href="#">Alterar</a>
      <a class="dropdown-item" href="#">Buscar</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Atividade</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Cadastrar</a>
      <a class="dropdown-item" href="#">Listar</a>
      <a class="dropdown-item" href="#">Alterar</a>
      <a class="dropdown-item" href="#">Buscar</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Pressão Arterial</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Cadastrar</a>
      <a class="dropdown-item" href="#">Listar</a>
      <a class="dropdown-item" href="#">Alterar</a>
      <a class="dropdown-item" href="#">Buscar</a>
    </div>
  </li>
     
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Encontrar no site" aria-label="Busca">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
    </form>
  </div>
</nav>
<%@ include file="footer.jsp"%>
</body>