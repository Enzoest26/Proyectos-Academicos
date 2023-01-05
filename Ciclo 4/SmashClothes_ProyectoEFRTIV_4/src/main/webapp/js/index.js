/**
 * 
 */
 
 $(document).ready(function(){
    $(window).scroll(function(){
        /*if(this.scrollY > 20){
            $('.navbar').addClass("sticky");
        }else{
            $('.navbar').removeClass("sticky");
        }*/
        // subir con el boton hacia el inicio
        if(this.scrollY > 500){
            $('.scroll-arriba').addClass("show");
        }else{
            $('.scroll-arriba').removeClass("show");
        }
    });

    // boton subir
    $('.scroll-arriba').click(function(){
        $('html').animate({scrollTop: 0});
        $('html').css("scrollBehavior", "auto");
    });
});