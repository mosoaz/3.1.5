let currentUser = "";

fetch("/api/user/current").then(res => res.json())
    .then(data => {
        currentUser = data;
        console.log(data)
        showOneUser(currentUser);
    })

function showOneUser(user) {
    let temp = "";
    temp += "<tr>"
    temp += "<td>" + user.id + "</td>"
    temp += "<td>" + user.name + "</td>"
    temp += "<td>" + user.surname + "</td>"
    temp += "<td>" + user.email + "</td>"
    temp += "<td>" + user.roles.map(role => role.rolename.toString()) + "</td>"
    temp += "</tr>"
    document.getElementById("oneUserBody").innerHTML = temp;
}