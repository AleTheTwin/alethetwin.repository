var blogeo = document.getElementById("signin");
blogeo.addEventListener("click", function() {
    var pass = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    const parametros = new URLSearchParams();
    parametros.append("PrmEmail", email);
    parametros.append("PrmPassword", pass);
    //axios.get("http://192.168.0.20/adios")
    //.then(function(response) {
    //    console.log(response);
    //    console.log("contenido: " + response.data);
    //    console.log("status: " + response.status);
    //    document.getElementById("titulo").innerHTML = response.data;
    //})
    //.catch(function(error) {
    //    console.log(error)
    //})
    axios.post("http://192.168.0.20/adios?" + parametros)
    .then(function(response) {
        console.log(response);
        console.log("contenido: " + response.data);
        console.log("status: " + response.status);
        document.getElementById("titulo").innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    })
})
