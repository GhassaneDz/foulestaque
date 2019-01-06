//Normalement le panier doit etre converti en en string (JSON.Stringify) et stocké dans localstorage
//Puis pour le retrouver en objet JSON.parse

let panier = new Array();

export function getProduits() {
    $("#produits").empty();
    var categorieId = $('#categories').val();
    if (categorieId == null) categorieId = 0;
    $.ajax
        ({
            type: "GET",
            url: "/fo/produits/" + categorieId,
            dataType: 'json',
            success: function (data) {
                data.forEach(element => {
                    $("#produits").append('<li class="list-group-item" id=' + element.id + '><span style="margin-right:1.25em; display:inline-block;"><button onclick="api.ajouterAuPanier(this)" type="button" class="btn btn-dark btn-sm">Ajouter</button></span><span style="margin-right:1.25em; display:inline-block;">' + element.libelle + '</span><span class="badge badge-pill badge-success">' + element.prix + '€</span></li>');
                });
            }
        });
}


export function getProduitById(id, success) {
    var result;
    $.ajax
        ({
            type: "GET",
            url: "/fo/produit/" + id,
            dataType: 'json',
            success: function (data) {
                success(data);
            }
        });
}

export function getCategories() {
    $.ajax
        ({
            type: "GET",
            url: "/fo/categories",
            dataType: 'json',
            success: function (data) {
                data.forEach(element => {
                    $("#categories").append('<option value=' + element.id + '>' + element.libelle + '</option>');
                });
            }
        });
}


export function ajouterAuPanier(e) {
    var id = $(e).parent().parent().attr("id");
   
   
    getProduitById(id, function (d) {      
        var detail = { Produit: d.libelle, Prix: d.prix };
        panier.push(detail); 
        $("#titre").text("Total : "+totalPanier().toFixed(2)+"€");
        majCommande();      
         });
    
    
}


export function viderPanier() {
    panier = new Array();
    majCommande();
}

export function totalPanier() {
    var total = 0;   
    panier.forEach(element => {    
        total += element.Prix;
    });
   
    return total;
}

export function majCommande() {
    $('#tableau').empty();
    panier.forEach(element => {
        console.log(element.Produit + ' ' + element.Prix);
        $('#tableau').append('<tr><td>' + element.Produit + '</td><td>' + element.Prix + '</td></tr>');
    });   
    
}
