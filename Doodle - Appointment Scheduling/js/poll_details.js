var h = 0;
            
            $(document).ready(function() {
            
                $("#add").click(function() {
                    h++;
                    var lastField = $("#interval div:last");
                    var intId = (lastField && lastField.length && lastField.data("idx") + 1) || 1;
                    var fieldWrapper = $("<div class=\"fieldwrapper\" id=\"field" + intId + "\"/>");
                    fieldWrapper.data("idx", intId);
                    var sInterval = $("<input type=\"time\" name=\"sInt" + h + "\" class=\"time\" required/>");
                    var eInterval = $("<input type=\"time\" name=\"eInt" + h + "\" class=\"time\" required/>");
                    var removeButton = $("<input type=\"button\" class=\"pollbutton\" value=\"Delete\" />");
                    
                            
                    removeButton.click(function() {
                        $(this).parent().remove();
                    });
                    
                    fieldWrapper.append(sInterval);
                    fieldWrapper.append(eInterval);
                    fieldWrapper.append(removeButton);
                    $("#interval").append(fieldWrapper);
            });
        });
            
        YUI().use('calendar', 'datatype-date', 'cssbutton',  function(Y) {
            
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth(); //January is 1
            var yyyy = today.getFullYear();
            
            var calendar = new Y.Calendar({
                contentBox: "#mycalendar",
                width:'440px',
                showPrevMonth: true,
                showNextMonth: true,
                minimumDate: new Date(yyyy, mm, dd) , 
                date: new Date()}).render();
                var dtdate = Y.DataType.Date;
            
                calendar.on("selectionChange", function (ev) {
                    var newDate = ev.newSelection[0];
                    Y.one("#selecteddate").setHTML(dtdate.format(newDate));
                    var variable = document.getElementById('selecteddate').innerHTML;
                    document.getElementById("date").value = variable;
                    //window.alert(variable);
                });
        });




