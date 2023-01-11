function listAvaliability() {
    var list = document.getElementById("avaliabilityList");
    $.ajax({
        url: "http://127.0.0.1:8080/beadando-1.0-SNAPSHOT/resources/jakartaee9/tables",
        type: "GET",
        data: {},
        success: function(tables) {
            for(var timeIndex = 0; timeIndex < 12; timeIndex ++) {
                var row = list.insertRow(timeIndex + 1);

                var timeStr = (timeIndex + 8) + ':00 - ' + (timeIndex + 9) + ':00';
                row.insertCell(0).innerHTML = timeStr;

                for(var i = 0; i < tables.length; i++) {
                    row.insertCell(i + 1).innerHTML = tables[i][timeIndex];
                }
            }
        },
        error: function(){
                alert("error");
        }
    });
}

function newReservation() {

    var reservationId = document.getElementById("formReservationNumber").value
    var tableId = document.getElementById("formReservationTableId").value;
    var reservationTime = document.getElementById("formReservationTime").value;
    var name = document.getElementById("formReservationName").value;
    var email = document.getElementById("formReservationEmail").value;

    if(reservationId == null || reservationId == "" ||
       tableId == null || tableId == "" ||
       reservationTime == null || reservationTime == "" ||
       name == null || name == "" ||
       email == null || email == "") {

        alert("Nem töltöttél ki minden mezőt");
        return;
   }

    $.ajax({
        url: "http://127.0.0.1:8080/beadando-1.0-SNAPSHOT/resources/jakartaee9/newReservation",
        type: "POST",
        data: JSON.stringify({
            "reservationId": parseInt(reservationId),
            "tableId": tableId,
            "reservationTime": reservationTime,
            "name": name,
            "email": email
        }),
        success: function(response) {
            location.reload();
            if(response.status == "conflict") {
                alert("Ez az időpont és asztal már le van foglalva!");
            } else if (response.status == "failed") {
                alert("error");
            } else if (response.status == "success") {
                alert("Sikeres foglalás")
            }
        },
        error: function() { alert("error"); },
        contentType: "application/json",
        dataType: "json"
    });
}