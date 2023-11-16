<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
      <!-- LLAMAR AL SERVLET -->
    <a class="navbar-brand" href="../ac_gg_AdminController">Ver Encuestas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
            <!-- LLAMAR AL SERVLET -->
          <a class="nav-link active" aria-current="page" href="./VistaAdmin/graficas.jsp">Ver graficas</a>
        </li>
      </ul>
      <form class="d-flex">
        <a class="btn btn-danger" aria-current="page" href="../index.jsp">Cerrar sesion</a>          
      </form>
    </div>
  </div>
</nav>