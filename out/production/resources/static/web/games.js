$( document ).ready(function() {
        $.ajax({
            method:"GET",
            url:"/api/games"
        }).done(function(data){
        console.log(data);
        $.each(data, function(index, item){
        console.log(item.date);

        var date1 = new Date(item.date);// need to create a new Date to work with a real date
//      since
        console.log(item.date);

        var emails=item.gamePlayers.map(function(gamePlayer){
            return gamePlayer.player.email;
        })

        console.log(item.gamePlayers)

         var list =$("#items");
         $("<li>")
         .text(date1.toLocaleString()) //will replace the content completely
         .append(" : ") //append will attach content
         .append(emails.join(", "))
         .appendTo(list);

        })

        })
    });