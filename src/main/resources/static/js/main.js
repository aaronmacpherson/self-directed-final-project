function confirmDelete(event) {
    if(!confirm("Are you sure?")) {
        event.preventDefault();
    }
}

function main() {
    if (window.location.pathname == "/games" && document.getElementById("delete-link")) {
        document.getElementById("delete-link").addEventListener("click", (event) => confirmDelete(event));
    }
}

main();