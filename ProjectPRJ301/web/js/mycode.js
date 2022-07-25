function openNav() {
    document.getElementById("mySidebar").style.width = "20%";
}

function closeNav() {
    document.getElementById("mySidebar").style.width = "0%";
}

function doDelete(masach) {
    if (confirm("Are you sure to delete category with Mã sách = " + masach + "?"))
    {
        window.location = "delete?masach=" + masach;
    }
}
