"use strict"

import * as api from "./api.js"; 
window.api = api;


const scripts =["https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js",
				"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js",
				"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"]

//une erreur m'ennuie avec bootstrap qui ne vois pas tjrs jquery au chargement, mais çà fonctionne a priori
for(var i= 0; i < scripts.length; i++){
let script = document.createElement('script');
script.type = 'text/javascript';
script.src = scripts[i];
document.getElementsByTagName('head')[0].appendChild(script);
}