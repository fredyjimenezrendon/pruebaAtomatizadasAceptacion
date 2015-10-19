$( document ).ready(function() {
 
	$( '#buscar' ).click(function() {
		
		$.post( "../BusquedaLibrosServlet", function( data ) {
			  $.each(data,  function(i, libro){
				  $('#resultado').append('<tr><td>' + libro.titulo +'</td></tr>');
			  });
			});
		
	});
 
});