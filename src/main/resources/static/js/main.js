function confirmDelete(event) {
    if(!confirm("Are you sure?")) {
        event.preventDefault();
    }
}

function setFilter(content, filter) {
    filter.classList.toggle("filter-button-toggle");
    content.classList.toggle("hidden");
}

function main() {
    if (window.location.pathname == "/games" && document.getElementById("delete-link")) {
        document.getElementById("delete-link").addEventListener("click", (event) => confirmDelete(event));
    }

    if (window.location.pathname == "/manage") {
        document.getElementById("platform-filter").addEventListener("click", () => setFilter(document.getElementById("platforms"), document.getElementById("platform-filter")));
        document.getElementById("priority-filter").addEventListener("click", () => setFilter(document.getElementById("priorities"), document.getElementById("priority-filter")));
        document.getElementById("statuses-filter").addEventListener("click", () => setFilter(document.getElementById("statuses"), document.getElementById("statuses-filter")));
    }
}

main();