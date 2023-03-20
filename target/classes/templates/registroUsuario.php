<?php

$servidor= "localhost";
$usuario= "root";
$clave= "";
$baseDeDatos= "formulario";

$enlace = mysqli_connect($servidor, $usuario, $clave, $baseDeDatos);

if(!$enlace){
  echo"Error en la conexión con el servidor";
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Login y Register</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">


       
    <link rel="stylesheet" href="css/estilosRegistro.css" /> 
</head>
<body>
   
  <header class="hero">      
    <div class="navbar">  
      <div><h2 class="nav__logo">ChacrasApp</h2></div>                
      <div class="nav-header">
                  
          <!-- responsive navbar toggle button -->
          <input type="checkbox" id="nav-check" />
          <div class="nav-btn">
            <label for="nav-check">
              <span></span>
              <span></span>
              <span></span>
            </label>
          </div>
          <!-- Navbar items -->          
          <div class="nav-links">            
            <a href="index.html">Inicio</a>
            <a href="index.html#sobremi">Nosotros</a>
            <!-- Dropdown menu -->
            <div class="dropdown">
              <a class="dropBtn" href="#"
                >Servicios
                <i class="fas fa-angle-down"></i>
              </a>
              <!--<div class="drop-content">
                <a href="#">Electricista</a>
                <a href="#">Gasista</a>
                <a href="#">Plomería</a>
              </div>-->
            </div>
            <a href="#contacto">Contacto</a>            
          </div>
      </div>      
</header> 
<figure>
    <img src="images/fondoproveedor.jpg" class="img_body" />
  </figure>  
        <main>
            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Iniciar sesión para entrar en la página.</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión.</p>
                        <button id="btn__registrarse">Regístrarse</button>
                    </div>
                </div>

                <!--Formulario de Login y registro-->
                <div class="contenedor__login-register">
                    <!--Login-->
                    <!-- esto va en form para conectar con php action="php/login_usuario_be.php"-->
                    <form  method="POST" action="perfilUsuario.html" class="formulario__login">
                        <h2>Iniciar Sesión</h2>
                        <input type="text" placeholder="Correo Electronico"  name="correo">
                        <input type="password" placeholder="Contraseña" name="contrasenia">

                        <div>
                          <button>REntrar</button>
                          <input type="submit" name="registrarse" value="Registrarse">
                         </div>                        
                    </form>

                    <!--Register-->
                    <!-- esto va en el form para conectar con php action="php/registro_usuario_be.php"-->
                    <form  method="POST" action="perfilUsuario.html" class="formulario__register">
                        <h2>Regístrate</h2>
                        <input type="text" placeholder="DNI" name="id">
                        <input type="text" placeholder="Nombre y Apellido completo" name="usuario">                         
                        <input type="text" placeholder="Domicilio" name="domicilio"> 
                        <input type="text" placeholder="Telefono" name="telefono">                       
                        <input type="text" placeholder="Correo Electronico" name="correo">                                               
                        <input type="password" placeholder="Contraseña" name="contrasenia"><br> 
                        <br><p>Estoy de acuerdo con los <a href="#">Terminos y Condiciones.</a></p> 
                        <input type="checkbox" id="cbox1" value="first_checkbox" name="check">                          
                       
                       <div>
                        <button>Regístrarse</button>
                        <input type="submit" name="registrarse" value="Registrarse">
                       </div>
                       

                    </form>
                </div>
            </div>           
        </main>

        <footer>
          <section id="contacto" class="footer__copy container">
            <div class="footer__social">
              <a href="#" class="footer__icons"
                ><img src="./images/facebook.svg" class="footer__img"
              /></a>
              <a href="#" class="footer__icons"
                ><img src="./images/twitter.svg" class="footer__img"
              /></a>
              <a href="#" class="footer__icons"
                ><img src="./images/youtube.svg" class="footer__img"
              /></a>
            </div>
    
            <h3 class="footer__copyright">
              Derechos reservados &copy; Grupo B
            </h3>
          </section>
        </footer>   

        <script src="js/script.js"></script>
</body>
</html>

<?php
if(isset($_POST['registrarse'])){

$id= $_POST["id"];
$nombre= $_POST["nombre"];
$domicilio= $_POST["domicilio"];
$telefono= $_POST["telefono"];
$correo= $_POST["correo"];
$contrasenia= $_POST["contrasenia"];

$insertarDatos = "INSERT INTO datos VALUES( '$id',
                                            '$nombre',
                                            '$domicilio',
                                            '$telefono',
                                            '$correo',
                                            '$contrasenia', 
                                            )";

$ejecutarInsertar = mysqli_query($enlace, $insertarDatos);

if(!ejecutarInsertar){
  echo"Error en la linea de sql";
}
}

?>

<!--PARA MOSTRAR EN TABLA-->
<?php
$consulta = "SELECT * FROM datos";
$ejecutarConsulta = mysqli_query($enlace, $consulta);
$verFilas = msqli_num_rows($ejecutarConsulta);
$fila = msqli_fetch_array($ejecutarConsulta);

if(!$ejecutarConsulta){
  echo"Error en la consulta";
}else{
  if($verFilas>1){
    echo"<tr><td>Sin registros</td></tr>";
  }else{
    for($i=0; $i<=$fila; $i++){
      echo'
      <tr>
        <td>'.$fila[].'</td>
        <td>'.$fila[].'</td>
        <td>'.$fila[].'</td>
        <td>'.$fila[].'</td>
        <td>'.$fila[].'</td>
        <td>'.$fila[].'</td>        
      </tr>     
      ';
      $fila = msqli_fetch_array($ejecutarConsulta);
    }
  }
}
?>
