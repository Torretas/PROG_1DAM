const apiUrl = 'http://localhost:8080/api/libros';

async function cargarLibros() {
    const respuesta = await fetch(apiUrl);
    const libros = await respuesta.json();

    let html = '<ul>';
    libros.forEach(libro => {
        html += `<li>${libro.titulo} (${libro.anioPublicacion}) - Autor: ${libro.autor?.nombre ?? 'Sin datos'}, Editorial: ${libro.editorial?.nombre ?? 'Sin datos'}</li>`;
    });
    html += '</ul>';
    document.getElementById('listaLibros').innerHTML = html;
}

document.getElementById('formularioLibro').addEventListener('submit', async (e) => {
    e.preventDefault();

    const libro = {
        titulo: document.getElementById('titulo').value,
        anioPublicacion: parseInt(document.getElementById('anio').value),
        autor: { id: parseInt(document.getElementById('autorId').value) },
        editorial: { id: parseInt(document.getElementById('editorialId').value) }
    };

    await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(libro)
    });

    await cargarLibros();  // Refresca el listado
    e.target.reset();      // Limpia el formulario
});

document.addEventListener('DOMContentLoaded', cargarLibros);
