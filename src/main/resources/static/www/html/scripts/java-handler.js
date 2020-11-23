function loadLessons() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var lessons = JSON.parse(this.responseText);
            for (var i = 0; i < lessons.length; i++) {
                var lesson = lessons[i];
                console.log(lesson);
                $('section').append('<div class="text-block" onclick="onTextBlock(event)"><h2>' +
                     lesson.title + '</h2><ul type="square"><li>Проходит ' +
                    (lesson.isRemote == 'true' ? 'дистанционно' : 'очно') + '</li><li>Начинается в ' +
                     lesson.startTime + ' и заканчивается в ' +
                     lesson.endTime + '</li><li>Номер аудитории: ' +
                     lesson.audienceNumber + '</li><li>Преподаватель: ' +
                     lesson.lector + '</li><li>' +
                     lesson.description + '</li></ul></div>');
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/lessons/findAll", true);
    xhttp.send();
}

function recreateAll() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/timeTableManagers/updateAll", true);
    xhttp.send();
}
