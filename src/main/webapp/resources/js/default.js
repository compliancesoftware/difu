var protocol = window.location.protocol;
var host = window.location.host;
var base = protocol+"//"+host;

function buildMsgToSend(text) {
    var body = '<div class="msg-container" sender="I">' +
                    '<div class="msg msg-to">' +
                        '<p>' + text + '</p>' +
                    '</div>' +
                '</div>';

    return body;
}

function buildMsgFromServer(text) {
	var body = '<div class="msg-container" sender="other">' +
				    '<div class="msg msg-from">' +
				        '<p>' + text + '</p>' +
				    '</div>' +
				'</div>';
			
	return body;
}

function send(){
    var texto = $(".input").text();

    if(texto != ''){
        var msg = buildMsgToSend(texto);
    	
    	var url = base+"/difu/sendmessage";
    	var data = "message="+texto+"";
    	var dataType = "json";
    	var success = function(result){
    		var status = result.status;
    		if(status){
    			$(".mensagens").append(msg);
    		}
    	}
    	
    	$.ajax({
    		url: url,
    		method:'POST',
    		data: data,
    		success: success,
    		dataType: dataType
    	});
    }

    $(".input").text('');
    $("html, body").animate({ scrollTop: $(document).height() }, 200);
    $(".input").focus();
}

function setListener(){
	var url = base+"/difu/getmessage";
	var data = "{}";
	var dataType = "json";
	var success = function(result){
		var status = result.status;
		var messages = result.messages;
		
		if(status && messages != '' && messages != undefined && messages.length > 0){
			for(let idx = 0;idx < messages.length; idx++) {
				let msg = buildMsgFromServer(messages[idx]);
				$(".mensagens").append(msg);
			}
		}
	}
	
	setInterval(function(){
		$.ajax({
			url: url,
			method:'POST',
			data: data,
			success: success,
			dataType: dataType
		});
	},1000);
}

function bindEvents(){
    $(".send-button").click(function(){
        send();
    });

    $(".input").keypress(function(event){
        var key = event.key;
        if(key == 'Enter'){
            event.preventDefault();
            send();
        }
    });
    
    setListener();
}

$(document).ready(function(){
    bindEvents();
});