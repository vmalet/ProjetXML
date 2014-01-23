$(document).ready(initpack);
                                        
function initpack(){
    
    //alert('toto');
    $("#detail_pack").hide();

    $(".select_btn").click(function(){

            $("#detail_pack").css('display','block');
            $("#detail_pack2").css('display','none');
    });
    
    $("#detail_pack2").hide();

    $(".select_btn2").click(function(){

            $("#detail_pack2").css('display','block');
            $("#detail_pack").css('display','none');
    });
}  
